import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { TrainingUnit } from '../models/training-unit';
import { Plan } from '../models/plan';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  private url:string = 'http://localhost:8080/'
  private units = new BehaviorSubject<any>(null);
  public unit$ = this.units.asObservable();

  constructor(private http: HttpClient) { 

  }

  //Plan
  getAllPlans(): Observable<Plan[]>{
    return this.http.get<Plan[]>(this.url+"plan");
  }

  //Gyms
  getAllTrainingUnits(): Observable<TrainingUnit[]>{
    return this.http.get<TrainingUnit[]>(this.url+"gimnasios");
  }

  sendTrainingUnit(unit: TrainingUnit): void{
    this.units.next(unit);
  }

}
