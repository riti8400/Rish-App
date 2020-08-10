import { Component, OnInit } from '@angular/core';
import { HttpRequestService } from '../Services/http-request.service';
import { CustomvalidationService } from '../Services/customvalidation.service';
import {
  NgForm,
  FormBuilder,
  FormGroup,
  Validators,
  FormControl,
} from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { NgxSpinnerService } from 'ngx-spinner';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss'],
})
export class ForgotPasswordComponent implements OnInit {
  data = false;

  constructor(
    private fb: FormBuilder,
    private formbulider: FormBuilder,
    private router: Router,
    private httpService: HttpRequestService,
    private customValidator: CustomvalidationService,
    private spinner: NgxSpinnerService
  ) {}
  registerForm: FormGroup;
  submitted = false;
  ngOnInit() {
    this.registerForm = this.fb.group(
      {
        securityCode: ['', [Validators.required]],
        username: [
          '',
          [Validators.required],
          this.customValidator.userNameValidator.bind(this.customValidator),
        ],
        password: [
          '',
          Validators.compose([
            Validators.required,
            this.customValidator.patternValidator(),
          ]),
        ],
        confirmPassword: ['', [Validators.required]],
      },
      {
        validator: this.customValidator.MatchPassword(
          'password',
          'confirmPassword'
        ),
      }
    );
  }

  get registerFormControl() {
    return this.registerForm.controls;
  }

  onSubmit() {
    this.spinner.show();
    this.submitted = true;
    if (this.registerForm.valid) {
      let data = {
        userName: this.registerForm.value.username,
        securityCode: this.registerForm.value.securityCode,
        newPassword: this.registerForm.value.password,
        retypeNewPassword: this.registerForm.value.confirmPassword,
      };
      console.log(data);
      let url = environment.weburl + '/loginservices/resetPassword';
      this.httpService.posthttpRequest(url, data).subscribe((response: any) => {
        this.spinner.hide();
        if (response.code == 200) {
          if (response.responseBody.includes('Success')) {
            Swal.fire('', response.responseBody, 'success').then((result) => {
              if (result.value) {
                this.router.navigate(['/open']);
              }
            });
          } else {
            Swal.fire('', response.responseBody, 'error');
          }
        } else {
          Swal.fire('', response.responseBody, 'error');
        }
      });
    }
  }
  Createemployee(user) {}
}
