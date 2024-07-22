import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {

  public token!: string;
  public profile!: any;
  public service!: BackendService;

  constructor(service:BackendService){
    this.service = service
    this.service.token$.subscribe(item => {
      this.token = item
    });

    this.service.profile$.subscribe(item => {
      this.profile = JSON.stringify(item);
    });
  }

  logout(): void{
    this.service.postLogoutUser(this.token)
    this.service.setEmptyInformation();
    this.token = "";
    this.profile = undefined;
  }
}
