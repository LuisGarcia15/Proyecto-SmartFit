import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AsyncSubject, Observable, Subject } from 'rxjs';
import { TrainingUnit } from '../models/training-unit';

@Injectable({
  providedIn: 'root'
})
export class TrainingUnitsService {

  private url:string = 'http://localhost:8080/gimnasios'
  private subject = new Subject<TrainingUnit>();

  constructor(private http: HttpClient) { 

  }

  getAllTrainingUnits(): Observable<TrainingUnit[]>{
    return this.http.get<TrainingUnit[]>(this.url);
  }

  sendTrainingUnit(unit: TrainingUnit): void{
    this.subject.next(unit);
  }

  getTrainingUnit(): Observable<TrainingUnit>{
    return this.subject.asObservable();
  }
}
