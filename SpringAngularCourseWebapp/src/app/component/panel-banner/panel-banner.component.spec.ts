import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanelBannerComponent } from './panel-banner.component';
import {BannerInput, BannerWarning} from "./BannerInput";
import {By} from "@angular/platform-browser";

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

  it('should contain created banner input param', () => {

    let bannerError: BannerInput  = { type: BannerWarning, title: 'test error tittle', content:'test error content'}
    component.banner = bannerError;

    fixture.detectChanges();

    expect(component.banner.content).toContain('test error content');
  });

  it('should html renderer error tittle', () => {
    let tittle = 'test error tittle';
    let bannerError: BannerInput  = { type: BannerWarning, title: tittle, content:'test error content'}
    component.banner = bannerError;
    component.showModal = true;
    fixture.detectChanges();
    let el:HTMLElement  = fixture.debugElement.query(By.css('.easion-card-title')).nativeElement;
    expect(el.innerText).toContain(tittle);
  });

  it('should html renderer error description', () => {
    let description = 'test error tittle';
    let bannerError: BannerInput  = { type: BannerWarning, title: 'test tittle', content:description}
    component.banner = bannerError;
    component.showModal = true;
    fixture.detectChanges();
    let el:HTMLElement  = fixture.debugElement.query(By.css('.card-body')).nativeElement;
    expect(el.innerText).toContain(description);
  });

  it('should html renderer correct style BannerWarning', () => {
    let style = BannerWarning;
    let bannerError: BannerInput  = { type: style, title: 'test tittle', content:'description'}
    component.banner = bannerError;
    component.showModal = true;
    fixture.detectChanges();
    let el  = fixture.debugElement.query(By.css('#banner'));
    expect(el.classes['bg-warning']).toBeTruthy();
  });


});
