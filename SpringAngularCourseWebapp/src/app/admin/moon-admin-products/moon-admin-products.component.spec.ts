import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoonAdminProductsComponent } from './moon-admin-products.component';

describe('MoonAdminProductsComponent', () => {
  let component: MoonAdminProductsComponent;
  let fixture: ComponentFixture<MoonAdminProductsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoonAdminProductsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoonAdminProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
