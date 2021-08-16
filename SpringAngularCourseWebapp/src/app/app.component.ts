import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{


  sunMarketVisible: boolean = false;

  moonMarketVisible: boolean = false;

  constructor(private router: Router) {}


  ngOnInit(): void {
    console.log('init main menu')
  }

  navigateToSunSite(){
    console.log("entering in navigateToSunSite");
    this.sunMarketVisible = true;
    this.router.navigateByUrl('/sun/home');

  }

  navigateToMoonSite(){
    console.log("entering in navigateToMoonSite");
    this.moonMarketVisible = true;
    this.router.navigateByUrl('/moon/home');
  }

}
