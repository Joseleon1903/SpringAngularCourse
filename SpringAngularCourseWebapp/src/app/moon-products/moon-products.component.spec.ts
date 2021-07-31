import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoonProductsComponent } from './moon-products.component';

describe('MoonProductsComponent', () => {
  let component: MoonProductsComponent;
  let fixture: ComponentFixture<MoonProductsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoonProductsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoonProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
