import { Component, OnInit } from '@angular/core';
import {CreationService} from "./creation.service";
import {RoleInput} from "./models/RoleInput";
import {NgForm} from "@angular/forms";
import {CreationUser} from "./models/CreationUser";
import {HttpErrorResponse} from "@angular/common/http";
import {Router} from "@angular/router";


@Component({
  selector: 'create-profile',
  templateUrl: './create-profile.component.html',
  styleUrls: ['./create-profile.component.css']
})
export class CreateProfileComponent implements OnInit {

  constructor(private creationService: CreationService, private router: Router) { }


  roles: RoleInput[];

  ngOnInit(): void {

    // load roles systems
    this.creationService.getRoles()
      .subscribe(response =>{
      this.roles = response;
    });

  }


  submitForm(addForm : NgForm){

    console.log('Entering in submitForm'+ addForm.value);
    let user :CreationUser = addForm.value;
    console.log('role: '+ addForm.value['role']);

    if(!addForm.invalid){
      console.log('valid form ');
      this.creationService.creationUser(addForm.value).subscribe(
        (response)=> {
          console.log("response:"+response);
          console.log('register success');
              this.router.navigate(['/']);
          },
        (error: HttpErrorResponse)=>{
          alert(error.message);
          addForm.resetForm();
        }
      );
    }
  }


}
