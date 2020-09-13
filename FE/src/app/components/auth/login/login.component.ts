import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { TryLoginAction } from 'src/app/redux/actions/auth.actions';
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
  constructor(
    protected loginService: LoginService,
    protected store: Store<any>
  ) { }

  ngOnInit(): void {
  }

  login() {
    this.store.dispatch(new TryLoginAction({auth: {username: 'mfurnari', password: 'q1w2e3r4t5'}}));

    // this.loginService.loginPost(this.auth).subscribe(
    //   (res: InformazioniAccesso) => {
    //     this.res = res;
    //   },
    //   (e) => console.log('Errore', e)
    // );
  }
}
