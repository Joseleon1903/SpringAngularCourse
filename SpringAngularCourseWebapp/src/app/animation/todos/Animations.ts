
import {animate, keyframes, style, transition, trigger} from "@angular/animations";

export let fade= trigger('fade', [

  transition('void=>*', [
    style( {opacity:0} ),
    animate(3000)
  ]),
  transition('* =>void',[
    animate(2000, style({opacity:0}))
  ])
]);

export let slideLeft = trigger('slide', [

  transition(':enter', [
    style({transform: 'translateX(-10px)'}),
    animate(500)
  ]),
  transition(':leave', [
    style({transform: 'translateX(-100%)'}),
    animate('0.5s ease-in')
  ]),


]);

export const bounceIn = trigger('bounceIn', [
  transition(':enter', [
    style({ transform: 'scale(0.5)', opacity: 0 }),
    animate('0.5s cubic-bezier(.8, -0.6, 0.2, 1.5)',
      style({ transform: 'scale(1)', opacity: 1 }))
  ])
]);

export const advanceBounceIn = trigger('advanceBounceIn', [
  transition(':enter', [
    style({ transform: 'scale(0.5)', opacity: 0 }),
    animate('0.5s cubic-bezier(.8, -0.6, 0.2, 1.5)',
      keyframes([
      style({ opacity: 0, transform: 'translate3d(0, 3000px, 0)', scaleY:5 }),
      style({  opacity: 1, transform: 'translate3d(0, -20px, 0)', scaleY: 0.9}),
      style({ transform: 'translate3d(0, 10px, 0)', scaleY:0.95 }),
      style({ transform: 'translate3d(0, -5px, 0)', scaleY:0.985}),
        style({ transform:'translate3d(0, 0, 0)'})
      ]))
  ])
]);

