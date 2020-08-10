import { Component, OnInit } from '@angular/core';
import { HttpRequestService } from '../Services/http-request.service';
import { HttpRequestAirService } from '../Services/http-request-air.service';
import { LocationService } from '../Services/location.service';
import { InputServiceService } from '../Services/input-service.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-home-screen',
  templateUrl: './home-screen.component.html',
  styleUrls: ['./home-screen.component.scss'],
})
export class HomeScreenComponent implements OnInit {
  mySubscription: any;
  constructor(
    private httpService: HttpRequestService,
    private httpAirService: HttpRequestAirService,
    private locationService: LocationService,
    private inputService: InputServiceService,
    private SpinnerService: NgxSpinnerService,
    private router: Router
  ) {}
  Location: String;
  Weather: String;
  Temperature: any;
  mainImage: any;
  private url: String;
  private beforeConcatUrl: String;
  q: string = 'Noida,India';
  //Air Pollution Variables
  aqi: any;
  aqiQuality: string;
  lat: any = 0;
  pm25: Array<number> = [];
  pm10: Array<number> = [];
  domPol: Array<string> = [];
  //Timestamp Conversion
  timestamp: any;
  a: any;
  weekDay: any;
  days: any[] = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
  month: any[] = [
    'Jan',
    'Feb',
    'March',
    'April',
    'May',
    'June',
    'July',
    'Aug',
    'Sept',
    'Nov',
    'Dec',
  ];
  lon: any = 0;
  index: any = true;
  //Accordion
  panelOpenState = true;
  icons: Array<string> = [];
  dailyDate: any = [];
  image: Array<string> = [];
  imageurl: string = '../assets/weather-icons/';
  dailyinfo: any = [];
  weatherMain: Array<string> = [];
  weatherDesc: Array<string> = [];
  maxTemp: Array<string> = [];
  minTemp: Array<string> = [];
  humidity: Array<number> = [];
  wind_speed: Array<number> = [];
  pressure: Array<number> = [];
  //Main screen functioning
  ngOnInit(): void {
    this.SpinnerService.show();
    setTimeout(() => {
      /** spinner ends after 5 seconds */
      this.SpinnerService.hide();
    }, 2000);

    this.locationService.getPosition().then((pos) => {
      this.lat = pos.lat;
      this.lon = pos.lng;

      let spring_data = { lattitude: this.lat, longitude: this.lon };

      this.updateCurrentWeatherData();
      this.updateDailyWeatherData();

      this.updateAirPollutionData();
    });
  }

  public updateCurrentWeatherData() {
    this.url = environment.weburl + '/weather-api/currentWhether';
    let spring_data = { lattitude: this.lat, longitude: this.lon };
    this.httpService.posthttpRequest(this.url, spring_data).subscribe(
      (responseData: any) => {
        //TimeStampConversion
        this.timestamp = responseData.dt;
        this.a = new Date(this.timestamp * 1000);
        this.weekDay = this.days[this.a.getDay()];

        //Weather Forecast

        this.Weather = responseData.weather[0].description;
        this.Temperature = responseData.temp;
        this.Temperature = (this.Temperature - 274.15).toFixed(2);
        this.mainImage = this.imageurl.concat(responseData.weather[0].icon);
        this.mainImage = this.mainImage.concat('@2x.png');
      },
      (error) => {
        this.router.navigate(['/404']);
      }
    );
  }
  public updateDailyWeatherData() {
    this.url = environment.weburl + '/weather-api/dailyWhether';
    let spring_data = { lattitude: this.lat, longitude: this.lon };
    this.httpService
      .posthttpRequest(this.url, spring_data)
      .subscribe((responseData: any) => {
        this.icons = new Array(8).fill('0');
        this.image = new Array(8).fill('0');
        this.minTemp = new Array(8).fill(0);
        this.maxTemp = new Array(8).fill(0);
        this.humidity = new Array(8).fill(0);
        this.wind_speed = new Array(8).fill(0);
        this.pressure = new Array(8).fill(0);
        for (let i = 0; i < 8; i++) {
          this.icons[i] = responseData[i].weather[0].icon;

          this.image[i] = this.imageurl.concat(this.icons[i]);
          this.image[i] = this.image[i].concat('@2x.png');
        }
        //DailyAccordion
        this.dailyDate = new Array(8).fill(0);
        for (let i = 0; i < 8; i++) {
          this.timestamp = responseData[i].dt;
          this.a = new Date(this.timestamp * 1000);
          this.weekDay = this.days[this.a.getDay()];
          this.dailyDate[i] =
            this.weekDay +
            ', ' +
            this.month[this.a.getMonth()] +
            ' ' +
            this.a.getDate();
        }

        this.dailyinfo = new Array(8).fill(0);
        for (let i = 0; i < 8; i++) {
          this.dailyinfo[i] = (responseData[i].temp.day - 274.15).toFixed(2);
          this.minTemp[i] = (responseData[i].temp.min - 274.15).toFixed(2);
          this.maxTemp[i] = (responseData[i].temp.min - 274.15).toFixed(2);
          this.pressure[i] = responseData[i].pressure;
          this.humidity[i] = responseData[i].humidity;
          this.wind_speed[i] = responseData[i].wind_speed;
        }

        for (let i = 0; i < 8; i++) {
          this.weatherMain[i] = responseData[i].weather[0].main;
          this.weatherDesc[i] = responseData[i].weather[0].description;
        }
      });
  }
  updateAirPollutionData() {
    this.url = environment.weburl + '/airQuality/airQualityForcast';
    let spring_data = { lattitude: this.lat, longitude: this.lon };
    this.httpAirService
      .postHttpResponse(this.url, spring_data)
      .subscribe((responseData: any) => {
        this.aqi = responseData.responseBody.data.aqi;
        if (this.aqi >= 0 && this.aqi <= 50) {
          this.aqiQuality = 'Good';
        } else if (this.aqi > 50 && this.aqi <= 100) {
          this.aqiQuality = 'Moderate';
        } else if (this.aqi > 100 && this.aqi <= 200) {
          this.aqiQuality = 'Unhealthy';
        } else if (this.aqi > 200 && this.aqi <= 300) {
          this.aqiQuality = 'Very Unhealthy';
        } else if (this.aqi > 300 && this.aqi <= 500) {
          this.aqiQuality = 'Hazardous';
        } else {
          this.aqiQuality = 'Deadly';
        }
        this.pm25 = new Array(7).fill(0);
        this.pm10 = new Array(7).fill(0);
        this.domPol = responseData.responseBody.data.dominentpol;
        let len = responseData.responseBody.data.forecast.daily.pm10.length;
        for (let i = 2; i < len; i++) {
          this.pm25[i - 2] =
            responseData.responseBody.data.forecast.daily.pm25[i].avg;
          this.pm10[i - 2] =
            responseData.responseBody.data.forecast.daily.pm10[i].avg;
        }

        let city = responseData.responseBody.data.city.name;
        let spl = city.split(',');

        let n = spl.length;
        this.Location = spl[n - 2] + ',' + spl[n - 1];
      });
  }
  public updateLocation(event: any) {
    this.lat = event.lattitude;
    this.lon = event.longitude;
    this.Location = event.location;
    this.updateCurrentWeatherData();
    this.updateDailyWeatherData();
    this.updateAirPollutionData();
  }
}
