import {Component, OnInit} from "@angular/core";
import {NgForm} from "@angular/forms";
import {UserInput} from "./UserInput";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpErrorResponse} from "@angular/common/http";
import {AuthService} from "../auth/authorization.service";

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService : AuthService, private router: Router, private activaterouter : ActivatedRoute ) { }

  appName: string;
  formError ={errorMessage: 'Login error '}

  ngOnInit(): void {

    this.activaterouter.paramMap.subscribe(params =>{
      console.log(params);
      this.appName= params.get('appName');
    });
  }

  submitLogin(form : NgForm){
    console.log('Entering in login');

    let user : UserInput = form.value;
    user.username = user.email;
    console.log('username '+ user.username);
    console.log('email '+user.email);
    console.log('password '+ user.password);

    if(form.invalid){
      this.formError.errorMessage = 'Login Required username and password';
      this.openErrorModal();
    }

    if(!form.invalid){
      console.log('valid form ');
      this.authService.login(user).subscribe(response => {

          console.log('redirect to Home appname ; '+this.appName);
          console.log('register success');
          let result  = response;
          localStorage.setItem('userId', result.userId+'');
          localStorage.setItem('username', result.username+'');
          localStorage.setItem('role', result.role+'');
          localStorage.setItem('status', result.status+'');
          localStorage.setItem('profileUrl', result.profileUrl+'');
          if(this.appName == 'Moon'){
            this.router.navigate(['/moon/home']);
          }else if(this.appName == 'Sun'){
            this.router.navigate(['/sun/home']);
          }

        },
        (error: HttpErrorResponse)=>{
         console.log('Error: '+error);
         this.formError.errorMessage = 'Login username or password error retry ';
         this.openErrorModal();
         form.reset();
        }
      );
    }
  }

  openErrorModal(){
    console.log("entering in onOpenModal");
    const button = document.createElement('button');
    const container = document.getElementById('container-login');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');

    button.setAttribute('data-target','#loginErrorModal');
    container.appendChild(button);
    button.click();
  }

  goCreateNewAccount(){
    console.log('redirect to create new account login');
  }



}
