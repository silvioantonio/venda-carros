import { Usuario } from './usuario';
import { AuthService } from './auth.service';
import { Component } from '@angular/core';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  usuario: Usuario = new Usuario();

  constructor(private authService: AuthService) { }

  login() { this.authService.fazerLogin(this.usuario); }

}
