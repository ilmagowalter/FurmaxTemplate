import { Directive, HostListener } from '@angular/core';

@Directive({
  selector: '[appSidebarToggle]'
})
export class SidebarToggleDirective {

  constructor() { }
  @HostListener('click', ['$event'])
  toggleOpen($event: any) {
    $event.preventDefault();
    document.querySelector('body').classList.toggle('sidebar-hidden');
  }
}
