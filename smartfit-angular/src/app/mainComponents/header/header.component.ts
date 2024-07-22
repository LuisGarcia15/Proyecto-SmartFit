import { Component} from '@angular/core';
import { Router, RouterOutlet, RouterLink} from '@angular/router';
import { BackendService } from '../../services/backend.service';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  private service!: BackendService;
constructor(private route: Router, service: BackendService){}

  isTheRouteCorrect():boolean{
    return this.route.url === "/home"
  }
}
