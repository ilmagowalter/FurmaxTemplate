import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/layout/home/home.component';
import { GearbestComponent } from './components/gearbest/gearbest.component';
import { NotfoundComponent } from './components/layout/notfound/notfound.component';
import { LoginComponent } from './components/auth/login/login.component';
import { ContainerComponent } from './components/layout/container/container.component';
import { AuthGuard } from './shared/guard/auth-guard.service';


const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    component: ContainerComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: '',
        pathMatch: 'full',
        redirectTo: 'home'
      },
      {
        path: 'home',
        component: HomeComponent
      },
      {
        path: 'gearbest',
        component: GearbestComponent
      },
    ]
  },
  {
    path: '**',
    component: NotfoundComponent
  }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [
    AuthGuard,
  ]
})
export class AppRoutingModule { }
