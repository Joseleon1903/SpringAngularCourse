import {Component, HostListener, OnInit} from '@angular/core';
import {Product} from "../product/Product";
import {ShippingService} from "./shipping/ShippingService.service";
import {IHomeState} from "./redux/IHomeState";
import {NgRedux, select} from "ng2-redux";
import {HomeService} from "./HomeService.service";
import {AuthService} from "../auth/authorization.service";
import {User} from "../user-profile/User";
import {Customer} from "../user-profile/Customer";
import {Destination} from "../destination/Destination";
import {NgForm} from "@angular/forms";

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

  switchShippingMode: string;

  destinationList?: Destination[];



  @select((s:IHomeState) =>s.customerUserName) customerName?: any;
  @select((s:IHomeState) =>s.customerId) customerId?: any;

  @select((s:IHomeState) =>s.employeeName) employeeName?: any;
  @select((s:IHomeState) =>s.employeeId) employeeId?: any;

  @select((s:IHomeState) =>s.productName) productName?: any;
  @select((s:IHomeState) =>s.productId) productCode?: any;

  @select((s:IHomeState) =>s.orderCode) orderDetailCode?: any;

  @select((s:IHomeState) =>s.orderNumber) orderDetailNumber?: any;
  @select((s:IHomeState) =>s.totalPrice) orderDetailTotalPrice?: any;
  @select((s:IHomeState) =>s.taxCharge) orderDetailTaxCharge?: any;
  @select((s:IHomeState) =>s.productTotalPrice) productTotalPrice?: any;



  constructor(private homeService: HomeService, private authService: AuthService) { }

  ngOnInit(): void {
    this.switchShippingMode= 'LOAD_SHIPPING';
    this.homeService.getDestinations().subscribe(response=>{
      this.destinationList =response;
    });
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

  nextModalProductShipping(form : NgForm){
    if(this.switchShippingMode == 'LOAD_SHIPPING'){
      console.log("Destination Phase");
      //next
      let customerIdIn = this.homeService.getState().customerId;
      let employeeIdIn= this.homeService.getState().employeeId;
      let productsIn = this.homeService.getState().productId;
      let orderStatusIdIn: number = 5;
      this.homeService.sendShippingPreview(customerIdIn, employeeIdIn, productsIn, orderStatusIdIn);
      this.switchShippingMode = 'CHOOSE_DESTINATION';
      return;
    }

    if(this.switchShippingMode =='CHOOSE_DESTINATION'){
      let orderCode = this.homeService.getState().orderCode;
      let orderNumber= this.homeService.getState().orderNumber;
      let shippingCode = 'SHOPPING_'+this.homeService.getState().orderNumber;
      //yyyy-MM-dd HH:mm:ss a
      let date ='2022-12-10 10:45:00 AM';
      let destinationId = form.control.get('destinationId').value;
      this.homeService.sendDestinationShipping(orderCode, orderNumber, shippingCode, destinationId, date);
      this.switchShippingMode = 'CHOOSE_PAYMENT';
      return;
    }

    if(this.switchShippingMode =='CHOOSE_PAYMENT'){

      let orderCode = this.homeService.getState().orderCode;
      let paymentType = form.control.get('paymentType').value;
      let cardType = form.control.get('cardType').value;
      let cardNumber = form.control.get('cardNumber').value;
      let cardHolderName = form.control.get('cardHolderName').value;
      let accountNumber = form.control.get('accountNumber').value;
      let expireDate = form.control.get('expireDate').value;
      let comment = form.control.get('comment').value;

      console.log("payment info : ");
      console.log("paymentType: " +paymentType);
      console.log("cardType: " +cardType);
      console.log("cardNumber: " +cardNumber);
      console.log("cardHolderName: " +cardHolderName);
      console.log("accountNumber: " +accountNumber);
      console.log("expireDate: " +expireDate);
      console.log("comment: " +comment);

      this.homeService.sendPaymentShipping(orderCode,paymentType, cardType, cardNumber, cardHolderName,accountNumber, expireDate, comment);
      this.switchShippingMode = 'TRANSACTION_INFO';
      return;
    }

  }

  onPressProductAddShipping(product: Product){

    if(this.authService.isLoggedIn()){
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

      console.log("call loadBuyShippingInformation");
     this.homeService.loadBuyShippingInformation(product);
    }
    else{
      alert("user is not logger");
    }

  }

  onCloseModal(){


  }

  @HostListener('window:scroll', ['$event']) OnScrollProduct(e: Event): void {
    if(window.scrollY == 0 && this.sizeList > 20 ){
      this.sizeList = 10;
    }
  }

}
