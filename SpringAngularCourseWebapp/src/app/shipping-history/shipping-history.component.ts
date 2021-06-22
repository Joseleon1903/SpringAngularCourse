import { Component, OnInit } from '@angular/core';
import {ShippingHistoryTransaction} from "./ShippingHistoryTransaction";
import {Pagination} from "../utils/Pagination";
import {ShippingHistoryService} from "./shippinghistory.service";
import {CounterType} from "./CounterType";

@Component({
  selector: 'shipping-history',
  templateUrl: './shipping-history.component.html',
  styleUrls: ['./shipping-history.component.css']
})
export class ShippingHistoryComponent implements OnInit {

  shippingTransactionList : ShippingHistoryTransaction[];

  size: number = 5;

  counter: CounterType= {rowRemain: 0, totalRow:0};

  constructor(private shippingHistoryService : ShippingHistoryService) { }

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

}
