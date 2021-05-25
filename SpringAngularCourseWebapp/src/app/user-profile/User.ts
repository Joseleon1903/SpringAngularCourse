import {RoleInput} from "../create-profile/models/RoleInput";
import {Customer} from "./Customer";
export interface User{
  id: number;
  email: string;
  username:string;
  pictureUrl:string;
  password:string;
  creationDay:string;

  lastUpdate: string;
  status: string;
  role: RoleInput;

  customer:Customer;

}
