import { Component, OnInit } from '@angular/core';
import {Category} from "../../product/Category";
import {ProductService} from "../../product/product.services";

@Component({
  selector: 'app-moon-admin-products',
  templateUrl: './moon-admin-products.component.html',
  styleUrls: ['./moon-admin-products.component.css']
})
export class MoonAdminProductsComponent implements OnInit {

  productList: any;

  constructor(private productService: ProductService) { }


  ngOnInit(): void {
    this.loadMoonProduct();
  }

  loadMoonProduct(){
    this.productService.getAllProducts('Moon')
      .subscribe(response =>{
          this.productList = response;
        },
        error=>{
          alert("error in server side check console")
          console.log('error:'+error)
        });

  }



}
