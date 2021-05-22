import { Component, OnInit } from '@angular/core';
import {environment} from "../../environments/environment";
import {ProductService} from "./product.services";
import {Pagination} from "../utils/Pagination";
import {Product} from "./Product";

@Component({
  selector: 'product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  private apiServerUrl = environment.apiBaseUrl;

  products : Product[];

  constructor(private productService : ProductService) {}

  ngOnInit(): void {

    var pages : Pagination = {page: 0, size:5};

    this.productService.getPaginatedProducts(pages)
      .subscribe(response =>{
          this.products = response;
      },
      error=>{

        alert("error in server side check console")
        console.log('error:'+error)

      });
  }

}
