import {INCREMENT} from "./redux-demo/ReduxAction";

export interface IAppState{

  counter:number;
  messaging?:{
    newMessages:number;
  }


}

export const  INITIAL_STATE: IAppState={
  counter :0,
  messaging: {newMessages: 0}

};

export function rootReducer(state: IAppState , action: any): IAppState{
  switch (action.type){

    //Object.assign combina diferentes objetos en uno solo
    case INCREMENT: return Object.assign({}, state, {counter: state.counter +1});


  }
  return state;
}
