import { Component, OnInit } from '@angular/core';
import {ProductService} from "./product.services";
import {Pagination} from "../utils/Pagination";
import {Product} from "./Product";
import {Category} from "./Category";
import {NgForm} from "@angular/forms";
import {ProductInputFilter} from "./ProductInputFilter";

@Component({
  selector: 'product-market',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products : Product[];

  categories: Category[];

  constructor(private productService : ProductService) {}

  ngOnInit(): void {

    let pages : Pagination = {page: 0, size:20};
    this.productService.getPaginatedProducts(pages)
      .subscribe(response =>{
          this.products = response;
      },
      error=>{
        alert("error in server side check console")
        console.log('error:'+error)
      });

    this.loadCategory();
  }

  loadCategory(){

    this.productService.getAllCategory()
      .subscribe(response =>{
          this.categories = response;
        },
        error=>{
          alert("error in server side check console")
          console.log('error:'+error)
      });
  }

  submitFilter(ngForm : NgForm){

    console.log("apply filter param");

    let paramFilter : ProductInputFilter;
    paramFilter = ngForm.value;

    console.log("log input :"+paramFilter );
    let pages : Pagination = {page: 0, size:15};

    this.productService.getPaginatedProductsWithFilter(pages,paramFilter).subscribe(response =>{
      console.log("get product with filter");
        this.products = [];
        this.products = response;
      },
      error=>{
        alert("error in server side check console")
        console.log('error:'+error)
      });
    ngForm.resetForm();
  }

}
