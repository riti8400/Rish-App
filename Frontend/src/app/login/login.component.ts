import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { FormsModule } from "@angular/forms";
import { NgxSpinnerService } from "ngx-spinner";
import { HttpRequestService } from "../Services/http-request.service";
import { AuthenticationService } from "../Services/authentication.service";
import { environment } from "src/environments/environment";
import Swal from "sweetalert2";
@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.scss"],
})
export class LoginComponent {
  model: any = {};

  errorMessage: string;
  constructor(
    private _auth: AuthenticationService,
    private router: Router,
    private spinner: NgxSpinnerService,
    private httpService: HttpRequestService
  ) {
    if (this._auth.loggedIn) {
      this.router.navigate(["home"]);
    }
  }

  ngOnInit() {
    sessionStorage.removeItem("UserName");
    sessionStorage.clear();
  }

  inputUserName: any;
  inputPassword: any;
  UserNameValue(event: any) {
    this.inputUserName = (<HTMLInputElement>event.target).value;
  }
  passwordValue(event: any) {
    this.inputPassword = (<HTMLInputElement>event.target).value;
  }
  url: any;
  login() {
    this.spinner.show();

    let login_data = {
      userId: this.inputUserName,
      password: this.inputPassword,
      userRole: "U",
    };
    this.url = environment.weburl + "/loginservices/login";

    if (this.inputUserName != null && this.inputPassword != null) {
      this.httpService
        .posthttpRequest(this.url, login_data)
        .subscribe((responseData: any) => {
          if (
            this._auth.login(responseData.responseBody.loginStatus) &&
            this.router.url === "/admin-login"
          ) {
            this.router.navigate(["/admin-screen"]);
            this.spinner.hide();
          } else if (
            this._auth.login(responseData.responseBody.loginStatus) &&
            this.router.url === "/login"
          ) {
            this.router.navigate(["/home"]);
            this.spinner.hide();
          } else {
            Swal.fire(
              "Invalid Credentials !",
              "Please Check your Username and Password",
              "error"
            );
          }
        });
    } else {
      Swal.fire(
        "Invalid Credentials !",
        "Please Check your Username and Password",
        "error"
      );
    }
  }

  Home() {
    this.spinner.show();
    setTimeout(() => {
      /** spinner ends after 5 seconds */
      this.spinner.hide();
    }, 3000);
    this.router.navigate(["/home"]);
  }
  forgotPassword() {
    this.router.navigate(["forgot-password"]);
  }
}
