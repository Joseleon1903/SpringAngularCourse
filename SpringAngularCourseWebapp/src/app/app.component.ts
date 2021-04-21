import {Component, OnInit} from '@angular/core';
import {Employee} from "./Employee";
import {EmployeeService} from "./employee.service";
import {HttpErrorResponse} from "@angular/common/http";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  title = 'SpringAngularCourseWebapp';

  public employees : Employee[];
  public editEmployee : Employee;
  public deleteEmployee : Employee;

  constructor(private employeeService : EmployeeService){
    this.employees = [];
  }

  ngOnInit(){

    this.getEmployees();
  }

  public getEmployees(): void {

    this.employeeService.getEmployees().subscribe(
      (response : Employee[]) =>{
        this.employees = response;
        console.log(this.employees);

    },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    );
  }

  public searchEmployee(key:string): void{

    const result : Employee[]= [];

    for(const employee of this.employees){
      if(employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.jobTittle.toLowerCase().indexOf(key.toLowerCase()) !== -1){
        result.push(employee);
      }

    }

    this.employees = result;
    if(result.length ==0 || !key){
      this.getEmployees();
    }
  }

  public onOpenModal(employee : Employee, mode: string): void {

    console.log("entering in onOpenModal");
    const button = document.createElement('button');

    const container = document.getElementById('main-container');

    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');

    if(mode == 'add'){

      button.setAttribute('data-target','#addEmployeeModal');
    }

    if(mode == 'edit'){
      this.editEmployee = employee;
      button.setAttribute('data-target','#updateEmployeeModal');
    }

    if(mode == 'delete'){
      this.deleteEmployee = employee;
      button.setAttribute('data-target','#deleteEmployeeModal');
    }

    container.appendChild(button);

    button.click();

  }

  public onAddEmployee(addForm : NgForm){
    document.getElementById('add-employee-form').click();
    this.employeeService.addEmployees(addForm.value).subscribe(
      (response:Employee)=> {
        console.log("response:"+response);
        this.getEmployees();
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }

  public onUpdateEmployee(employee : Employee) : void{

    document.getElementById('add-employee-form').click();
    this.employeeService.updateEmployees(employee).subscribe(
      (response:Employee)=> {
        console.log("response:"+response);
        this.getEmployees();
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }

  public onDeleteEmployee(employeeId : number) : void{
    this.employeeService.deleteEmployees(employeeId).subscribe(
      (response: void )=> {
        console.log("response:"+response);
        this.getEmployees();
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }


}
