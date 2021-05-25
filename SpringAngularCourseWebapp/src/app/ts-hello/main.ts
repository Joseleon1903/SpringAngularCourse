import {Person} from "./Person";

function dosomething(){

    for(let i = 0; i< 5; i++){
      console.log(i);
    }
    console.log("existing dosomething")
}
dosomething();

// type script variables

let num : number;
let boll : boolean;
let letter : string;
let somthing : any;
let array : number[] = [1,2,3];
let arrayMix : any[] = [1,true, 'a', false];

const ColorRed = 0;
const ColorGreen = 1;
const ColorBlue = 2;

enum Color {Red = 0, Green= 1, Blue=2};

let background = Color.Blue;

// type script assertion
let message;
message = 'abc';
let endWithC =(<string>message).endsWith('c');

let alternativeWay = (message as string).endsWith('a');

// type script arrow function

let doLog = (message) => {
  console.log(message);
};

doLog("Arrow function");

// type script interface

interface Point { x:number, y: number};

let drawCoordinate = (point:Point) =>{

  console.log("Draw coordinate X in : "+ point.x);
  console.log("Draw coordinate Y in : "+ point.y);

};

drawCoordinate({x: 7, y:15});

// type script class
console.log("type script class");

class CoordinateOperation{
  private pointA: Point;
  private pointB : Point;

  constructor(a?: Point, b?:Point){
    this.pointA = a;
    this.pointB = b;
  }

  //property
  get PointA(){ return this.pointA;}

  get PointB(){ return this.pointB;}

  set PointA(value){ this.pointA = value;}

  set PointB(value){ this.pointB = value;}
  //property

  calculateDistance(): number{
    let pA = this.pointA.x + this.pointA.y;
    let pB = this.pointB.x + this.pointB.y;
    return pA - pB;
  }

}
console.log("generate point ");

let PointMadrid :Point = {x : 50, y:30};

let PointVenecia :Point = {x : 30, y:20};

console.log("instanciate class an execute method ");

var operator =  new CoordinateOperation(PointMadrid, PointVenecia);

// operator.pointA = PointMadrid;
// operator.pointB = PointVenecia;
console.log("distance between madrid and venecia is : "+operator.calculateDistance());

//module
console.log("module");

let person = new Person("Mario", "Caseres");

console.log("Person name: "+ person.getFullName());


