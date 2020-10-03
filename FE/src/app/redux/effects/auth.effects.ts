import { Injectable } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Actions, Effect, ofType } from '@ngrx/effects';
import { Action } from '@ngrx/store';
import { Observable, of } from 'rxjs';
import { catchError, map, switchMap } from 'rxjs/operators';
import { AuthService } from 'src/app/shared/services/auth.services';
import { InformazioniAccesso, LoginService } from 'src/app/swagger';
import * as auth from '../actions/auth.actions';

@Injectable()
export class AuthEffects {

  constructor(
    private actions: Actions,
    private loginService: LoginService,
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute

  ) { }

  @Effect()
  tryLogin = this.actions.pipe(
    ofType(auth.AuthActionType.TRY_LOGIN),
    switchMap((action: auth.TryLoginAction) =>
      this.loginService.loginPost(action.payload.authentication).pipe(
        map((res: InformazioniAccesso) => {
          this.authService.setAccessToken(res.token);
          return new auth.TryLoginActionSuccess({ auth: res });
        }),
        catchError(error => this.onError(error))
      )
    )
  );

  @Effect({ dispatch: false })
  tryLoginSuccess = this.actions.pipe(
    ofType(auth.AuthActionType.TRY_LOGIN_SUCCESS),
    switchMap((action: auth.TryLoginActionSuccess) =>
      this.router.navigate([this.route.snapshot.queryParams.returnUrl || '/home'])
    )
  );

  private onError(type?: string): Observable<Action> {
    return of(new auth.AuthErrorAction(type));
  }
}
