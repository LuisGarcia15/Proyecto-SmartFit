import { Component } from '@angular/core';
import { HeaderComponent } from '../mainComponents/header/header.component'
import { FooterComponent } from '../mainComponents/footer/footer.component'
import { BackendService } from '../services/backend.service';
import { TrainingUnit } from '../models/training-unit';
import { TrainingUnitAddress } from '../models/training-unit-address';
import { RouterLink } from '@angular/router';
import { RegisterComponent } from '../register/register.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-units',
  standalone: true,
  imports: [HeaderComponent, FooterComponent, RouterLink, RegisterComponent],
  templateUrl: './units.component.html',
  styleUrl: './units.component.css'
})
export class UnitsComponent {

  arrayComplete: boolean = false;
  units! : TrainingUnit[];
  register!: RegisterComponent;

  constructor(private service:BackendService) {
    this.service.getAllTrainingUnits().subscribe(gyms => {
      this.units = gyms
    });
    this.register = new RegisterComponent(this.service);
  }

  getFullAddress(gym: TrainingUnitAddress): string{
    return gym.name + "-" + gym.outerNumber + "-" + gym.insideNumber
    + "-" + gym.state + "-" + gym.city;
  }

  showDetailsUnit(unit: TrainingUnit): void{
    this.service.sendTrainingUnit(unit);
  }
}
