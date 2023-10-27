import { TestBed } from '@angular/core/testing';

import { ApiExamenService } from './api-examen.service';

describe('ApiExamenService', () => {
  let service: ApiExamenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiExamenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
