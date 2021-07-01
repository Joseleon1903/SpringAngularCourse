import {Component, Input, Output, EventEmitter} from '@angular/core';
import {Customer} from "../../user-profile/Customer";

@Component({
  selector: 'panel-customer-detail',
  templateUrl: './panel-customer-detail.component.html',
  styleUrls: ['./panel-customer-detail.component.css']
})
export class CustomerDetailComponent {

  @Input('show-modal') showModal?: Boolean;

  @Input('customer-input') customer?: Customer;

  @Output('close-output') closeOutput = new EventEmitter();

  constructor() { }

  closeModal(){
    this.closeOutput.emit();
  }


}
