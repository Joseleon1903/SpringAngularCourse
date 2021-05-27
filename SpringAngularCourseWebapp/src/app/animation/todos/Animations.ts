
import {animate, animation, keyframes, state, style, transition, trigger, useAnimation} from "@angular/animations";

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

export let fadeInAnimation = animation([
  style({opacity:0}),
  animate(2000)
]);

export let fadeParam = trigger('fadeP', [

  transition(':enter',
    useAnimation(fadeInAnimation)
  ),
  transition(':leave', [
    animate(2000)
  ])
]);

