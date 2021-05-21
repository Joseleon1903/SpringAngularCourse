import {Component } from '@angular/core';
import {DestinationService} from "./destination.service";


@Component({
  selector: 'destination', // <destination> or .destination or id="destination"
  template: `
                <h2>{{"Title : "+ title}}</h2> 
                
                <ul id="menu">
                    <li *ngFor="let pref of preferences">{{pref}} </li>
                </ul>
                 <h6 [textContent]="imageTitle"></h6> 
                 
                <img (click) = "onTouchImage($event)" src="{{imagePageUrl}}"/>
                <br>
                <h6>{{company.name | uppercase}} / {{company.rating | number: '1.2-2'}} / {{company.employees  | number}} / {{company.Revenue | currency: 'US': true}} / {{company.foundationDate | date}}</h6>
                <br>
                <input [(ngModel)]="textName" (keyup.enter)="onPressKey()">
                
            `,
  styles: ['ul#menu li { display:inline;}; ']

})
export class DestinationComponent {

  title = 'List Employee Page';

  imageTitle = 'Work hard with your employee help to grow your company';
  imagePageUrl = 'https://www.miltons.law.za/wp-content/uploads/2019/02/employees.jpg';

  preferences;

  textName= "example";

  company={

    name:'Alphabet',
    rating: 4.9745,
    employees: 302546,
    Revenue : 190.95,
    foundationDate: new Date(1995,3,1)
  };

  constructor(prefService: DestinationService ){
    this.preferences = prefService.getPreferenceList();
  }

  onTouchImage($event: any){
    console.log("click on Image ", $event);
    console.log("event target "+  $event.target.value);
  }

  onKeyUp(employeeName: string){

    console.log("name type : "+employeeName);

  }

  onPressKey(){
    console.log(this.textName)
  }


}
