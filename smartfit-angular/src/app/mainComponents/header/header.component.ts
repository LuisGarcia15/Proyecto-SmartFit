import { Component} from '@angular/core';
import { Router, RouterOutlet, RouterLink} from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

constructor(private route: Router){}

  isTheRouteCorrect():boolean{
    return this.route.url === "/home"
  }
}
