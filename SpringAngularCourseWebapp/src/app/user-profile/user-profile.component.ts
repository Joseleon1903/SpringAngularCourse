import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  username: string;

  constructor(private router : ActivatedRoute) { }

  ngOnInit(): void {
    this.router.paramMap.subscribe(params =>{
      console.log(params);
      this.username= params.get('username');
    });
  }

}
