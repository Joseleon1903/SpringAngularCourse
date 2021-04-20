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

      }
    );
  }


}
