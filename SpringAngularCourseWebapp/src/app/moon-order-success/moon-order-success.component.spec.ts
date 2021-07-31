import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoonOrderSuccessComponent } from './moon-order-success.component';

describe('MoonOrderSuccessComponent', () => {
  let component: MoonOrderSuccessComponent;
  let fixture: ComponentFixture<MoonOrderSuccessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoonOrderSuccessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoonOrderSuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
