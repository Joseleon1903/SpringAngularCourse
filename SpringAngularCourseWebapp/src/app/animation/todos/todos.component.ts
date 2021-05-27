import { Component } from '@angular/core';
import {bounceIn, fade, fadeParam, slideLeft} from "src/app/animation/todos/Animations";

@Component({
  selector: 'todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css'],
  animations:[
    bounceIn,
    fadeParam
  ]
})
export class TodosComponent {

  items: any[] = [
    'Wash the dishes', 'Walking in the Street', 'Eat an apple'];

  addItem(input: HTMLInputElement) {
    this.items.splice(0, 0, input.value);
    input.value = '';
  }

  removeItem(item: string) {
    let index = this.items.indexOf(item);
    this.items.splice(index, 1);
  }
}
