import { TestBed } from '@angular/core/testing';

import { ApiEtudiantService } from './api-etudiant.service';

describe('ApiEtudiantService', () => {
  let service: ApiEtudiantService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiEtudiantService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
