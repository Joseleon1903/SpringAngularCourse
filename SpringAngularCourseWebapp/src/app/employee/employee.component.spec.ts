import {EmployeeComponent} from "./employee.component";
import {EmployeeService} from "./employee.service";
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/from';
import {Employee} from "./Employee";

describe('EmployeeComponent', ()=>{

  let component : EmployeeComponent;
  let service : EmployeeService;

  beforeEach(()=>{
    service =  new EmployeeService(null);
    component =  new EmployeeComponent(service);

  });

  it('should return a list of employee from de service ', () =>{

    let employees : Employee[] = [{id : 1, name: 'mario', email:'mario@test.com'},
      {id : 2, name: 'silvio', email:'silvio@test.com'}];

    spyOn(service, 'getEmployees').and.callFake( () => {
      return Observable.from([employees]);
    });

    component.getEmployees();

    expect(component.employees.length).toBeGreaterThan(0);

  });

});
