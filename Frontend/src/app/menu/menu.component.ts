import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { HttpRequestService } from '../Services/http-request.service';
import { InputServiceService } from '../Services/input-service.service';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { AuthenticationService } from '../Services/authentication.service';
import { LocationService } from '../Services/location.service';
import { environment } from '../../environments/environment';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss'],
})
export class MenuComponent implements OnInit {
  constructor(
    private httpService: HttpRequestService,
    private inputService: InputServiceService,
    private router: Router,
    private spinner: NgxSpinnerService,
    private _auth: AuthenticationService,
    private location: LocationService
  ) {}

  @Output() submitlocation: EventEmitter<any> = new EventEmitter<any>();
  items: MenuItem[];
  buttonClick = false;
  ngOnInit() {
    this.items = [
      { label: 'Home', icon: 'pi pi-fw pi-home' },
      { label: 'Settings', icon: 'pi pi-fw pi-cog' },
    ];
  }
  inputText: any;
  clickText: any;
  //Lattitude and Longitude of Adrress Will store in these variables
  lattitude: number;
  longitude: number;

  private url: String;
  tempAddress: string;
  private tempUrl: String;
  printValue(event: any) {
    this.inputText = (<HTMLInputElement>event.target).value;
  }
  handleClick() {
    this.spinner.show();
    setTimeout(() => {
      /** spinner ends after 5 seconds */
      this.spinner.hide();
    }, 3500);

    this.clickText = this.inputText;

    this.tempAddress = this.clickText;
    this.tempUrl =
      'https://www.mapquestapi.com/geocoding/v1/address?key=pfQRyGGAPQbaOZGMBoeafIn7YIwq7cRw&location=';
    this.url = this.tempUrl.concat(this.tempAddress);
    this.httpService
      .gethttpResponse(this.url, null)
      .subscribe((responseData: any) => {
        console.log(responseData);
        this.longitude = responseData.results[0].locations[0].latLng.lng;
        this.lattitude = responseData.results[0].locations[0].latLng.lat;
        console.log(this.longitude);
        console.log(this.lattitude);
        this.inputService.sendLocation(
          this.lattitude,
          this.longitude,
          this.clickText
        );
        let locationData: any = {
          lattitude: this.lattitude,
          longitude: this.longitude,
          location: this.clickText,
        };
        this.submitlocation.emit(locationData);
      });
    this.buttonClick = true;
  }
  logout() {
    this._auth.logout();
    this.router.navigate(['/open']);
  }
  home() {
    this.spinner.show();
    setTimeout(() => {
      /** spinner ends after 5 seconds */
      this.spinner.hide();
    }, 3500);
    this.location.getPosition().then((pos) => {
      let latt = pos.lat;
      let long = pos.lng;
      let locationData: any = {
        lattitude: latt,
        longitude: long,
        location: this.clickText,
      };
      this.submitlocation.emit(locationData);
    });
    this.router.navigate(['/home']);
  }
}
