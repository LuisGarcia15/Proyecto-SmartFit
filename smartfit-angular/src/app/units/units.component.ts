import { Component } from '@angular/core';
import { HeaderComponent } from '../mainComponents/header/header.component'
import { FooterComponent } from '../mainComponents/footer/footer.component'

@Component({
  selector: 'app-units',
  standalone: true,
  imports: [HeaderComponent, FooterComponent],
  templateUrl: './units.component.html',
  styleUrl: './units.component.css'
})
export class UnitsComponent {

}
