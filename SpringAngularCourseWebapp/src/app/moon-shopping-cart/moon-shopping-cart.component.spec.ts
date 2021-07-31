import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoonShoppingCartComponent } from './moon-shopping-cart.component';

describe('MoonShoppingCartComponent', () => {
  let component: MoonShoppingCartComponent;
  let fixture: ComponentFixture<MoonShoppingCartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoonShoppingCartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoonShoppingCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
