import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Input } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

//App menu
import { TabMenuModule } from 'primeng/tabmenu';

import { MenuComponent } from './menu/menu.component';

import { ChartModule } from 'primeng/chart';
import { ToastModule } from 'primeng/toast';
import { TooltipModule } from 'primeng/tooltip';

import { MatGridListModule } from '@angular/material/grid-list';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { MatMenuModule } from '@angular/material/menu';

import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { CarouselModule } from 'primeng/carousel';
import { GMapModule } from 'primeng/gmap';
import { AccordionModule } from 'primeng/accordion';

import { NgxSpinnerModule } from 'ngx-spinner';

import { HomeScreenComponent } from './home-screen/home-screen.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { LineChartComponent } from './line-chart/line-chart.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

import { AdminScreenComponent } from './Admin/admin-screen/admin-screen.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { OpenScreenComponent } from './open-screen/open-screen.component';

import { ErrorComponent } from './error/error.component';

@NgModule({
  declarations: [
    AppComponent,

    MenuComponent,

    HomeScreenComponent,
    LineChartComponent,
    LoginComponent,
    RegisterComponent,
    
    AdminScreenComponent,
    ForgotPasswordComponent,
    OpenScreenComponent,

    ErrorComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TabMenuModule,
    ChartModule,
    ToastModule,
    MatGridListModule,
    HttpClientModule,
    InputTextModule,
    ButtonModule,
    TooltipModule,
    CarouselModule,
    BrowserAnimationsModule,
    GMapModule,
    AccordionModule,
    ReactiveFormsModule,
    MatExpansionModule,
    FormsModule,
    MatIconModule,
    MatButtonModule,
    NgxSpinnerModule,
    MatMenuModule,
  ],

  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
