import { Especialidad } from './Especialidad';
import { Persona } from './Persona';

export class Doctor {
  id: number;
  numeroTarjetaProfesional: string;
  idEspecialidad: Especialidad;
  idPersona: Persona;
}
