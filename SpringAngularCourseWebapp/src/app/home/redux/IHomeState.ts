import {
  FETCH_CUSTOMER_DETAIL, FETCH_CUSTOMER_DETAIL_SUCCESS, FETCH_EMPLOYEE_DETAIL_SUCCESS,
  FETCH_PRODUCT_DETAIL, PUT_DESTINATION_SUCCESS, PUT_PAYMENT_SHIPPING_SUCCESS, PUT_PEVIEW_SHIPPING_SUCCESS,
} from "./HomeAction";
import {Product} from "../../product/Product";
import {User} from "../../user-profile/User";
import {Employee} from "../../employee/Employee";
import {ShippingPreviewOutput} from "../shipping/ShippingPreviewOutput";

export interface IHomeState{

  sysUsername?: string;
  customerUserName?: string;
  customerId?: number;
  employeeName?: string;
  employeeId?: number;
  productId?:number
  productName?: string;
  destinationId?: number;
  orderCode?: string;
  orderNumber?:string;
  productTotalPrice?:number;
  taxCharge?: number;
  totalPrice?:number;
  lastUpdate: Date;

}

export const  INITIAL_STATE: IHomeState={
  sysUsername : 'ADMIN',
  customerUserName: 'NONE',
  customerId: 0,
  employeeName: 'NONE',
  employeeId: 0,
  productId: 0,
  productName: 'NONE',

  lastUpdate: new Date()
};

export function rootReducer(state: IHomeState , action: any): IHomeState{

  switch (action.type){

    //Object.assign combina diferentes objetos en uno solo
    case FETCH_CUSTOMER_DETAIL: return Object.assign({}, state);

    case FETCH_PRODUCT_DETAIL:
      console.log("Entering in fech product ");
      return Object.assign(state,
      { productName: (action.payload as Product).name , productId: (action.payload as Product).id, lastUpdate: new Date() });

    case FETCH_CUSTOMER_DETAIL_SUCCESS:
       return Object.assign(state, {
        customerUserName: (action.payload as User).customer.firstName,
        customerId: (action.payload as User).customer.id, lastUpdate: new Date() });

    case FETCH_EMPLOYEE_DETAIL_SUCCESS:
      return Object.assign(state, {
        employeeName: (action.payload as Employee).name,
        employeeId: (action.payload as Employee).id, lastUpdate: new Date() });

    case PUT_DESTINATION_SUCCESS:
      return Object.assign(state, {lastUpdate: new Date() });

    case PUT_PEVIEW_SHIPPING_SUCCESS:
      return Object.assign(state, {
        orderCode: (action.payload as ShippingPreviewOutput).orderCode,
        orderNumber: (action.payload as ShippingPreviewOutput).orderNumber,
        productTotalPrice: (action.payload as ShippingPreviewOutput).totalPrice,
        taxCharge: (action.payload as ShippingPreviewOutput).taxCharge,
        totalPrice: (action.payload as ShippingPreviewOutput).totalPrice,
        lastUpdate: new Date()});
    case PUT_PAYMENT_SHIPPING_SUCCESS:
      return Object.assign(state, {lastUpdate: new Date()});

  }
  return state;
}
