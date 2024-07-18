import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UnitsComponent } from './units/units.component';
import { RegisterComponent } from './register/register.component';
import { ProfileComponent } from './profile/profile.component';


export const routes: Routes = [
{path: 'home', component: HomeComponent},
{path: 'login', component: LoginComponent},
{path: 'gimnasios', component: UnitsComponent},
{ path: '',   redirectTo: '/home', pathMatch: 'full' },
{path: 'test', component: RegisterComponent},
{path: 'profile', component: ProfileComponent},
];
