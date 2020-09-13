import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../../shared/shared.module';
import { SidebarComponent } from './sidebar/sidebar.component';
import { HeaderbarComponent } from './headerbar/headerbar.component';
import { HomeComponent } from './home/home.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { ContainerComponent } from './container/container.component';

@NgModule({
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    SidebarComponent,
    HeaderbarComponent
  ],
  declarations: [
    SidebarComponent,
    HeaderbarComponent,
    HomeComponent,
    NotfoundComponent,
    ContainerComponent
  ]
})
export class LayoutModule { }
