import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot } from '@angular/router';
import { AuthService } from '../services/auth.services';

@Injectable()
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService) {  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (this.authService.getAccessToken()) {
      return true;
    } else {
      this.authService.goToLoginPage(state.url);
    }
  }
}
