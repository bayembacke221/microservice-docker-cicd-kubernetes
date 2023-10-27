import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceInscriptionComponent } from './service-inscription.component';

describe('ServiceInscriptionComponent', () => {
  let component: ServiceInscriptionComponent;
  let fixture: ComponentFixture<ServiceInscriptionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ServiceInscriptionComponent]
    });
    fixture = TestBed.createComponent(ServiceInscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
