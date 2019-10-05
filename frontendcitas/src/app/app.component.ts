import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <app-header></app-header>

    <app-home></app-home>

    <app-agenda></app-agenda>

    <app-doctor></app-doctor>
    
    <router-outlet></router-outlet>

    <app-footer></app-footer>
  `,
  styles: []
})
export class AppComponent {
  title = 'my-first-app';
}
