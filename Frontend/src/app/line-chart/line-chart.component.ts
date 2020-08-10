import { Component, OnInit } from '@angular/core';
import * as $ from '../../../node_modules/jquery/dist/jquery.min.js';
import * as CanvasJS from './canvasjs.min';
import { HttpRequestService } from '../Services/http-request.service';
import { LocationService } from '../Services/location.service';
import { MAT_LABEL_GLOBAL_OPTIONS } from '@angular/material/core';
import { environment } from 'src/environments/environment.js';

@Component({
  selector: 'app-line-chart',
  templateUrl: './line-chart.component.html',
  styleUrls: ['./line-chart.component.scss'],
})
export class LineChartComponent implements OnInit {
  constructor(
    private httpService: HttpRequestService,
    private locationService: LocationService
  ) {}
  lat: any;
  lon: any;
  url: any;
  hourlyTemp: any[];
  ngOnInit() {
    this.locationService.getPosition().then((pos) => {
      let dataPoints = [];
      let dpsLength = 0;
      let chart = new CanvasJS.Chart('chartContainer', {
        exportEnabled: true,
        height: 200,
        colorSet: 'greenShades',
        backgroundColor: ' #f2f2f2',
        title: {
          text: '',
        },

        axisX: {
          interval: 1,

          gridThickness: 0,
        },
        axisY: {
          gridThickness: 0,
        },

        data: [
          {
            type: 'area',

            indexLabel: '{y}℃',

            dataPoints: dataPoints,
          },
        ],
      });
      this.lat = pos.lat;
      this.lon = pos.lng;

      this.url = environment.weburl + '/weather-api/hourlyWhether';
      let spring_data = { lattitude: this.lat, longitude: this.lon };
      this.httpService
        .posthttpRequest(this.url, spring_data)
        .subscribe((responseData) => {
          let yVal = new Array(48).fill(0.0);
          let xVal = new Array(48).fill(0);
          for (let i = 0; i < 48; i++) {
            yVal[i] = parseInt((responseData[i].temp - 274.15).toFixed(2));
            let timestamp = responseData[i].dt;
            let a = new Date(timestamp * 1000);
            xVal[i] = a.getHours();
          }
          let desc = new Array(48).fill(0);
          for (let i = 0; i < 48; i++) {
            xVal[i] = i;
            desc[i] = responseData[i].weather[0].main;
          }

          let updateInterval = 1000;
          let maxDataLength = 5; // number of dataPoints after which the series shifts
          let time = new Date();
          let updateCount = 0;

          let updateChart = function (count) {
            count = count || 1;

            for (let j = 0; j < count; j++) {
              time.setSeconds(time.getSeconds() + 1);

              dataPoints.push({
                x: xVal[updateCount % xVal.length],
                y: yVal[updateCount % yVal.length],
                label: desc[updateCount % desc.length],
              });

              updateCount++;

              if (dataPoints.length > maxDataLength) {
                dataPoints.shift();
              }
            }

            chart.render();
          };

          // generates first set of dataPoints
          updateChart(maxDataLength);

          // update chart after specified time.
          setInterval(function () {
            updateChart(null);
          }, updateInterval);
        });
    });
  }
}
