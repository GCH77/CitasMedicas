import { Doctor } from './Doctor';
import { Persona } from './Persona';
import { TipoCita } from './TipoCita';

export class Cita {
  id: number;
  fecha_cita: Date;
  hora_cita: string;
  id_doctor: Doctor;
  id_persona: Persona = new Persona();
  tipo_cita: TipoCita;
}