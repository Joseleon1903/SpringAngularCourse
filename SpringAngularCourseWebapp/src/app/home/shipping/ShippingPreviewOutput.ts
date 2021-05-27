import {Product} from "../../product/Product";

export interface ShippingPreviewOutput{

  orderCode: string;
  orderNumber: string;
  products: Product[];
  status: string;
  productTotalPrice: number;
  taxCharge: number;
  totalPrice: number;

}
