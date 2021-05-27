import {Product} from "../../product/Product";

export interface ShippingPreviewInput{

  customerId: number;
  employeeId: number;
  products: Product[];
  orderStatusId: number;

}
