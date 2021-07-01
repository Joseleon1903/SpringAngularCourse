import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs/index";
import {User} from "./User";
import {Customer} from "./Customer";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient) {}

  getUserByUsername(username: string):Observable<User>{
    let params= new HttpParams();
    params =params.append('username', username);
    params =params.append('email',username);
    return this.http.get<User>(`${this.apiServerUrl}/user/find`, {params});
  }

  getCustomerByCode(code: string):Observable<Customer>{
    let params= new HttpParams();
    params =params.append('customerCode', code);
    return this.http.get<Customer>(`${this.apiServerUrl}/customer/find/code`, {params});
  }

  putUserUpdate(user: User):Observable<User>{
    return this.http.put<User>(`${this.apiServerUrl}/user/update`, user);
  }

}
