import { Component } from '@angular/core';
import { TrainingUnitsService } from '../services/training-units.service';
import { TrainingUnit } from '../models/training-unit';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  public unit!: TrainingUnit;
  private service!: TrainingUnitsService;
  public a: string = "S";

  constructor(service: TrainingUnitsService){
    this.service = service;
    this.service.getTrainingUnit().subscribe(item => {
      this.unit = item;
      console.log("name: " + this.unit.name + "|" 
        + "name: " + this.unit.idTrainingUnitAddress.name + "|"
        + "name: " + this.unit.idTrainingUnitAddress.outerNumber + "|"
        + "name: " + this.unit.idTrainingUnitAddress.insideNumber + "|"
        + "name: " + this.unit.idTrainingUnitAddress.state + "|"
        + "name: " + this.unit.idTrainingUnitAddress.city + "|")
    });
  }
}
