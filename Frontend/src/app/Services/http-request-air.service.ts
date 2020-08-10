import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class HttpRequestAirService {
  constructor(private http: HttpClient) {}
  //Using Get Method
  public getHttpResponse(url, data) {
    const headers = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        accept: 'application/json',
        useQueryString: 'true',
      }),
    };
    return this.http.get(url, headers);
  }

  //Using Post Method
  public postHttpResponse(url, data) {
    const headers = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        accept: 'application/json',
      }),
    };
    return this.http.post(url, data);
  }
}
