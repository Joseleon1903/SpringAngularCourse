import {ShippingService} from "./shipping/ShippingService.service";
import {IHomeState} from "./redux/IHomeState";
import {NgRedux} from "ng2-redux";
import {UserService} from "../user-profile/UserService.services";
import {EmployeeService} from "../employee/employee.service";
import {DestinationService} from "../destination/destination.service";
import {Injectable} from "@angular/core";
import {
  FETCH_CUSTOMER_DETAIL_SUCCESS, FETCH_EMPLOYEE_DETAIL_SUCCESS,
  FETCH_PRODUCT_DETAIL, PUT_DESTINATION_SUCCESS, PUT_PAYMENT_SHIPPING_SUCCESS, PUT_PEVIEW_SHIPPING_SUCCESS
} from "./redux/HomeAction";
import {Product} from "../product/Product";
import {Destination} from "../destination/Destination";
import { Observable } from 'rxjs';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn:'root'
})
export class HomeService{

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private shippingService:ShippingService,
              private http:HttpClient,
              private userService: UserService,
              private employeeService: EmployeeService,
              private destinationService: DestinationService,
              private ngRedux: NgRedux<IHomeState>){}


  loadBuyShippingInformation(product : Product){
    this.ngRedux.dispatch({type: FETCH_PRODUCT_DETAIL, payload: product});

    this.userService.getUserByUsername('admin').subscribe(response=>{
      console.log("fetch User : from server");
      this.ngRedux.dispatch({type: FETCH_CUSTOMER_DETAIL_SUCCESS, payload: response });

    });

    this.employeeService.getEmployeeById(1).subscribe(respose=>{
      console.log("fetch Employee from server");
      this.ngRedux.dispatch({type: FETCH_EMPLOYEE_DETAIL_SUCCESS, payload: respose });
    });

  }

  sendShippingPreview(customerIdIn: number, employeeIdIn: number,productsIn: number, orderStatusIdIn: number  ){
    console.log("entering in sendShippingPreview");
    this.shippingService.postShippingPreview({
      employeeId: employeeIdIn,customerId: customerIdIn,productId: productsIn,orderStatusId: orderStatusIdIn
    }).subscribe(response=>{
      console.log("response shipping preview");
      this.ngRedux.dispatch({type: PUT_PEVIEW_SHIPPING_SUCCESS, payload: response });
    });

  }

  sendDestinationShipping(orderCodeIn: string,orderNumberIn: string, shippingCodeIn: string,destinationIdIn: number, deliveryDateIn:string  ){
    console.log("entering in sendDestinationShipping");

    this.shippingService.putShippingDestination({shippingCode: orderCodeIn,
      orderNumber: orderNumberIn,
      orderCode: orderCodeIn,
      deliveryDate: deliveryDateIn,
      destinationId: destinationIdIn,
    }).subscribe(()=>{
      this.ngRedux.dispatch({type: PUT_DESTINATION_SUCCESS});
    });

  }

  sendPaymentShipping( orderCodeIn: string, paymentTypeIn: number, cardTypeIn: number, cardNumberIn: string, cardHolderNameIn: string,
                  accountNumberIn: string,
                  expireDateIn:string,
                  commentIn: string )
  {
    console.log("entering in sendDestinationShipping");

    this.shippingService.putShippingPayment({orderCode: orderCodeIn,
      paymentType: paymentTypeIn,
      cardType: cardTypeIn,
      cardNumber: cardNumberIn,
      cardHolderName: cardHolderNameIn,
      accountNumber: accountNumberIn,
      expireDate: expireDateIn,
      comment: commentIn
    }).subscribe(()=>{
      this.ngRedux.dispatch({type: PUT_PAYMENT_SHIPPING_SUCCESS});
    });
  }

  getState(){
    return this.ngRedux.getState();
  }

  getDestinations():Observable<Destination[]>{
    return this.http.get<Destination[]>(`${this.apiServerUrl}/destination`);
  }

}
