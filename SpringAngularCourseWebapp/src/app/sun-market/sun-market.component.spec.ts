import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SunMarketComponent } from './sun-market.component';

describe('SunMarketComponent', () => {
  let component: SunMarketComponent;
  let fixture: ComponentFixture<SunMarketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SunMarketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SunMarketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
