import { Observable } from 'rxjs';
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Employee} from "./Employee";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn:'root'
})
export class EmployeeService{

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient){}

  public getEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.apiServerUrl}/employee`);
  }

  public getEmployeeById(id: number): Observable<Employee>{
    return this.http.get<Employee>(`${this.apiServerUrl}/employee/find/${id}`);
  }

  public addEmployeesFullTime(employee:Employee): Observable<Employee>{
    return this.http.post<Employee>(`${this.apiServerUrl}/employee/full/time/add`, employee);
  }

  public addEmployeesPartTime(employee:Employee): Observable<Employee>{
    return this.http.post<Employee>(`${this.apiServerUrl}/employee/part/time//add`, employee);
  }

  public updateEmployees(employee:Employee): Observable<Employee>{
    return this.http.put<Employee>(`${this.apiServerUrl}/employee/full/time//update`, employee);
  }

  public deleteEmployees(employeeId:number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/employee/delete/${employeeId}`);
  }

}
