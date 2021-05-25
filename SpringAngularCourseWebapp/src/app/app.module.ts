import {ErrorHandler, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

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
    ProductManagerComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {
        path: '',
        component: HomeComponent
      },
      {
        path: 'employee',
        component: EmployeeComponent
      },
      {
        path: 'product/manager',
        component: ProductManagerComponent
      },
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'user/creation',
        component: CreateProfileComponent
      },
      {
        path: 'user/profile/:username',
        component: UserProfileComponent
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
    {provide: ErrorHandler, useClass: AppErrorHandler}],
  bootstrap: [AppComponent]
})
export class AppModule { }
