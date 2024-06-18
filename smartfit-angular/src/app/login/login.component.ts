import { Component } from '@angular/core';
import { LoginHeaderComponent } from './login-header/login-header.component'
import { LoginFooterComponent } from './login-footer/login-footer.component'

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [LoginHeaderComponent, LoginFooterComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
}
