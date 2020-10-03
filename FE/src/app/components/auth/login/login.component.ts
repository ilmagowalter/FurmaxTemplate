import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { TryLoginAction } from 'src/app/redux/actions/auth.actions';
import { AuthService } from 'src/app/shared/services/auth.services';
import { Autenticazione, InformazioniAccesso, LoginService } from 'src/app/swagger';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public auth: Autenticazione = {
    username: '',
    password: ''
  };

  public res: InformazioniAccesso = {};
  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  login() {
    this.authService.login(this.auth);
  }
}
