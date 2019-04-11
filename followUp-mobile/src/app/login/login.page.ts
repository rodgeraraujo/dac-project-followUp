import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  public email:String;
  public senha:String;
  public tipo:String;

  constructor() { }

  login() {
    alert(this.email);
    alert(this.senha);
    
  }

  option() {

  }

  ngOnInit() {
  }

}
