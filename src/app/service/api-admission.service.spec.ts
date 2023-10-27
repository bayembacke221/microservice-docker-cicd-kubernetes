import { TestBed } from '@angular/core/testing';

import { ApiAdmissionService } from './api-admission.service';

describe('ApiAdmissionService', () => {
  let service: ApiAdmissionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiAdmissionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
