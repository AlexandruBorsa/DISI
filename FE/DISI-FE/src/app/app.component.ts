import { Component } from '@angular/core';
import {NavigationEnd, Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  activeRoute;

  constructor(private router: Router) {
    router.events.subscribe(res => {
      if (res instanceof NavigationEnd) {
        this.activeRoute = res.url.slice(1);
      }
    });
  }
}
