import {ErrorHandler, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import {EmployeeService} from "./employee/employee.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {DestinationComponent} from "./destination/destinations.component";
import {DestinationService} from "./destination/destination.service";
import {SummaryPipe} from "./summary.pipe";
import { PostImageComponent } from './post-image/post-image.component';
import { BootstrapPanelComponent } from './bootstrap-panel/bootstrap-panel.component';
import { InputFormatDirective } from './input-format.directive';
import { ContactFormComponent } from './contact-form/contact-form.component';
import { SingupFormComponent } from './singup-form/singup-form.component';
import { ProductComponent } from './product/product.component';
import {ProductService} from "./product/product.services";
import {AppErrorHandler} from "./utils/app-handler.error";
import {RouterModule} from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { EmployeeComponent } from './employee/employee.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { LoginComponent } from './login/login.component';
import { CreateProfileComponent } from './create-profile/create-profile.component';
import { ProductManagerComponent } from './product-manager/product-manager.component';
import {AuthService} from "./auth/authorization.service";
import { PanelBannerComponent } from './component/panel-banner/panel-banner.component';
import {UserService} from "./user-profile/UserService.services";
import {TodosComponent} from "./animation/todos/todos.component";
import {ZippyComponent} from "./animation/zippy/zippy.component";
import {NgRedux, NgReduxModule} from "ng2-redux";
import { ReduxDemoComponent } from './redux/redux-demo/redux-demo.component';
import {IHomeState, INITIAL_STATE, rootReducer} from "./home/redux/IHomeState";
import {ShippingService} from "./home/shipping/ShippingService.service";
import {HomeService} from "./home/HomeService.service";
import { ShippingHistoryComponent } from './shipping-history/shipping-history.component';
import {ShippingHistoryService} from "./shipping-history/shippinghistory.service";
import {EmployeeDetailComponent} from "./component/panel-employee-detail/panel-employee-detail.component";
import {CustomerDetailComponent} from "./component/panel-customer-detail/panel-customer-detail.component";
import { SunMarketComponent } from './sun-market/sun-market.component';
import { MoonMarketComponent } from './moon-market/moon-market.component';
import { MoonNavbarComponent } from './moon-navbar/moon-navbar.component';
import { MoonHomeComponent } from './moon-home/moon-home.component';
import { MoonProductsComponent } from './moon-products/moon-products.component';
import { MoonShoppingCartComponent } from './moon-shopping-cart/moon-shopping-cart.component';
import { MoonCheckoutComponent } from './moon-checkout/moon-checkout.component';
import { MoonOrderSuccessComponent } from './moon-order-success/moon-order-success.component';
import { MoonMyOrdersComponent } from './moon-my-orders/moon-my-orders.component';
import { MoonAdminProductsComponent } from './admin/moon-admin-products/moon-admin-products.component';
import { MoonAdminOrdersComponent } from './admin/moon-admin-orders/moon-admin-orders.component';
import { ProductFormComponent } from './cmp-moon/product-form/product-form.component';
import {MoonProductService} from "./cmp-moon/services/MoonProduct.service";

@NgModule({
  declarations: [
    AppComponent,
    DestinationComponent,
    SummaryPipe,
    PostImageComponent,
    BootstrapPanelComponent,
    InputFormatDirective,
    ContactFormComponent,
    SingupFormComponent,
    ProductComponent,
    HomeComponent,
    NotFoundComponent,
    EmployeeComponent,
    UserProfileComponent,
    LoginComponent,
    CreateProfileComponent,
    ProductManagerComponent,
    PanelBannerComponent,
    TodosComponent,
    ZippyComponent,
    ReduxDemoComponent,
    ShippingHistoryComponent,
    EmployeeDetailComponent,
    CustomerDetailComponent,
    SunMarketComponent,
    MoonMarketComponent,
    MoonNavbarComponent,
    MoonHomeComponent,
    MoonProductsComponent,
    MoonShoppingCartComponent,
    MoonCheckoutComponent,
    MoonOrderSuccessComponent,
    MoonMyOrdersComponent,
    MoonAdminProductsComponent,
    MoonAdminOrdersComponent,
    ProductFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    NgReduxModule,
    RouterModule.forRoot([
      {
        path: 'sun/home',
        component: HomeComponent
      },
      {
        path: 'sun/employee',
        component: EmployeeComponent
      },
      {
        path: 'sun/product/manager',
        component: ProductManagerComponent
      },
      {
        path: 'sun/history/shipping',
        component: ShippingHistoryComponent
      },
      {
        path: 'sun/login/:appName',
        component: LoginComponent
      },
      {
        path: 'moon/login/:appName',
        component: LoginComponent
      },
      {
        path: 'user/creation/:appName',
        component: CreateProfileComponent
      },
      {
        path: 'sun/user/profile/:username',
        component: UserProfileComponent
      },
      {
        path: 'moon/home',
        component: MoonHomeComponent
      },

      {
        path: 'moon/my-orders',
        component: MoonMyOrdersComponent
      },
      {
        path: 'moon/products',
        component: MoonProductsComponent
      },
      {
        path: 'moon/shopping-cart',
        component: MoonShoppingCartComponent
      },
      {
        path: 'moon/checkout',
        component: MoonCheckoutComponent
      },
      {
        path: 'moon/order-success',
        component: MoonOrderSuccessComponent
      },
      {
        path: 'moon/admin/orders',
        component: MoonAdminOrdersComponent
      },
      {
        path: 'moon/admin/products',
        component: MoonAdminProductsComponent
      },
      {
        path: 'moon/admin/products/new',
        component: ProductFormComponent
      },
      {
        path: 'moon/admin/products/:id',
        component: ProductFormComponent
      },

      {
        path: '**',
        component: NotFoundComponent
      },
    ])
  ],
  providers: [
    EmployeeService,
    DestinationService,
    ProductService,
    AuthService,
    UserService,
    ShippingService,
    ShippingHistoryService,
    HomeService,
    MoonProductService,
    {provide: ErrorHandler, useClass: AppErrorHandler}],
  bootstrap: [AppComponent]
})
export class AppModule {

  constructor(ngRedux: NgRedux<IHomeState>){
    ngRedux.configureStore(rootReducer, INITIAL_STATE );
  }
}
