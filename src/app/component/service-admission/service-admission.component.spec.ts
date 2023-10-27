import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceAdmissionComponent } from './service-admission.component';

describe('ServiceAdmissionComponent', () => {
  let component: ServiceAdmissionComponent;
  let fixture: ComponentFixture<ServiceAdmissionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ServiceAdmissionComponent]
    });
    fixture = TestBed.createComponent(ServiceAdmissionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
