import {Injectable} from "@angular/core";
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {ShippingPreviewInput} from "./ShippingPreviewInput";
import {Observable} from "rxjs/index";
import {ShippingPreviewOutput} from "./ShippingPreviewOutput";
import {ShippingDestinationInput} from "./ShippingDestinationInput";
import {ShippingPaymentInput} from "./ShippingPaymentInput";

@Injectable({
  providedIn:'root'
})
export class ShippingService{

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient){}

  public postShippingPreview(shippingPreview :ShippingPreviewInput): Observable<ShippingPreviewOutput>{
    return this.http.post<ShippingPreviewOutput>(`${this.apiServerUrl}/shopping/card/add/preview`, shippingPreview);
  }

  public putShippingDestination(shippingDestination :ShippingDestinationInput ){
    return this.http.put<ShippingPreviewOutput>(`${this.apiServerUrl}/shopping/card/update/shipping`, shippingDestination);
  }

  public putShippingPayment(shippingPayment :ShippingPaymentInput ){
    return this.http.put<ShippingPreviewOutput>(`${this.apiServerUrl}/shopping/card/update/payment`, shippingPayment);
  }

}
