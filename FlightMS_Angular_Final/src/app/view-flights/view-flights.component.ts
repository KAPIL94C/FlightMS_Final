import { Component, OnInit } from '@angular/core';
import { Flight } from '../flight';
import { FlightServiceService } from '../flight-service.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-view-flights',
  templateUrl: './view-flights.component.html',
  styleUrls: ['./view-flights.component.css']
})
export class ViewFlightsComponent implements OnInit {
  flight:Array<Flight>=[];

  __service:FlightServiceService;

  constructor(__service:FlightServiceService) {
    this.__service=__service;

    let observable:Observable<Flight[]>=this.__service.fetchAllFlights();
  observable.subscribe(
    flight=>{
      this.flight=flight;
     console.log("inside success callback ="+this.flight.length);
    },
    err=>console.log(err)
    );
   }

  

  ngOnInit(): void {
  }

}
