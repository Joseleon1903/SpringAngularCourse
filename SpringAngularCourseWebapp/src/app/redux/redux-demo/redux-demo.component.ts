import { Component, OnInit } from '@angular/core';
import {NgRedux , select} from 'ng2-redux';
import {IAppState} from "../IAppState";
import {INCREMENT} from "./ReduxAction";

@Component({
  selector: 'redux-demo',
  templateUrl: './redux-demo.component.html',
  styleUrls: ['./redux-demo.component.css']
})
export class ReduxDemoComponent implements OnInit {

  title ="Redux component";

  @select('counter') count: any;

  @select(['messaging', 'newMessages']) newMessages: any;

  @select((s:IAppState) =>s.messaging) newMessageCount: any;


  constructor(private ngRedux: NgRedux<IAppState>) {
    // ngRedux.subscribe(()=>{
    //   var store = ngRedux.getState();
    //   this.counter = store.counter;
    //   console.log(ngRedux.getState());
    // })
  }

  ngOnInit(): void {
  }



  increment(){
    this.ngRedux.dispatch({type: INCREMENT })
  }

}
