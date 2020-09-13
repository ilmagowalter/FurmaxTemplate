import { Injectable } from '@angular/core';
import { Actions, Effect, ofType } from '@ngrx/effects';
import { Action } from '@ngrx/store';
import { Observable, of } from 'rxjs';
import { catchError, map, switchMap } from 'rxjs/operators';
import { InformazioniAccesso, LoginService } from 'src/app/swagger';
import * as auth from '../actions/auth.actions';

@Injectable()
export class AuthEffects {

  constructor(
    private actions: Actions,
    protected loginService: LoginService
  ) { }

  @Effect()
  tryLogin = this.actions.pipe(
    ofType(auth.AuthActionType.TRY_LOGIN),
    switchMap((action: auth.TryLoginAction) =>
      this.loginService.loginPost(action.payload.auth).pipe(
        map((res: InformazioniAccesso) => new auth.TryLoginActionSuccess({ auth: res })),
        catchError(error => this.onError(error))
      )
    )
  );

  private onError(type?: string): Observable<Action> {
    return of(new auth.AuthErrorAction(type));
  }
}
