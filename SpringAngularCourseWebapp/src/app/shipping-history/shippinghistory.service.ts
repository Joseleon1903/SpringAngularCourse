import {Injectable} from "@angular/core";
import {environment} from "../../environments/environment";
import {HttpClient, HttpParams} from "@angular/common/http";
import {ShippingHistoryTransaction} from "./ShippingHistoryTransaction";
import {Observable} from "rxjs/Rx";
import {Pagination} from "../utils/Pagination";
import {CounterType} from "./CounterType";

@Injectable({
  providedIn:'root'
})
export class ShippingHistoryService{

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient){}

  public getPaginatedShippingTransaction(page: Pagination): Observable<ShippingHistoryTransaction[]>{
    let params = new HttpParams().set('page', page.page+'').set('size', page.size+'');
    return this.http.get<ShippingHistoryTransaction[]>(`${this.apiServerUrl}/shipping/history`, {params})
  }

  public getPaginatedShippingTransactionCounter(page: Pagination): Observable<CounterType>{
    let params = new HttpParams().set('page', page.page+'').set('size', page.size+'');
    return this.http.get<CounterType>(`${this.apiServerUrl}/shipping/history/count`, {params})
  }

}
