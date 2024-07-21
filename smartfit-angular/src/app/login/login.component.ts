import { Component } from '@angular/core';
import { LoginHeaderComponent } from './login-header/login-header.component'
import { LoginFooterComponent } from './login-footer/login-footer.component'
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { BackendService } from '../services/backend.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [LoginHeaderComponent, LoginFooterComponent, ReactiveFormsModule, RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  public userValidation!: FormGroup;
  private service!: BackendService;

  constructor(service: BackendService){
    this.service = service;
    this.userValidation = new FormGroup({
      user: new FormControl('', [Validators.required, Validators.pattern('^[a-z0-9!#$%&*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$')]),
      password: new FormControl('', [Validators.required, Validators.pattern('^[A-Z]{1}[a-z0-9]+[a-z0-9ñ@!¡#$%&¿?+*-]+'), Validators.minLength(5)]),
    });
  }

  authenticationUser(): void{
    this.service.postLoginNewUser(this.userValidation.value);
  }
}
