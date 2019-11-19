import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';


@Component({
  selector: 'app-nueva-cita',
  templateUrl: './nueva-cita.component.html',
  styleUrls: ['./nueva-cita.component.css']
})

export class NuevaCitaComponent implements OnInit {
  stepActive: number = parseInt(this.router.url.slice(-1));
  currentRoute: string = this.router.url.slice(0, -2);

  constructor(private router: Router) { 
    this.router.events.subscribe((event) => {
      let index = event['url'] ? parseInt(event['url'].slice(-1)) : 0;
      if (index !== 0 && index !== this.stepActive) {
        this.stepActive = index;
      }
    });
  }

  ngOnInit() {
    this.router.navigateByUrl(`${this.currentRoute}/${this.stepActive}`);
  }

  disabledNext() {
    return this.stepActive === 3;
  }

  disabledPrevious() {
    return this.stepActive === 1;
  }

  nextMethod() {
    this.stepActive++;
    this.router.navigateByUrl(`${this.currentRoute}/${this.stepActive}`);
  }

  previousMethod() {
    this.stepActive--;
    this.router.navigateByUrl(`${this.currentRoute}/${this.stepActive}`);
  }

}
