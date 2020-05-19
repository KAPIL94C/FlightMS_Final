import { Component, OnInit } from '@angular/core';
import { FlightServiceService } from '../flight-service.service';
import { Observable } from 'rxjs';
import { Flight } from '../flight';

@Component({
  selector: 'app-delete-flight',
  templateUrl: './delete-flight.component.html',
  styleUrls: ['./delete-flight.component.css']
})
export class DeleteFlightComponent implements OnInit {

  __service:FlightServiceService;
  flight:Array <Flight>=[];
  deleteStatus=null;
  constructor(__service:FlightServiceService) {
    this.__service=__service;
  }

  ngOnInit(): void {
  }

  
  
  deleteFlightById(form:any):void{
    let details=form.value;
    let id=details.flightNumber;
    let result:Observable<boolean>=this.__service.deleteFlightById(id);
    result.subscribe(flight=>{
        this.removeLocalFlight(id);
        this.deleteStatus="Deleted";
        
    },err=>{
      this.deleteStatus="notDeleted"
     console.log("err in deleteing flight="+err);
    })
    this.deleteStatus=null;
    form.reset();
    
      }

 /**
  * remove the flight object in local array  so that it will be reflected in the view
  * @param id 
  */     
removeLocalFlight(id:number){
  let foundIndex=-1;
  for(let i=0;i<this.flight.length;i++){
    let flight=this.flight[i];
    if(flight.flightNumber===id){
      foundIndex=i;
      break;
    }
  }
  if(foundIndex<0){
    return;
  }
  this.flight.splice(foundIndex,1);
}



}
