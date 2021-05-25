import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {User} from "./User";
import {UserService} from "./UserService.services";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  username: string;

  user : User;

  constructor(private router : ActivatedRoute, private userService:UserService) { }

  ngOnInit(): void {
    this.router.paramMap.subscribe(params =>{
      console.log(params);
      this.username= params.get('username');
    });

    this.userService.getUserByUsername( this.username)
      .subscribe(response=>{
      this.user = response;
    });
  }

}
