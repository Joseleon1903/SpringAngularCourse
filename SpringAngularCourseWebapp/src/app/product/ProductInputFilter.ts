import {Category} from "./Category";

export interface ProductInputFilter{
  category?: string;
  minPrice?: number;
  maxPrice?: number;
  keyword?: string;
}
