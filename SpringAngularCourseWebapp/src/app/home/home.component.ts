import {Component, HostListener, OnInit} from '@angular/core';
import {Product} from "../product/Product";
import {ShippingService} from "./shipping/ShippingService.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {

  sizeList: number = 10;

  showDetailModal: boolean;

  showShippingModal: boolean;

  currentProduct:Product;

  shippingMode: string = 'Init';

  constructor(private shippingService: ShippingService) { }

  ngOnInit(): void {
  }

  moreProductBtn(){
    console.log("rendered more product if exist");
    this.sizeList += 3;
    console.log("size list = "+ this.sizeList);
  }


  onPressProductViewDetail(product: Product){
    console.log("entering in  method onPressProductViewDetail");
    console.log("param: "+product.name);
    this.currentProduct = product;
    const button = document.createElement('button');
    const container = document.getElementById('content-adjust');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');
    button.setAttribute('data-target','#product-detail-model');
    container.appendChild(button);
    button.click();
  }

  closeModalViewProduct(){
    document.getElementById('close-modal-btn').click();
  }

  nextModalProductShipping(){

    if(this.shippingMode == 'Destination-Chooser'){
      console.log("Destination Phase")


      //next
      this.shippingMode = ''
    }
  }

  onPressProductAddShipping(product: Product){
    console.log("entering in  method onPressProductAddShipping");
    console.log("param: "+product.name);
    this.currentProduct = product;
    const button = document.createElement('button');
    const container = document.getElementById('content-adjust');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');
    button.setAttribute('data-target','#product-shipping-model');
    container.appendChild(button);
    button.click();
  }

  @HostListener('window:scroll', ['$event']) OnScrollProduct(e: Event): void {
    if(window.scrollY == 0 && this.sizeList > 20 ){
      this.sizeList = 10;
    }
  }

}
