import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-post-image',
  templateUrl: './post-image.component.html',
  styleUrls: ['./post-image.component.css']
})
export class PostImageComponent implements OnInit {

  @Input('is-favorite') isFavorite: boolean;

  @Input('title') postTitle: string;

  @Output('changeOutput') change = new EventEmitter();

  imageUrl='';

  imagePageUrl = 'https://www.miltons.law.za/wp-content/uploads/2019/02/employees.jpg';

  secondImageUrl= 'https://amerisleep.com/blog/wp-content/uploads/2016/08/work-affects-your-sleep.png';

  constructor() { }

  ngOnInit(): void {
    this.imageUrl= this.imagePageUrl;
  }

  onClick(){

    this.isFavorite = !this.isFavorite;

    if(this.isFavorite){
      this.imageUrl= this.imagePageUrl;
    }else{
      this.imageUrl= this.secondImageUrl;
    }
    this.change.emit(this.isFavorite);
  }

}
