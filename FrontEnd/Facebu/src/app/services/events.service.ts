import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Events } from '../model/events';
import { Observable } from 'rxjs/internal/Observable';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'my-auth-token',
    'Access-Control-Allow-Origin': '*'
  })
};

@Injectable({
  providedIn: 'root'
})
export class EventsService {

  constructor(private http: HttpClient) { }

  getAllEvents(): Observable<Events[]> {
    return this.http.get<Events[]>('http://localhost:8080/events', httpOptions);
  }

  getAllEventsYesAssistance() {
    return this.http.get('http://localhost:8080/events/user/{id}/yesAssistance');
  }

  getAllEventsNotAssistance() {
    return this.http.get('http://localhost:8080/events/user/{id}/notAssistance');
  }

  postEvent(events: Events){
    let json = JSON.stringify(events);
    let params = "json="+json;
    let headers = new HttpHeaders().set('Content-Type','application/x-www-form-urlencoded');
     
    return this.http.post('http://localhost:8080/events', params, {headers: headers});
  }

  postEventYesAssistance(events: Events){
    let json = JSON.stringify(events);
    let params = "json="+json;
    let headers = new HttpHeaders().set('Content-Type','application/x-www-form-urlencoded');
     
    return this.http.post('http://localhost:8080/events/user/{id}/yesAssistance', params, {headers: headers});
  }

  postEventNotAssistance(events: Events){
    let json = JSON.stringify(events);
    let params = "json="+json;
    let headers = new HttpHeaders().set('Content-Type','application/x-www-form-urlencoded');
     
    return this.http.post('http://localhost:8080/events/user/{id}/notAssistance', params, {headers: headers});
  }
  
}
