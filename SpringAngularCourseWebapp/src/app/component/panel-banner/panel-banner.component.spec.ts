import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanelBannerComponent } from './panel-banner.component';

describe('PanelBannerComponent', () => {
  let component: PanelBannerComponent;
  let fixture: ComponentFixture<PanelBannerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PanelBannerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PanelBannerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
