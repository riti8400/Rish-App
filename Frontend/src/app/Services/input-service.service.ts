import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class InputServiceService {
  constructor() {}
  private _lattitude = new Subject<number>();
  private _longitude = new Subject<number>();
  private _location=new Subject<String>();
  lati$ = this._lattitude.asObservable();
  longi$ = this._longitude.asObservable();
  loci$=this._location.asObservable();

  sendLocation(coord1: number, coord2: number,loc:String) {
    this._lattitude.next(coord1);
    this._longitude.next(coord2);
    this._location.next(loc);
  }
}
