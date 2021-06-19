import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Destination} from "./Destination";
import {Observable} from "rxjs/Rx";

@Injectable({
  providedIn:'root'
})
export class DestinationService{

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient){}

  getPreferenceList(){
    return ["Developers", "Analist", "UX", "Quality","Management","Lead"];
  }

  public getAllDestination(): Observable<Destination[]>{
    return this.http.get<Destination[]>(`${this.apiServerUrl}/destination`)
  }

}
