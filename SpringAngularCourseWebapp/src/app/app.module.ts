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
import { MarkertplaceComponent } from './markertplace/markertplace.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { EmployeeComponent } from './employee/employee.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

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
    MarkertplaceComponent,
    NotFoundComponent,
    EmployeeComponent,
    UserProfileComponent
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
        path: 'marketplace',
        component: MarkertplaceComponent
      },
      {
        path: 'employee',
        component: EmployeeComponent
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
    {provide: ErrorHandler, useClass: AppErrorHandler}],
  bootstrap: [AppComponent]
})
export class AppModule { }
