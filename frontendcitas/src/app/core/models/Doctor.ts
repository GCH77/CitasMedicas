import { Especialidad } from './Especialidad';
import { Persona } from './Persona';

export class Doctor {
  id: number;
  numero_tarjeta_profesional: string;
  id_especialidad: Especialidad = new Especialidad();
  id_persona: Persona;
}
