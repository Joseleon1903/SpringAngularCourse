import { Observable } from 'rxjs';
import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Product} from "./Product";
import {environment} from "../../environments/environment";
import {Pagination} from "../utils/Pagination";
import { catchError, map } from 'rxjs/operators';
import {AppError} from "../utils/app-error";

@Injectable({
  providedIn:'root'
})
export class ProductService{

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient){}

  public getProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(`${this.apiServerUrl}/product`);
  }

  getPaginatedProducts(page: Pagination): Observable<Product[]>{
    //params
    let params = new HttpParams().set('page', page.page+'').set('size', page.size+'');
    return this.http.get<Product[]>(`${this.apiServerUrl}/product/paginated`, {params});
  }

  addProduct(product:Product){
    return this.http.get(`${this.apiServerUrl}/product/create`).pipe(
      // "catchError" instead "catch"
      catchError(error => {
        return Observable.throw(new AppError(error));
      })
    );
  }

}
