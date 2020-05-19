import { Component, OnInit } from '@angular/core';
import { Flight } from '../flight';
import { FlightServiceService } from '../flight-service.service';

@Component({
  selector: 'app-update-flight',
  templateUrl: './update-flight.component.html',
  styleUrls: ['./update-flight.component.css']
})
export class UpdateFlightComponent implements OnInit {

  flight:Array<Flight>=[];

  __service:FlightServiceService;

  constructor(_service:FlightServiceService) {
    this.__service=_service;
   }

  ngOnInit(): void {
  }

  addedFlight:Flight=null;
  foundStatus=null;

  updateFlight(form:any){
    let details=form.value;
    let flightNumber=details.flightNumber;
    let flightModel=details.flightModel;
    let carrierName=details.carrierName;
    let seatCapacity=details.seatCapacity;
    this.addedFlight=new Flight();
    this.addedFlight.flightNumber=flightNumber;
    this.addedFlight.flightModel=flightModel;
    this.addedFlight.carrierName=carrierName;
    this.addedFlight.seatCapacity=seatCapacity;
    
    
    let result=this.__service.updateFlightById(this.addedFlight); // adding to the store
    result.subscribe(result=>{
    
      this.foundStatus="found";
    },
    err=>{
      this.foundStatus="notfound";
    console.log("err="+err);
    } );
    form.reset();
    
  }


}
