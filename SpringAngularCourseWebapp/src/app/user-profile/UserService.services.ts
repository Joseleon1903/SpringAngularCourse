import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs/index";
import {User} from "./User";

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

}
