
import { HttpClient } from '@angular/common/http';
import { Usuario } from './usuario';
import { Router } from '@angular/router';
import { Injectable, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private usuarioAutenticado: boolean = false;

  mostrarMenuEmitter = new EventEmitter<boolean>();

  constructor(private router: Router, private http: HttpClient) { }

  fazerLogin(username: string, password: string) {

    this.http.post("http://localhost:8080/", {username, password}).subscribe(data => {
      this.router.navigate(['/veiculos'])
    })


    /*if(usuario.username === 'admin' && usuario.password === 'senha123'){
      this.usuarioAutenticado = true;

      this.mostrarMenuEmitter.emit(true);

      this.router.navigate(['/']);
    } else {
      this.usuarioAutenticado = false;

      this.mostrarMenuEmitter.emit(false);
    }*/
  }

  isUsuarioAutenticado() { return this.usuarioAutenticado; }

}
