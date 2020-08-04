import { AuthService } from './../login/login/auth.service';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate{

  constructor( private authService: AuthService, private router: Router) { }

  canActivate( route: ActivatedRouteSnapshot, state:RouterStateSnapshot ): boolean | Observable<boolean> {
    if(this.authService.isUsuarioAutenticado()) return true;

    this.router.navigate(['/login']);
    return false;
  }
}
