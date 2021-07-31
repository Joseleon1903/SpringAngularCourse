import {Component, DoCheck, OnInit} from '@angular/core';
import {AuthService} from "../auth/authorization.service";

@Component({
  selector: 'app-moon-navbar',
  templateUrl: './moon-navbar.component.html',
  styleUrls: ['./moon-navbar.component.css']
})
export class MoonNavbarComponent implements OnInit, DoCheck {

  username: string;

  constructor(private authService: AuthService) { }

  ngDoCheck(): void {
    // console.log("detect on change");
    if(this.authService.isLoggedIn()){
      this.username = this.authService.currentUser.username;
    }
  }

  ngOnInit(): void {
  }

  IsUserLoggedIn(){
    return this.authService.isLoggedIn();
  }

  logoutUser() {
    this.authService.logout();
  }

}
