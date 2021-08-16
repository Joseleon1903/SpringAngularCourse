import {
  ChangeDetectionStrategy, Component, Input, OnChanges, OnInit, Output, EventEmitter,
  SimpleChanges
} from '@angular/core';
import {ProductService} from "./product.services";
import {Pagination} from "../utils/Pagination";
import {Product} from "./Product";
import {Category} from "./Category";
import {NgForm} from "@angular/forms";
import {ProductInputFilter} from "./ProductInputFilter";

@Component({
  selector: 'product-market',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
  changeDetection: ChangeDetectionStrategy.Default
})
export class ProductComponent implements OnInit, OnChanges {

  constructor(private productService : ProductService) {}

  @Input('size') size : number;

  @Output('onPressDetail') onPressDetail = new EventEmitter();

  @Output('onPressShipping') onPressAddCar = new EventEmitter();

  products : Product[];

  categories: Category[];

  ngOnChanges(changes: SimpleChanges): void {
    console.log("values of component ar change");
    this.loadProduct();
  }

  ngOnInit(): void {

    this.loadProduct();

    this.loadCategory();
  }

  loadProduct(){

    let pages : Pagination = {page: 0, size:this.size};
    this.productService.getPaginatedProducts(pages)
      .subscribe(response =>{
          this.products = response;
        },
        error=>{
          alert("error in server side check console")
          console.log('error:'+error)
        });
  }

  loadCategory(){

    this.productService.getAllCategory('Sun')
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


  onPressDetailProduct(product: Product){
    this.onPressDetail.emit(product);
  }

  onPressAddCarProduct(product: Product){
    this.onPressAddCar.emit(product);
  }

}
