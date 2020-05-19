import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { FlightServiceService } from '../flight-service.service';
import { Flight } from '../flight';

@Component({
  selector: 'app-view-flight',
  templateUrl: './view-flight.component.html',
  styleUrls: ['./view-flight.component.css']
})
export class ViewFlightComponent implements OnInit {
   

  __service:FlightServiceService;
  foundFlight:Flight=null;
  foundStatus=null;

  constructor(__service:FlightServiceService) {
    this.__service=__service;
  }

  ngOnInit(): void {
  }

  findFlightById(form:any):void{
    let details=form.value;
    let id=details.flightNumber;
    let fetched:Observable<Flight> =this.__service.findFlightById(id);
   fetched.subscribe(
    flight=>{
    this.foundFlight=flight; 
    this.foundStatus="found";
     },
    err=>{
      this.foundStatus="notfound";
     console.log("err while fetching flight="+err);  
     }
   ); 

}
}