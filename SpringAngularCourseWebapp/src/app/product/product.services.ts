import { Observable } from 'rxjs';
import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Product} from "./Product";
import {environment} from "../../environments/environment";
import {Pagination} from "../utils/Pagination";
import { catchError } from 'rxjs/operators';
import {AppError} from "../utils/app-error";
import {Category} from "./Category";
import {ProductInputFilter} from "./ProductInputFilter";

@Injectable({
  providedIn:'root'
})
export class ProductService{

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient){}

  public getProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(`${this.apiServerUrl}/product`);
  }

  public findProductById(id: number): Observable<Product>{
    return this.http.get<Product>(`${this.apiServerUrl}/product/${id}`);
  }

  getPaginatedProducts(page: Pagination): Observable<Product[]>{
    //params
    let params = new HttpParams().set('page', page.page+'').set('size', page.size+'');
    return this.http.get<Product[]>(`${this.apiServerUrl}/product/paginated`, {params});
  }

  getPaginatedProductsWithFilter(page: Pagination, filter?: ProductInputFilter): Observable<Product[]>{
    //params
    let params= new HttpParams();
    params =params.append('page', page.page+'');
    params =params.append('size', page.size+'');


    if(filter.category && filter.category != 'All'){
      console.log('category Id '+filter.category );
      params = params.append('categoryId' , filter.category+'')
    }

    if(filter.minPrice){
      params =params.append('minPrice', filter.minPrice+'')
    }
    if(filter.maxPrice){
      params =params.append('maxPrice', filter.maxPrice+'')
    }

    if(filter.keyword){
      params =params.append('keyword',filter.keyword );
    }
    console.log('param query '+params );

    return this.http.get<Product[]>(`${this.apiServerUrl}/product/paginated/filter`, {params});
  }

  addProduct(product:Product){
    return this.http.post(`${this.apiServerUrl}/product/create`,product ).pipe(
      // "catchError" instead "catch"
      catchError(error => {
        return Observable.throw(new AppError(error));
      })
    );
  }

  updateProduct(product:Product){
    return this.http.put(`${this.apiServerUrl}/product`, product).pipe(
      // "catchError" instead "catch"
      catchError(error => {
        return Observable.throw(new AppError(error));
      })
    );
  }

  getAllCategory(appName: string): Observable<Category[]>{
    let params = new HttpParams().set('appName', appName+'');
    return this.http.get<Category[]>(`${this.apiServerUrl}/category`, {params});
  }


}
