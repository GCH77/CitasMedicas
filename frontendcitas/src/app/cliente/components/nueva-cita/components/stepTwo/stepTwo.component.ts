import { Component, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { ClienteService } from 'src/app/core/services/cliente.service';
import { Doctor } from 'src/app/core/models/Doctor';
import { Agenda } from 'src/app/core/models/Agenda';

@Component({
  selector: 'app-stepTwo',
  templateUrl: './stepTwo.component.html',
  styleUrls: ['./stepTwo.component.css']
})
export class StepTwoComponent implements OnInit {
  currentRoute: string = this.router.url.slice(0, -2);
  agendaDoctorDisponible: Agenda;

  doctoresList: Doctor[] = [];
  horasCitaList: string[] = [];

  //Datos anteriores
  data: object;

  doctorCita: number;
  horaCita: string;

  constructor(
    private clienteService: ClienteService,
    private router: Router
    ) {
    console.log(this.router.getCurrentNavigation().extras.state);
    this.data = this.router.getCurrentNavigation().extras.state;
    this.getDoctores(this.data['tipo'], this.data['fecha']);
  }

  ngOnInit() {
    
  }

  async changeDoctor($event) {
    console.log("Change", $event);
    await this.getAgendaDoctorDisponible($event);
    this.calculatingTimeCita();
  }

  cancelButton() {
    this.router.navigateByUrl(`${this.currentRoute}/1`);
  }

  siguienteSendTwo() {
    let stepOneTwo = {
      ...this.data,
      'doctor': this.doctorCita,
      'hora': this.horaCita
    }
    this.router.navigateByUrl(`${this.currentRoute}/3`, { state: stepOneTwo });
  }

  getDoctores(tipo: number, fecha: Date) {
    this.clienteService.getDoctores(tipo, fecha).subscribe(data => {
      this.doctoresList = data;
    });
  }

  async getAgendaDoctorDisponible(idDoctor: number) {
    // this.clienteService.getAgendaDoctorDisponible(idDoctor).subscribe(data => {
    //   this.agendaDoctorDisponible = data;
    // });
    await this.clienteService.getAgendaDoctorDisponible(idDoctor).then(data => {
      this.agendaDoctorDisponible = data;
    })
  }

  calculatingTimeCita() {
    let minutosStatic = this.agendaDoctorDisponible.duracion_cita;
    let minutes = minutosStatic;
    let jornadaMañana = (5 * 60) / minutosStatic;
    let jornadaTarde = (4 * 60) / minutosStatic;
    let hour = new Date(0);
    let hourP = new Date(0);
    //Mañana
    console.log("MAÑANA");
    for (let index = 0; index < jornadaMañana; index++) {
      hour.setHours(7);
      hour.setMinutes(minutes);
      let min = hour.getMinutes() - minutosStatic;
      hourP.setHours(hour.getHours(), min);
      console.log(this.formatTime(hourP) + " - " + this.formatTime(hour));
      this.horasCitaList.push(this.formatTime(hourP) + " - " + this.formatTime(hour));
      minutes += minutosStatic;
    }

    minutes = minutosStatic;
    //Tarde
    console.log("TARDE");
    for (let index = 0; index < jornadaTarde; index++) {
      hour.setHours(14);
      hour.setMinutes(minutes);
      let min = hour.getMinutes() - minutosStatic;
      hourP.setHours(hour.getHours(), min);
      console.log(this.formatTime(hourP) + " - " + this.formatTime(hour));
      this.horasCitaList.push(this.formatTime(hourP) + " - " + this.formatTime(hour));
      minutes += minutosStatic;
    }
  }

  formatTime(time: Date) {
    return time.toLocaleTimeString("en-us", {hour: '2-digit', minute:'2-digit'});
  }

}
