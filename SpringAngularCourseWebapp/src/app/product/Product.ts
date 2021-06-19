import {Review} from "./Review";
import {Category} from "./Category";

export interface Product{

  id: number;
  name: string;
  description?: string;
  category?: Category;
  productCode?: string;
  price?: number;
  discountPercent?: number;
  imagePath?: string;
  review?: Review;

}
