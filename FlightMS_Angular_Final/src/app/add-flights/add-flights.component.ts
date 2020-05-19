import { Component, OnInit } from '@angular/core';
import { FlightServiceService } from '../flight-service.service';
import { Flight } from '../flight';

@Component({
  selector: 'app-add-flights',
  templateUrl: './add-flights.component.html',
  styleUrls: ['./add-flights.component.css']
})
export class AddFlightsComponent implements OnInit {

  flight:Array<Flight>=[];

  __service:FlightServiceService;

  constructor(_service:FlightServiceService) {
    this.__service=_service;
   }

  ngOnInit(): void {
  }

  addedFlight:Flight=null;

  addFlight(form:any){
    let details=form.value;
    let flightModel=details.flightModel;
    let carrierName=details.carrierName;
    let seatCapacity=details.seatCapacity;
    this.addedFlight=new Flight();
    this.addedFlight.flightModel=flightModel;
    this.addedFlight.carrierName=carrierName;
    this.addedFlight.seatCapacity=seatCapacity;
    
    
    let result=this.__service.addFlight(this.addedFlight); // adding to the store
    result.subscribe((flight:Flight)=>{
      this.addedFlight=flight;
    },
    err=>{
    console.log("err="+err);
    } );
    form.reset();
    
  }

}
