import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoonHomeComponent } from './moon-home.component';

describe('MoonHomeComponent', () => {
  let component: MoonHomeComponent;
  let fixture: ComponentFixture<MoonHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoonHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoonHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
