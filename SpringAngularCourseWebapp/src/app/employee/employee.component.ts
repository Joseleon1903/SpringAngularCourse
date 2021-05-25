import { Component, OnInit } from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import {Employee} from "./Employee";
import {EmployeeService} from "./employee.service";
import {NgForm} from "@angular/forms";

const FULL_TIME = 'FULL_TIME';
const PART_TIME = 'PART_TIME';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employeeType = FULL_TIME;

  public employees : Employee[];
  public editEmployee : Employee;
  public deleteEmployee : Employee;

  public addEmployee: Employee;

  post  = {
    title: 'Work hard, sleep less',
    isFavourite: true
  };

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
    console.log('employee Type :' + this.employeeType);

    if(this.employeeType == FULL_TIME){
      this.employeeService.addEmployeesFullTime(addForm.value).subscribe(
        (response:Employee)=> {
          console.log("response:"+response);
          this.getEmployees();
        },
        (error: HttpErrorResponse)=>{
          alert(error.message);
        }
      );
    }

    if(this.employeeType == PART_TIME){

      this.employeeService.addEmployeesPartTime(addForm.value).subscribe(
        (response:Employee)=> {
          console.log("response:"+response);
          this.getEmployees();
        },
        (error: HttpErrorResponse)=>{
          alert(error.message);
        }
      );
    }

  }

  onChangeEmployeeType(chooser: number){
    if(chooser == 1){
      this.employeeType = PART_TIME;
    }else if(chooser == 2){
      this.employeeType = FULL_TIME;
    }
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

  onPostChange(isActive:boolean){

    console.log('post component change');
    console.log("isActive Image param : "+isActive);

  }
}
