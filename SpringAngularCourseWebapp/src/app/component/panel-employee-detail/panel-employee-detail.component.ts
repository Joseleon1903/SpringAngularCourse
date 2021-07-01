import {Component, Input, Output, EventEmitter} from '@angular/core';
import {Employee} from "../../employee/Employee";

@Component({
  selector: 'panel-employee-detail',
  templateUrl: './panel-employee-detail.component.html',
  styleUrls: ['./panel-employee-detail.component.css']
})
export class EmployeeDetailComponent {

  @Input('show-modal') showModal?: Boolean;

  @Input('employee-input') employee?: Employee;

  @Output('close-output') closeOutput = new EventEmitter();

  constructor() { }

  closeModal(){
    this.closeOutput.emit();
  }

}
