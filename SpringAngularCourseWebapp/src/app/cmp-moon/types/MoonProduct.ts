import {Category} from "../../product/Category";
export interface MoonProduct{
  id?: number;
  title?: string;
  price?:number;
  category?: Category;
  urlImage?: string;
}
