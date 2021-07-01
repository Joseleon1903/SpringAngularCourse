import {Component, Input, Output, EventEmitter} from '@angular/core';
import {BannerError, BannerInfo, BannerInput, BannerWarning} from "./BannerInput";

@Component({
  selector: 'panel-banner',
  templateUrl: './panel-banner.component.html',
  styleUrls: ['./panel-banner.component.css']
})
export class PanelBannerComponent {

  @Input('show-modal') showModal?: Boolean;

  @Input('banner-input') banner?: BannerInput;

  @Output('close-output') closeOutput = new EventEmitter();

  constructor() { }

  getClassStyle(){

    if(this.banner){
      if(this.banner.type == BannerError){
        return "card-header bg-danger text-white";
      }

      if(this.banner.type == BannerInfo){
        return "card-header bg-primary text-white";
      }

      if(this.banner.type == BannerWarning){
        return "card-header bg-warning text-white";
      }
    }
    return "card-header text-white";
  }

  closeModal(){
    this.closeOutput.emit();
  }

}
