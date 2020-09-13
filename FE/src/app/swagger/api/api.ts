export * from './login.service';
import { LoginService } from './login.service';
export * from './utenti.service';
import { UtentiService } from './utenti.service';
export const APIS = [LoginService, UtentiService];
