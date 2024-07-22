import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { TrainingUnit } from '../models/training-unit';
import { Plan } from '../models/plan';
import { RegisteredUser } from '../models/registered-user';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  private url:string = 'http://localhost:8080/'
  private units = new BehaviorSubject<any>(null);
  private token = new BehaviorSubject<any>(null);
  private profile = new BehaviorSubject<any>(null);
  public unit$ = this.units.asObservable();
  public token$ = this.token.asObservable();
  public profile$ = this.profile.asObservable();

  constructor(private http: HttpClient) { 

  }

  sendTrainingUnit(unit: TrainingUnit): void{
    this.units.next(unit);
  }

  setEmptyInformation(): void{
    this.profile.next(null);
    this.token.next(null);
  }

  //Registro de nuevo cliente
  postOneNewClient(newUser: FormGroup, newLogin: any):void{
    const token = this.http.post<any>(this.url+"register", newUser);
    token.subscribe(item=> {
      this.postLoginNewUser(newLogin);
    });
  }

  //Login de nuevo usuario
   postLoginNewUser(newUser: FormGroup):void{
    const token = this.http.post<RegisteredUser>(this.url+"login", newUser);
    token.subscribe(item=> {
      this.token.next(item.jwt);
      this.getAllInformationOneUser(item);
    });
  }

  //Profile de user
  getAllInformationOneUser(token: RegisteredUser): void{
    const information = this.http.get<any>(this.url+"profile", {
      headers: {
          "Authorization" : "Bearer " + token.jwt,
      }
    });

    information.subscribe(item=> {
      this.profile.next(item);
    });
  }

  //Logout
  postLogoutUser(token: string):void{
    this.http.get<any>(this.url+"logout", {
      headers: {
          "Authorization" : "Bearer " + token,
      }
    }).subscribe();
  }

  //Plan
  getAllPlans(): Observable<Plan[]>{
    return this.http.get<Plan[]>(this.url+"plan");
  }

  //Gyms
  getAllTrainingUnits(): Observable<TrainingUnit[]>{
    return this.http.get<TrainingUnit[]>(this.url+"gimnasios");
  }

}
