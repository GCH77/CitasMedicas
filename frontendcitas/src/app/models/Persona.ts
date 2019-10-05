import { TipoDocumento } from './tipo-documento';

export class Persona {
  id: number;
  apellido: string;
  email: string;
  fecha_nacimiento: Date;
  nombre: string;
  numero_documento: string;
  telefono: string;
  id_tipo_documento: TipoDocumento;
}
