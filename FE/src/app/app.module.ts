import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GearbestComponent } from './components/gearbest/gearbest.component';
import { LayoutModule } from './components/layout/layout.module';
import { SharedModule } from './shared/shared.module';
import { UuidService } from './shared/services/uuid.service';

@NgModule({
  declarations: [
    AppComponent,
    GearbestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LayoutModule,
    SharedModule
  ],
  providers: [UuidService],
  bootstrap: [AppComponent]
})
export class AppModule { }
