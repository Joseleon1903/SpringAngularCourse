import { Component } from '@angular/core';

import {FormGroup, FormControl, Validators, FormArray, AbstractControl} from '@angular/forms';
import { UsernameValidators} from "./UsernameValidators";

@Component({
  selector: 'singup-form',
  templateUrl: './singup-form.component.html',
  styleUrls: ['./singup-form.component.css']
})
export class SingupFormComponent {

  form = new FormGroup({
    account: new FormGroup({
      username: new FormControl('', [Validators.required,
          Validators.maxLength(12),
          Validators.minLength(5),
          UsernameValidators.cannotContainSpace],
        UsernameValidators.shouldBeUnique),
      password: new FormControl('', Validators.required)
    }),
    topics: new FormArray([])
  });

  get username(){
    return this.form.get('account.username');
  }

  get topics() : AbstractControl[]{
    return (this.form.get('topics')  as FormArray).controls;
  }

  addTopic(topic: HTMLInputElement){
    (this.form.get('topics') as FormArray ).push(new FormControl(topic.value));
    topic.value= '';
  }

  removeTopic(topic: FormControl){
    let indexTopic = (this.form.get('topics') as FormArray ).controls.indexOf(topic);
    (this.form.get('topics') as FormArray ).removeAt(indexTopic);
  }


  login(){

    // this.form.setErrors({
    //   invalidLogin: true
    // });
  }

}
