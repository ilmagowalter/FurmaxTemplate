import { Action } from '@ngrx/store';
import { Autenticazione, InformazioniAccesso } from 'src/app/swagger';

export enum AuthActionType {
  TRY_LOGIN = '[Auth] Try login',
  TRY_LOGIN_SUCCESS = '[Auth] Try login success',
  ERROR = '[Auth] Error'
}

export class TryLoginAction implements Action {
  readonly type = AuthActionType.TRY_LOGIN;

  constructor(public payload: {
    auth: Autenticazione
  }) { }
}

export class TryLoginActionSuccess implements Action {
  readonly type = AuthActionType.TRY_LOGIN_SUCCESS;

  constructor(public payload: {
    auth: InformazioniAccesso
  }) { }
}

export class AuthErrorAction implements Action {
  readonly type = AuthActionType.ERROR;

  constructor(public payload?: any) { }
}

export type Actions
  = TryLoginAction
  | TryLoginActionSuccess
  | AuthErrorAction;
