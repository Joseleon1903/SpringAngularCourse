import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  log(message: any){
    console.log(message);
  }

  submit(form:any){
    console.log(form);

  }


  contactMethod = [
    {id:1, name:'email'},
    {id:2, name:'telephone'},
    {id:3, name:'message'}
  ];

  contactSex = [
    {id:1, name:'Male'},
    {id:2, name:'Female'},
    {id:3, name:'Undefined'}
  ];

}
