import { Component, OnInit } from '@angular/core';
import { TipoCitasService } from 'src/app/core/services/tipo-citas.service';
import { TipoCita } from 'src/app/core/models/TipoCita';
import { Router } from '@angular/router';

@Component({
  selector: 'app-stepOne',
  templateUrl: './stepOne.component.html',
  styleUrls: ['./stepOne.component.css']
})
export class StepOneComponent implements OnInit {
  tiposCitas: TipoCita[];
  currentRoute: string = this.router.url.slice(0, -2);

  tipo: number;
  fechaCita: Date

  constructor(
    private tipoCitaService: TipoCitasService,
    private router: Router
    ) { }

  ngOnInit() {
    this.getTiposCitas();
  }

  siguienteSendOne() {
    let stepOne = {
      'tipo': this.tipo,
      'fecha': this.fechaCita
    }
    this.router.navigateByUrl(`${this.currentRoute}/2`, { state: stepOne });
  }

  getTiposCitas() {
    this.tipoCitaService.getTiposCitas().subscribe(data => {
      this.tiposCitas = data
    })
  }

}
