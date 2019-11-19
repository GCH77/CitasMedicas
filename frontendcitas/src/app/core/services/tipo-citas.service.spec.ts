/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { TipoCitasService } from './tipo-citas.service';

describe('Service: TipoCitas', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TipoCitasService]
    });
  });

  it('should ...', inject([TipoCitasService], (service: TipoCitasService) => {
    expect(service).toBeTruthy();
  }));
});
