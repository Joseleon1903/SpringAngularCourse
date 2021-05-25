import { Component, OnInit } from '@angular/core';
import {ProductService} from "../product/product.services";
import {Product} from "../product/Product";
import {Pagination} from "../utils/Pagination";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'product-manager',
  templateUrl: './product-manager.component.html',
  styleUrls: ['./product-manager.component.css']
})
export class ProductManagerComponent implements OnInit {


  pageIndex= new Array();
  productList : Product[];

  productEdit: Product;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {

    this.getProductInSystem();

    this.getProductInSystemPageNumber(10);

  }

  getProductInSystem(){
    let pages : Pagination = {page: 0, size:10};
    this.productService.getPaginatedProducts(pages)
      .subscribe(response =>{
          this.productList = response;
        },
        error=>{
          console.log('error:'+error)
      });
  }

  getProductInSystemPageNumber(size: number){

    this.productService.getProducts()
      .subscribe(response =>{
          let listSize:number = response.length;
          let pageN = listSize/size;
          for (let _i = 0; _i <= pageN; _i++) {
            this.pageIndex.push(_i);
          }
      },
      error=>{
        console.log('error:'+error)
      });
  }

  getProductInSystemWithPage(page : number){

    let pages : Pagination = {page: page, size:10};

    this.productService.getPaginatedProducts(pages)
      .subscribe(response =>{
          this.productList = response;
        },
        error=>{
          console.log('error:'+error)
        });
  }

  getProductById(id:number){
    this.productService.findProductById(id)
      .subscribe(response =>{
          this.productEdit = response;
        },
        error=>{
          console.log('error:'+error)
        });
  }

  openEditModal(id:number){
    console.log("entering in onOpenModal");
    this.getProductById(id);
    const button = document.createElement('button');
    const container = document.getElementById('product-manager');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');

    button.setAttribute('data-target','#product-edit-model');
    container.appendChild(button);
    button.click();
  }

  submitUpdateProduct(editForm:  NgForm){

    console.log("entering update");
    this.productEdit.name = editForm.control.get('name').value;
    this.productEdit.description = editForm.control.get('description').value;
    this.productEdit.price = editForm.control.get('price').value;
    this.productEdit.discountPercent = editForm.control.get('discountPercent').value;
    this.productEdit.imagePath = editForm.control.get('imagePath').value;

    this.productService.updateProduct(this.productEdit)
      .subscribe(response =>{
        console.log("product update");
        this.getProductInSystem();
        this.closeModal();
        },
        error=>{
          console.log('error:'+error)
        });
  }

  closeModal(){
    document.getElementById('close-modal-btn').click();
  }


}
