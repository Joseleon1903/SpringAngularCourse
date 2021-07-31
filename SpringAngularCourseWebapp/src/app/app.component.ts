import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{


  sunMarketVisible: boolean = false;

  moonMarketVisible: boolean = true;

  ngOnInit(): void {
    console.log('init main menu')
  }

  navigateToSunSite(){
    console.log("entering in navigateToSunSite");
    this.sunMarketVisible = true;
  }

  navigateToMoonSite(){
    console.log("entering in navigateToMoonSite");
    this.moonMarketVisible = true;
  }

}
