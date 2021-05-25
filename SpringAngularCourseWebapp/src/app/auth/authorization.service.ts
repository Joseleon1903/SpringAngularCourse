import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {UserInput} from "../login/UserInput";
import {Observable} from "rxjs/index";
import {AngularUser} from "./AngularUser";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient) {}

  login(user: UserInput):Observable<AngularUser>{
    return this.http.post<AngularUser>(`${this.apiServerUrl}/login` , user);
  }

  logout(){
    localStorage.removeItem('userId');
    localStorage.removeItem('username');
    localStorage.removeItem('role');
    localStorage.removeItem('status');
    localStorage.removeItem('profileUrl');
  }

  isLoggedIn(){
    let storeUsername = localStorage.getItem('username');
    if(storeUsername){
      return true;
    }
    return false;
  }

  get currentUser(): AngularUser{
    if(this.isLoggedIn()){
      let user : AngularUser = new AngularUser();
      user.username = localStorage.getItem('username');
      user.userId = +localStorage.getItem('userId');
      user.status = localStorage.getItem('status');
      user.role = localStorage.getItem('role');
      user.profileUrl = localStorage.getItem('profileUrl');
      return user;
    }
    return null;
  }

}
