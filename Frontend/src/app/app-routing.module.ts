import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeScreenComponent } from './home-screen/home-screen.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';


import { AdminScreenComponent } from './Admin/admin-screen/admin-screen.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { AuthGuardService } from './Services/auth-guard.service';
import { OpenScreenComponent } from './open-screen/open-screen.component';
import { ErrorComponent } from './error/error.component';
export const routes: Routes = [
  {
    path: '',
    redirectTo: 'open',
    pathMatch: 'full',
  },
  {
    path: 'open',
    component: OpenScreenComponent,
    data: {
      title: 'Welcome',
    },
  },
  {
    path: 'login',
    component: LoginComponent,
    data: {
      title: 'Login Page',
    },
  },
  {
    path: 'home',
    canActivate: [AuthGuardService],
    component: HomeScreenComponent,
    data: {
      title: 'Home Page',
    },
  },
  {
    path: 'register',
    component: RegisterComponent,
    data: {
      title: 'Register Page',
    },
  },

  {
    path: 'admin-login',
    component: LoginComponent,
    data: {
      title: 'Admin Login Page',
    },
  },
  {
    path: 'admin-screen',
    canActivate: [AuthGuardService],
    component: AdminScreenComponent,
    data: {
      title: 'Admin Control Page',
    },
  },
  {
    path: 'forgot-password',
    component: ForgotPasswordComponent,
    data: {
      title: 'Password Changing Page',
    },
  },
  {
    path: '404',
    component: ErrorComponent,
    data: {
      title: 'Error 404',
    },
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
