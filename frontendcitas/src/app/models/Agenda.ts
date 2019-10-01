import { Doctor } from './Doctor';

export class Agenda {
  id: number;
  duracion_cita: number;
  fecha_fin: Date = new Date();
  fecha_inicio: number;
  id_doctor: Doctor;
}
