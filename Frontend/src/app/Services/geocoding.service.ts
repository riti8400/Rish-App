import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class HttpRequestService {
  constructor(private http: HttpClient) {}

  public gethttpResponse(url, data): Observable<any> {
    console.log('Request is sent!');
    // Using the Get method
    const headers = {
      headers: new HttpHeaders({
        'x-rapidapi-host': 'trueway-geocoding.p.rapidapi.com',
        'x-rapidapi-key': 'c39b6e4452msh0537588979cb954p164382jsnb15b36b94b52',
       
      }),
    };
    return this.http.get(url, headers);
  }

  public posthttpRequest(url, data) {
    console.log('Request is sent!');
    // Using the POST method
    const headers = {
      headers: new HttpHeaders({
        'x-rapidapi-host': 'trueway-geocoding.p.rapidapi.com',
        'x-rapidapi-key': 'c39b6e4452msh0537588979cb954p164382jsnb15b36b94b52',
        useQueryString: 'true',
      }),
    };
    return this.http.post(url, data, headers);
  }
}
