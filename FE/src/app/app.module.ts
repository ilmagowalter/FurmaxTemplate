import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { reducers } from './redux/app-reducer';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GearbestComponent } from './components/gearbest/gearbest.component';
import { LayoutModule } from './components/layout/layout.module';
import { SharedModule } from './shared/shared.module';
import { UuidService } from './shared/services/uuid.service';
import { AuthModule } from './components/auth/auth.module';
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { environment } from 'src/environments/environment';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
// import { environment } from 'src/environments/environment.prod';

@NgModule({
  declarations: [
    AppComponent,
    GearbestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    StoreModule.forRoot(reducers),
    EffectsModule.forRoot([]),
    LayoutModule,
    SharedModule,
    AuthModule,
    !environment.production ? StoreDevtoolsModule.instrument() : []
  ],
  providers: [UuidService],
  bootstrap: [AppComponent]
})
export class AppModule { }
