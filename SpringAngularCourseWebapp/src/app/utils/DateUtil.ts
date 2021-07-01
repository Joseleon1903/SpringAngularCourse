import {DatePipe} from "@angular/common";

//function for return a current day in format
//yyyy-MM-dd HH:mm:ss AM
export function getCurrentDateInFormat() : string{
  const datepipe: DatePipe = new DatePipe('en-US');
  let formattedDate = datepipe.transform(new Date(), 'YYYY-MM-dd HH:mm:ss a');
  console.log("inside getCurrentDateInFormat return : "+ formattedDate);
  return formattedDate;
}
