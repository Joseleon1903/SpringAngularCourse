import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {EmployeeService} from "./employee.service";
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


@NgModule({
  declarations: [
    AppComponent,
    DestinationComponent,
    SummaryPipe,
    PostImageComponent,
    BootstrapPanelComponent,
    InputFormatDirective,
    ContactFormComponent,
    SingupFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserModule,
    ReactiveFormsModule
  ],
  providers: [EmployeeService, DestinationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
