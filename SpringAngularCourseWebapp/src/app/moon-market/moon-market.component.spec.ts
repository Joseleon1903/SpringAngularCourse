import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoonMarketComponent } from './moon-market.component';

describe('MoonMarketComponent', () => {
  let component: MoonMarketComponent;
  let fixture: ComponentFixture<MoonMarketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoonMarketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoonMarketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
