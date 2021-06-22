import {NotFoundComponent} from "./not-found.component";
describe('NotFoundComponent', ()=>{

  let component : NotFoundComponent;

  beforeEach(()=>{
    // Arrange
    component = new NotFoundComponent();

  });

  it('should return code and description', ()=>{
    //  Act
    let description = component.getDescriptionError();

    // Assert
    expect(description).toContain('404');

  });

});
