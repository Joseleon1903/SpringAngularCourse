import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoonAdminOrdersComponent } from './moon-admin-orders.component';

describe('MoonAdminOrdersComponent', () => {
  let component: MoonAdminOrdersComponent;
  let fixture: ComponentFixture<MoonAdminOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoonAdminOrdersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoonAdminOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
