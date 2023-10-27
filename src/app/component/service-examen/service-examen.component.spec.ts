import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceExamenComponent } from './service-examen.component';

describe('ServiceExamenComponent', () => {
  let component: ServiceExamenComponent;
  let fixture: ComponentFixture<ServiceExamenComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ServiceExamenComponent]
    });
    fixture = TestBed.createComponent(ServiceExamenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
