import { Usuario } from './usuario';
import { AuthService } from './auth.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  usuario: Usuario = new Usuario();

  constructor(private authService: AuthService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {


  }

  get f() {
    this.loginForm = this.formBuilder.group({
      username: this.usuario.username,
      password: this.usuario.password
  });
    return this.loginForm.controls;

  }

  login() {
    this.authService.fazerLogin(this.f.username.value, this.f.password.value);
  }

}
