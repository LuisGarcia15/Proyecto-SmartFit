import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { BehaviorSubject, Observable } from 'rxjs';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {

  public token!: string;

  constructor(service:BackendService){
    service.token$.subscribe(item => {
      this.token = item
      console.log(this.token + " inside");
    });

    console.log(this.token + " outside");
  }

}
