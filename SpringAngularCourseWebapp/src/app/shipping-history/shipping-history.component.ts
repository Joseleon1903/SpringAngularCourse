import { Component, OnInit } from '@angular/core';
import {ShippingHistoryTransaction} from "./ShippingHistoryTransaction";
import {Pagination} from "../utils/Pagination";
import {ShippingHistoryService} from "./shippinghistory.service";

@Component({
  selector: 'shipping-history',
  templateUrl: './shipping-history.component.html',
  styleUrls: ['./shipping-history.component.css']
})
export class ShippingHistoryComponent implements OnInit {

  shippingTransactionList : ShippingHistoryTransaction[];

  size: number = 10;

  constructor(private shippingHistoryService : ShippingHistoryService) { }

  ngOnInit(): void {

    this.loadShippingTransactionData();
  }

  loadShippingTransactionData(){

    let pages : Pagination = {page: 0, size:this.size};
    this.shippingHistoryService.getPaginatedShippingTransaction(pages)
      .subscribe(response =>{
          this.shippingTransactionList = response;
        },
        error=>{
          alert("error in server side check console")
          console.log('error:'+error)
        });
  }

}
