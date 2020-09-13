import { ActionReducerMap } from '@ngrx/store';
import * as fromAuth from './reducers/auth.reducer';

export interface State {
  auth: fromAuth.State;
}

export const reducers: ActionReducerMap<State> = {
  auth: fromAuth.reducer,
};
