import { Component, OnInit } from '@angular/core';
import { HttpRequestService } from '../../Services/http-request.service';
import { environment } from 'src/environments/environment';
import Swal from 'sweetalert2';
import { NgxSpinnerService } from 'ngx-spinner';
@Component({
  selector: 'app-admin-screen',
  templateUrl: './admin-screen.component.html',
  styleUrls: ['./admin-screen.component.scss'],
})
export class AdminScreenComponent implements OnInit {
  constructor(
    private httpService: HttpRequestService,
    private spinner: NgxSpinnerService
  ) {}
  record: any;

  url: any;
  ngOnInit(): void {
    this.url = environment.weburl + 'admin/getAllUsers';
    this.getUsers();
  }
  getuser: any;
  sendValue(event: any) {
    this.getuser = (<HTMLInputElement>event.target).value;
  }
  active() {
    //console.log(this.getuser);
  }
  status: Array<string> = [];
  getUsers() {
    let get_url = environment.weburl + '/admin/getAllUsers';
    this.httpService
      .gethttpResponse(get_url, null)
      .subscribe((responseData: any) => {
        this.record = responseData.responseBody.allusers;
      });
  }

  changeStatus(username, loginstatus) {
    this.spinner.show();
    this.url = environment.weburl + 'admin/updateLoginStatus';
    let change: any;
    if (loginstatus == 'A') {
      change = false;
    } else {
      change = true;
    }

    let data = { userName: username, doActivate: change };

    this.httpService
      .posthttpRequest(this.url, data)
      .subscribe((response: any) => {
        this.spinner.hide();
        Swal.fire('Updated', 'Status Changed Successfully', 'success');
        this.getUsers();
      });
  }

  generateCode(username) {
    this.spinner.show();
    this.url = environment.weburl + 'admin/generateSecurityCode';
    let data = { userName: username };
    this.httpService
      .posthttpRequest(this.url, data)
      .subscribe((response: any) => {
        if (response.code == 200) {
          Swal.fire('info', response.responseBody, 'info');
        } else {
          Swal.fire('info', response.responseBody, 'error');
        }
        this.spinner.hide();
      });
  }
}
