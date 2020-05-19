import { Injectable } from '@angular/core';
import { Flight } from './flight';
import { Observable, observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class FlightServiceService {
  deleteEmployeeById(id: number): Observable<boolean> {
    throw new Error("Method not implemented.");
  }
  client:HttpClient ;
  constructor(client:HttpClient ){
  this.client=client;
  }

  baseFlightUrl="http://localhost:8587/flights";

  /**
  * fires post request to server with flight as body
  * 
  * @param emp 
  */
 addFlight(flight:Flight): Observable<Flight>{
  let url=this.baseFlightUrl+"/add";
  let result:Observable<Flight>= this.client.post<Flight>(url,flight);
  return result;
  }
 
   /**
   * fires get request to server to fetch all flight
   */
  fetchAllFlights():Observable<Flight[]>
  {
    let url=this.baseFlightUrl;
    let observable:Observable<Flight[]> =this.client.get<Flight[]>(url);
    return observable;
  }
  /**
   * fires get request to server to fetch flight for id mentioned in url
   * @param id of flight which has to be fetched
   */
  findFlightById(id:number):Observable<Flight>{
    let url=this.baseFlightUrl+'/get/'+id;
    let observable:Observable<Flight> =this.client.get<Flight>(url);
    return observable;  
  }

  /**
   * fires delete request to server to delete flight by id mentioned in url
   * @param id of flight which has to be deleted
   */
  deleteFlightById(id:number){
    let url=this.baseFlightUrl+"/delete/"+id;
    let result:Observable<boolean>=this.client.delete<boolean>(url);
    return result;
  }

  /**
   * update flight by id mentioned in url
   * @param id of flight which has to be update
   */
  updateFlightById(flight:Flight){
    let url=this.baseFlightUrl+"/update/"+flight.flightNumber;
    let result:Observable<boolean>=this.client.put<boolean>(url,flight);
    return result;
  }

}
