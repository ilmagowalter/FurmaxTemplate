import { TabsModule } from 'ngx-tabset';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarToggleDirective } from './directive/sidebar/sidebar.directive';
import { RouterModule } from '@angular/router';
import { TableComponent } from './components/table/table.component';
import { FormsModule } from '@angular/forms';
import { GearbestService } from './services/gearbest.service';
import { HttpClientModule } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';
import { BrowserModule } from '@angular/platform-browser';


@NgModule({
  declarations: [
    SidebarToggleDirective,
    TableComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    BrowserModule,
    TabsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  exports: [
    SidebarToggleDirective,
    RouterModule,
    TableComponent,
    FormsModule,
    BrowserModule,
    TabsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [GearbestService]
})
export class SharedModule { }
