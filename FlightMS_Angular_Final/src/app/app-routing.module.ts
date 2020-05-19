import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewFlightComponent } from './view-flight/view-flight.component';
import { ViewFlightsComponent } from './view-flights/view-flights.component';
import { AddFlightsComponent } from './add-flights/add-flights.component';
import { DeleteFlightComponent } from './delete-flight/delete-flight.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';


const routes: Routes = [
  {
    path:'add-flight',
    component:AddFlightsComponent
  },
  
  {
   path:'view-flight',
   component:ViewFlightComponent
  }
  ,
  {
    path:'view-flights',
    component:ViewFlightsComponent
  }
,
{
  path:'delete-flight',
  component:DeleteFlightComponent
},
{
  path:'update-flight',
  component:UpdateFlightComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
