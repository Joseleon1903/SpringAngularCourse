export interface ShippingHistoryTransaction {

  orderCode:string;
  orderNumber: string;
  creationDate: Date;
  status: string;
  customerCode: string;
  employeeCode: string;
  totalPrice: number;
  cardType: string;
  paymentType:string;
  shippingCode: string;
  deliveryDate: Date;
  destinationName: string;

}
