import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoonNavbarComponent } from './moon-navbar.component';

describe('MoonNavbarComponent', () => {
  let component: MoonNavbarComponent;
  let fixture: ComponentFixture<MoonNavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoonNavbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoonNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
