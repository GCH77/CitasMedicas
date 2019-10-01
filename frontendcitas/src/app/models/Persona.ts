import { TipoDocumento } from './tipo-documento';

export class Persona {
  id: number;
  apellido: string;
  email: string;
  fechaNacimiento: Date;
  nombre: string;
  numeroDocumento: string;
  telefono: string;
  idTipoDocumento: TipoDocumento;
}
