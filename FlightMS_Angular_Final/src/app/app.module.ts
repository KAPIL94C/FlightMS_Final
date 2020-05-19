import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddFlightsComponent } from './add-flights/add-flights.component';
import { ViewFlightsComponent } from './view-flights/view-flights.component';
import { ViewFlightComponent } from './view-flight/view-flight.component';
import { DeleteFlightComponent } from './delete-flight/delete-flight.component';
import { HttpClientModule } from '@angular/common/http';
import { FlightServiceService } from './flight-service.service';
import { UpdateFlightComponent } from './update-flight/update-flight.component';

@NgModule({
  declarations: [
    AppComponent,
    AddFlightsComponent,
    ViewFlightsComponent,
    ViewFlightComponent,
    DeleteFlightComponent,
    UpdateFlightComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [FlightServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
