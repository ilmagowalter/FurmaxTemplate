import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { TryLoginAction } from 'src/app/redux/actions/auth.actions';
import { Autenticazione } from 'src/app/swagger';

const ACCESS_TOKEN = 'access_token';

@Injectable()
export class AuthService {
    constructor(
        protected router: Router,
        protected store: Store<any>
    ) { }

    setAccessToken(token: string) {
        if (sessionStorage && token) {
            sessionStorage.setItem(ACCESS_TOKEN, token);
        }
    }

    getAccessToken(): string {
        return sessionStorage.getItem(ACCESS_TOKEN);
    }

    removeAccessToken() {
        if (sessionStorage) {
            sessionStorage.removeItem(ACCESS_TOKEN);
        }
    }

    login(auth: Autenticazione) {
        this.removeAccessToken();
        if (auth) {
            if (auth.username) {
                auth.username = auth.username.toLowerCase();
            }
            this.store.dispatch(new TryLoginAction({ authentication: auth }));
        }
    }

    goToLoginPage(currentUrl: string) {
        this.router.navigate(['/login'], { queryParams: { returnUrl: currentUrl } });
    }

    logout() {
        this.removeAccessToken();
        this.router.navigate(['/login']);
    }
}
