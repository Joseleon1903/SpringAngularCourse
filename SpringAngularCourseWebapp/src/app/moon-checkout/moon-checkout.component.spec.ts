import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoonCheckoutComponent } from './moon-checkout.component';

describe('MoonCheckoutComponent', () => {
  let component: MoonCheckoutComponent;
  let fixture: ComponentFixture<MoonCheckoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoonCheckoutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoonCheckoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
