import { Observable } from 'rxjs';
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {MoonProduct} from "../types/MoonProduct";

@Injectable({
  providedIn:'root'
})
export class MoonProductService{

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient){}

  public addMoonProduct(product :MoonProduct): Observable<MoonProduct>{
    return this.http.post<MoonProduct>(`${this.apiServerUrl}/moon/add/product`, product);
  }


}
