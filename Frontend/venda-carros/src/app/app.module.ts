
import { VeiculoGuard } from './guards/veiculo.guard';
import { AuthGuard } from './guards/auth.guard';
import { BrowserModule, HammerModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login/login.component';
import { CommonModule } from '@angular/common';
import { AuthService } from './login/login/auth.service';
import { HomeComponent } from './home/home/home.component';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    HammerModule,
    MatButtonModule,
    MatFormFieldModule
  ],
  providers: [AuthService, AuthGuard, VeiculoGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
