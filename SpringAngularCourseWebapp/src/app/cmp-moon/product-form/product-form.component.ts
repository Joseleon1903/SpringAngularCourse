import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../product/product.services";
import {MoonProductService} from "../services/MoonProduct.service";
import {MoonProduct} from "../types/MoonProduct";
import {Category} from "../../product/Category";

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {

  constructor(private productService: ProductService, private moonService: MoonProductService) { }

  categoryList: any;

  ngOnInit(): void {
    this.loadCategoryCatalog();
  }

  loadCategoryCatalog(){

    this.productService.getAllCategory('Moon')
      .subscribe(response =>{
          this.categoryList = response;
        },
        error=>{
          alert("error in server side check console")
          console.log('error:'+error)
        });
  }

  save(formValues: any){

    console.log('category Id '+formValues.category);
    let category : Category = {id: formValues.category};
    let input: MoonProduct = {title: formValues.title, category:category, urlImage:formValues.urlImage, price:formValues.price};
    this.moonService.addMoonProduct(input).subscribe((response)=>{
      console.log("product add succefully: "+response );
    })

  }

}
