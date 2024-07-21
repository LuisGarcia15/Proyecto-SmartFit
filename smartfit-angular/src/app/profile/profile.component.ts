import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { BehaviorSubject, Observable } from 'rxjs';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {

  public token!: string;
  public profile!: any;

  constructor(service:BackendService){
    service.token$.subscribe(item => {
      this.token = item
    });

    service.profile$.subscribe(item => {
      this.profile = JSON.stringify(item);
      console.log("Profile desde component: " + this.profile);
    });
  }

}
