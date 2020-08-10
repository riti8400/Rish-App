import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-open-screen',
  templateUrl: './open-screen.component.html',
  styleUrls: ['./open-screen.component.scss']
})
export class OpenScreenComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  userLogin(){
    this.router.navigate(['/login']);
  }
  adminLogin(){
    this.router.navigate(['/admin-login']);
  }

  signUp(){
    this.router.navigate(['/register']);
  }

}
