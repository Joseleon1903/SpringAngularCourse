import { Component, OnInit } from '@angular/core';
import {ShippingHistoryTransaction} from "./ShippingHistoryTransaction";
import {Pagination} from "../utils/Pagination";
import {ShippingHistoryService} from "./shippinghistory.service";
import {CounterType} from "./CounterType";
import {Employee} from "../employee/Employee";
import {EmployeeService} from "../employee/employee.service";
import {HttpErrorResponse} from "@angular/common/http";
import {UserService} from "../user-profile/UserService.services";
import {Customer} from "../user-profile/Customer";

@Component({
  selector: 'shipping-history',
  templateUrl: './shipping-history.component.html',
  styleUrls: ['./shipping-history.component.css']
})
export class ShippingHistoryComponent implements OnInit {

  shippingTransactionList : ShippingHistoryTransaction[];

  showEmployeeDetail: Boolean = false;
  rawEmployee: Employee;

  showCustomerDetail: Boolean = false;
  rawCustomer: Customer;

  size: number = 5;

  counter: CounterType= {rowRemain: 0, totalRow:0};

  constructor(private shippingHistoryService : ShippingHistoryService,
              private employeeService: EmployeeService,
              private userService: UserService) { }

  ngOnInit(): void {
    this.loadShippingTransactionData(0, this.size);
    this.loadDataCounter(0, this.size);
  }

  loadShippingTransactionData(pageIn : number, sizeIn:number){

    let pages : Pagination = {page: pageIn, size:sizeIn};
    this.shippingHistoryService.getPaginatedShippingTransaction(pages)
      .subscribe(response =>{
          this.shippingTransactionList = response;
        },
        error=>{
          alert("error in server side check console")
          console.log('error:'+error)
        });
  }

  loadDataCounter( pageIn : number, sizeIn:number){
    let pages : Pagination = {page: pageIn, size:sizeIn};
    this.shippingHistoryService.getPaginatedShippingTransactionCounter(pages)
      .subscribe(response =>{
          this.counter = response;
        },
        error=>{
          alert("error in server side check console")
          console.log('error:'+error)
        });
  }

  hasMoreData():Boolean{
    if(this.counter.rowRemain > 0){
      return false;
    }
    return true;
  }

  showMeMore(){
    console.log("on press showMeMore");
    this.size +=5;
    this.loadShippingTransactionData(0, this.size);
    this.loadDataCounter(0, this.size);
  }

  onClickRowName(columnName:string, value:string){
    console.log("method : onClickRowName");
    console.log("Param columnName: "+columnName);
    console.log("Param value: "+value);

    //show employee detail EmployeeCode
    if(columnName == 'EmployeeCode' ){
      console.log("show employee detail");

      this.employeeService.getEmployeeByCode(value).subscribe(
        (response : Employee) =>{
          this.rawEmployee = response;
          this.showEmployeeDetail =true;
        },
        (error: HttpErrorResponse) =>{
          alert(error.message);
        }
      );
    }

    //show customer detail CustomerCode
    if(columnName == 'CustomerCode' ){
      console.log("show customer detail");

      this.userService.getCustomerByCode(value).subscribe(
        (response : Customer) =>{
          this.rawCustomer = response;
          console.log("customer service reposne: "+ this.rawCustomer.id);

          this.showCustomerDetail =true;
        },
        (error: HttpErrorResponse) =>{
          alert(error.message);
        }
      );
    }

  }

  closeModalDetail(columnName:string){

    switch(columnName){
      case 'EmployeeCode':
        console.log("close emplyee detail");
        this.showEmployeeDetail = false;
        break;

      case 'CustomerCode':
        console.log("close customer detail");
        this.showCustomerDetail = false;
        break;

    }

  }

}
