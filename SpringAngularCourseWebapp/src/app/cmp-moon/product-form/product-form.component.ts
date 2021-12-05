import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../product/product.services";
import {MoonProductService} from "../services/MoonProduct.service";
import {MoonProduct} from "../types/MoonProduct";
import {Category} from "../../product/Category";
import {NgForm} from "@angular/forms";
import {BannerInfo, BannerInput} from "../../component/panel-banner/BannerInput";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {

  constructor(private productService: ProductService, private moonService: MoonProductService, private router: Router,  private route: ActivatedRoute) { }

  categoryList: any;

  product : MoonProduct ={id : 0, title: '', urlImage: '', price:0 , category: {}};

  showMessage: boolean = false;

  messageBanner : BannerInput;

  ngOnInit(): void {

    this.loadProduct();
    this.loadCategoryCatalog();
    this.showMessage = false;
  }

  loadProduct(){
    console.log("load product if exist for edit");
    let id = this.route.snapshot.paramMap.get("id");

    if(id){
      this.productService.getProductFindById('Moon', id)
        .subscribe(response =>{
          this.product = response;
        },
        error=>{
          alert("error in server side check console")
          console.log('error:'+error)
        });
    }

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

  save(formValues : NgForm){

    console.log('category Id '+formValues.value['category']);
    let category : Category = {id:formValues.value['category']};
    let input: MoonProduct = {title: formValues.value['title'], category:category, urlImage:formValues.value['urlImage'], price: formValues.value['price']};

    if(this.product){
      input = this.product;
      console.log('update product id '+input.id);
    }

    this.moonService.addMoonProduct(input).subscribe((response)=>{
      console.log("product add succefully: "+response );
      formValues.resetForm();
      let messageFormat = ' product Id: '+response.id +
                          ' title: '+ response.title +
                          ' price: ' + response.price +
                          ' category : ' + response.category.name;
      this.messageBanner = { type: BannerInfo, title: 'Successes Product Registration', content: 'PRODUCT - '+ messageFormat};
      this.showMessage = true;
    });

  }

  deleteProduct(){
    console.log("entering delete product");

    if(this.product){
      console.log("delete product Id "+ this.product.id);
      this.productService.deleteProductById('Moon', this.product.id+'');
      console.log("product delete succefully: " );
      let messageFormat = ' product Id: '+this.product.id +' is deleted';
      this.messageBanner = { type: BannerInfo, title: 'Successes Product Elimination', content: 'PRODUCT - '+ messageFormat};
      this.showMessage = true;
    }
  }

  closeModal(){
    console.log('close modal');
    this.showMessage = false;
    this.router.navigate(['/moon/admin/products']);
  }

}
