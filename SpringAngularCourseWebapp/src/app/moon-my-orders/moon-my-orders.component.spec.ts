import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoonMyOrdersComponent } from './moon-my-orders.component';

describe('MoonMyOrdersComponent', () => {
  let component: MoonMyOrdersComponent;
  let fixture: ComponentFixture<MoonMyOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoonMyOrdersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoonMyOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
