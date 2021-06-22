import {greet} from "./greet";

describe('greet', ()=>{

  it('should includ the name in the output', ()=>{

   expect(greet('mario')).toContain('mario');

  });

});
