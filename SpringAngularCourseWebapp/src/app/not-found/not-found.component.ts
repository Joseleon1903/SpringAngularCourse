import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-not-found',
  templateUrl: './not-found.component.html',
  styleUrls: ['./not-found.component.css']
})
export class NotFoundComponent implements OnInit {

  constructor() { }

  notFoundErrorCode : string = "404";
  notFoundErrorDescription : string = "Not found resource error";

  ngOnInit(): void {
  }

  getDescriptionError() : string {
    return this.notFoundErrorCode + ' '+ this.notFoundErrorDescription;
  }

}
