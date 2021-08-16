import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {CreationUser} from "./models/CreationUser";
import {catchError} from "rxjs/internal/operators";
import {Observable} from "rxjs/index";
import {AppError} from "../utils/app-error";
import {RoleInput} from "./models/RoleInput";

@Injectable({
  providedIn:'root'
})

export class CreationService{

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient){}

  creationUser(user:CreationUser, appName: string){
    user.appName = appName;
    return this.http.post(`${this.apiServerUrl}/user/create`, user).pipe(
      // "catchError" instead "catch"
      catchError(error => {
        return Observable.throw(new AppError(error));
      })
    );
  }

  getRoles(): Observable<RoleInput[]>{
    return this.http.get<RoleInput[]>(`${this.apiServerUrl}/role`);
  }





}
