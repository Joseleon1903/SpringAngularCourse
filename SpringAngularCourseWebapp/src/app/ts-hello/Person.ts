export class Person{

  constructor(private name?: string, private lastName?:string){}

  getFullName(): string{
    return this.name +" "+this.lastName;
  }

}
