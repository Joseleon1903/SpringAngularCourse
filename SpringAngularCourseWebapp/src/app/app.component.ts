import {Component, DoCheck, OnChanges, OnInit} from '@angular/core';
import {AuthService} from "./auth/authorization.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, DoCheck{

  title = 'SpringAngularCourseWebapp';
  username = 'NONE';
  profileUrl = "https://static.nike.com/a/images/w_960,c_limit/8b9b1970-e2d0-41db-a8f0-7ca99a823fd8/how-do-i-delete-my-nike-member-profile-nike-help.png";
  constructor(private authService: AuthService){}

  ngDoCheck(): void {
    // console.log("detect on change");
    if(this.authService.isLoggedIn()){
      this.username = this.authService.currentUser.username;
      this.profileUrl = this.authService.currentUser.profileUrl;
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
