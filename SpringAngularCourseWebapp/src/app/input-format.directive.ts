import {Directive, HostListener, ElementRef, Input} from '@angular/core';

@Directive({
  selector: '[appInputFormat]'
})
export class InputFormatDirective {

  @Input('appInputFormat') format:string;


  @HostListener('focus') onFoculs(){
    console.log("entering in onFocus");

  }

  @HostListener('blur') onBlur(){

    console.log("entering in onBlur");

    let value: string = this.el.nativeElement.value;
    if(this.format == 'lowercase'){
      this.el.nativeElement.value = value.toLowerCase();
    }else
    {
      this.el.nativeElement.value = value.toUpperCase();
    }

  }

  constructor(private el: ElementRef) { }

}
