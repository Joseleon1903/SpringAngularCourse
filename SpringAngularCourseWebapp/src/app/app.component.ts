import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  title = 'SpringAngularCourseWebapp';

  username = 'Admin';

  constructor(){}

  ngOnInit(): void {

  }


}
