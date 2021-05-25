import {RoleInput} from "./RoleInput";

export interface CreationUser{
  email: string;
  username: string;
  password: string;
  status: string;
  role:RoleInput;
}
