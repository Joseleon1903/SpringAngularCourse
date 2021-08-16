import { ComponentFixture, TestBed } from '@angular/core/testing';


import {By} from "@angular/platform-browser";
import {HttpClientModule} from "@angular/common/http";
import {ProductComponent} from "./product.component";
import {ProductService} from "./product.services";
import {FormsModule} from "@angular/forms";
import {Observable} from "rxjs/Rx";
import {Product} from "./Product";
import {Category} from "./Category";

describe('ProductComponent', () => {
  let component: ProductComponent;
  let fixture: ComponentFixture<ProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductComponent ],
      providers: [ ProductService],
      imports: [HttpClientModule, FormsModule]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });


  // xit('should load category from the service ', () => {
  //
  //   let productService = TestBed.get(ProductService);
  //
  //   let listCategory: Category[] = [{id: 1, name:'test1', code: 'TT1', active: true},{id: 2, name:'test2' , code: 'TT2', active: true}, {id: 3, name:'test3',code: 'TT3', active: true} ];
  //
  //   spyOn(productService, 'getAllCategory').and.returnValue(Observable.from(listCategory));
  //
  //   fixture.detectChanges();
  //
  //   expect(component.categories.length).toBe(3);
  // });




});
