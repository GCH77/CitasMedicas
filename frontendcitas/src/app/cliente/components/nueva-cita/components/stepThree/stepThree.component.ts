import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TipoDocumentoService } from 'src/app/core/services/tipo-documento.service';
import { TipoDocumento } from 'src/app/core/models/TipoDocumento';
import { Persona } from 'src/app/core/models/Persona';
import { Cita } from 'src/app/core/models/Cita';
import { ClienteService } from 'src/app/core/services/cliente.service';
import { Doctor } from 'src/app/core/models/Doctor';
import { TipoCita } from 'src/app/core/models/TipoCita';

@Component({
  selector: 'app-stepThree',
  templateUrl: './stepThree.component.html',
  styleUrls: ['./stepThree.component.css']
})
export class StepThreeComponent implements OnInit {
  currentRoute: string = this.router.url.slice(0, -2);
  tipoDocumentosList: TipoDocumento[] = [];

  usuario: Cita = new Cita();
  persona: Persona = new Persona();
  doctor: Doctor = new Doctor();
  tipoCita: TipoCita = new TipoCita();

  //Datos anteriores
  data: any;

  constructor(
    private tipoDocumentoService: TipoDocumentoService,
    private clienteService: ClienteService,
    private router: Router
    ) {
    console.log(this.router.getCurrentNavigation().extras.state);
    this.data = this.router.getCurrentNavigation().extras.state;
    console.log(this.data);
  }

  ngOnInit() {
    this.getTiposDocumentos();
  }

  cancelButton() {
    this.router.navigateByUrl(`${this.currentRoute}/2`);
  }

  siguienteSendThree() {
    // this.usuario.id_doctor.id = parseInt(this.data.doctor);
    // this.usuario.id_tipo_cita.id = parseInt(this.data.tipo);
    this.doctor.id = parseInt(this.data.doctor);
    this.tipoCita.id = parseInt(this.data.tipo);

    this.usuario.id_persona = this.persona;
    this.usuario.id_doctor = this.doctor;
    this.usuario.tipo_cita = this.tipoCita;

    this.usuario.hora_cita = this.data.hora;
    this.usuario.fecha_cita = this.data.fecha;

    console.log("CITA");
    console.log(this.usuario);
    this.clienteService.saveCitaMedica(this.usuario).subscribe(data => {
      console.log("Enviado");
    });
    this.router.navigateByUrl(`${this.currentRoute}/4`);
  }

  getTiposDocumentos() {
    this.tipoDocumentoService.getTiposDocumentos().subscribe(data => {
      this.tipoDocumentosList = data;
    });
  }

}
