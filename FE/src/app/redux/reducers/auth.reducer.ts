import * as AuthActions from '../actions/auth.actions';
import { ErroreGenerico, InformazioniAccesso } from 'src/app/swagger';

export interface State {
  loading: boolean;
  error: ErroreGenerico;
  ia: InformazioniAccesso;
}

const initialState: State = {
  loading: false,
  error: null,
  ia: null
};

export function reducer(state: State = initialState, action: AuthActions.Actions): State {
  switch (action.type) {
    case AuthActions.AuthActionType.TRY_LOGIN: {
      return {
        ...state,
        loading: true,
        error: null
      };
    }

    case AuthActions.AuthActionType.TRY_LOGIN_SUCCESS: {
      return {
        ...state,
        loading: false,
        ia: action.payload.auth
      };
    }

    case AuthActions.AuthActionType.ERROR: {
      return { ...state, loading: false, error: action.payload};
    }

    default: {
      return state;
    }
  }
}
