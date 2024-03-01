import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  public user={
    email:"",
    password:""
  }

  constructor(){}

  ngOnInit():void{}

  onLoginSubmit(){
    alert("login");
  }
}
