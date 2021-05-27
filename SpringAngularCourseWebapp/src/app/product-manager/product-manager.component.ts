import {Component, OnInit, Output, EventEmitter} from '@angular/core';
import {ProductService} from "../product/product.services";
import {Product} from "../product/Product";
import {Pagination} from "../utils/Pagination";
import {NgForm} from "@angular/forms";
import {Category} from "../product/Category";
import {HttpErrorResponse} from "@angular/common/http";
import {Router} from "@angular/router";
import {AuthService} from "../auth/authorization.service";
import {BannerInfo, BannerInput} from "../component/panel-banner/BannerInput";

@Component({
  selector: 'product-manager',
  templateUrl: './product-manager.component.html',
  styleUrls: ['./product-manager.component.css']
})
export class ProductManagerComponent implements OnInit {


  activeErrorBanner: Boolean= false;

  error :BannerInput;

  pageIndex= new Array();

  productList : Product[];

  categoryList: Category[];

  productEdit: Product;

  productAdd: Product;

  addProductImage: string = "https://franklinchristianchurch.com/wp-content/uploads/2017/11/Waiting_web.jpg";

  constructor(private productService: ProductService, private router: Router, private authService : AuthService) { }

  ngOnInit(): void {

    this.getProductInSystem();

    this.getProductInSystemPageNumber(10);

  }

  getCategoryCatalog(){
    this.productService.getAllCategory().subscribe(response =>{
      this.categoryList = response;
    }, error=>{
      console.log('error:'+error)
    });

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

    if(!this.authService.isLoggedIn()){
      console.log("need to be sing in the app ");
      this.activeErrorBanner = true;
      this.error={ type: BannerInfo, title:"Required to app login ", content:"Need to be logged in the app for access this functionality" };
      return;
    }

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

  submitAddProduct(addForm:  NgForm){
    console.log("Entering in Add form");

    console.log('Entering in submitForm'+ addForm.value);
    let product :Product = addForm.value;

    if(!addForm.invalid){
      console.log('valid form ');
      this.productService.addProduct(product).subscribe(
        (response)=> {
          console.log("response:"+response);
          console.log('register success');
          this.closeModal();
          addForm.resetForm();
        },
        (error: HttpErrorResponse)=>{
          alert(error.message);
          addForm.resetForm();
        }
      );
    }

  }

  loadProductImage(form: NgForm){
    console.log("try load image");
    this.addProductImage =form.control.get('imagePath').value;
  }

  openAddModal(){
    console.log("entering in onOpenModal");

    if(!this.authService.isLoggedIn()){
      console.log("need to be sing in the app ");
      this.error={ type: BannerInfo, title:"Required to app login ", content:"Need to be logged in the app for access this functionality" };
      this.activeErrorBanner = true;
      return;
    }

    this.getCategoryCatalog();
    const button = document.createElement('button');
    const container = document.getElementById('product-manager');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');
    button.setAttribute('data-target','#product-add-model');
    container.appendChild(button);
    button.click();
  }

  closeModal(){
    document.getElementById('close-modal-add-btn').click();
  }

  closeModalBanner(){
    this.activeErrorBanner = false;
  }

}
