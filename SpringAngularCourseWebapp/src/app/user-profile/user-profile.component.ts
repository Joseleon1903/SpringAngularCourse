import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {User} from "./User";
import {UserService} from "./UserService.services";
import {NgForm} from "@angular/forms";
import {BannerError, BannerInfo, BannerInput} from "../component/panel-banner/BannerInput";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  username: string;

  user : User;

  enableInput: boolean = true;

  showMessage: boolean = false;

  messageBanner : BannerInput;

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

  unlockInputField(){
    this.enableInput = !this.enableInput;
    console.log("is Enable Input : "+this.enableInput );
  }


  submitUpdateProfile(formIn : NgForm){
    console.log("Entering in update User");

    this.user.userPreference = {
      nickname: formIn.control.get('customerNickname').value,
      shareEnable: formIn.control.get('customerShareOption').value,
      receiveEmailNotification: formIn.control.get('customerEmailNotification').value
    };

    this.user.pictureUrl = formIn.control.get('userProfileUrl').value;
    this.user.customer.firstName= formIn.control.get('customerFirstName').value;
    this.user.customer.lastName = formIn.control.get('customerLastName').value;
    this.user.customer.address = formIn.control.get('customerAddress').value;

    this.userService.putUserUpdate(this.user).subscribe(respone =>{
      console.log("update success");
      console.log("response: "+respone );
      this.user = respone;
      this.showMessage = true;
      this.messageBanner = {content: 'Update customer profile success', title:'User Notification', type: BannerInfo}
    }, error=>{
      console.log('error:'+error);
      this.messageBanner = {content: 'Internal Server Error', title:'User Notification Error', type: BannerError}
    });

  }

  closeModal(){
    this.showMessage= false;
  }


}
