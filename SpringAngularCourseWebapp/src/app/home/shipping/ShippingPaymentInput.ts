export interface ShippingPaymentInput{

  orderCode: string;
  paymentType: number;
  cardType: number;
  cardNumber: string;
  cardHolderName: string;
  accountNumber: string;
  expireDate:string;
  comment: string;

}
