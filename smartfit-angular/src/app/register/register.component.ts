import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { TrainingUnit } from '../models/training-unit';
import { FormGroup, FormControl, ReactiveFormsModule, Validators} from '@angular/forms';
import { Plan } from '../models/plan';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  public unit!: TrainingUnit;
  public plans!: Plan[];
  public json!: FormGroup;
  private service!: BackendService;

  constructor(service: BackendService){
    this.service = service;

    this.service.unit$.subscribe(item => {
      this.unit = item;
    });

    this.service.getAllPlans().subscribe(item => {
      this.plans = item
    });

    this.json = new FormGroup({
      user: new FormControl('', [Validators.required, Validators.pattern('^[a-z0-9!#$%&*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$')]),
      password: new FormControl('', [Validators.required, Validators.pattern('^[A-Z]{1}[a-z0-9]+[a-z0-9ñ@!¡#$%&¿?+*-]+'), Validators.minLength(5)]),
      client: new FormGroup({
        name: new FormControl('', [Validators.required, Validators.pattern('^[A-ZÑÁÉÍÓÚÜ ]+$')]),
        paternalSurname: new FormControl('', [Validators.required, Validators.pattern('[A-ZÑÁÉÍÓÚÜ ]+$')]),
        maternalSurname: new FormControl('', [Validators.required, Validators.pattern('[A-ZÑÁÉÍÓÚÜ ]+$')]),
        curp: new FormControl('', [Validators.required, Validators.pattern('^[A-ZÑ0-9]{18}')]),
        phoneNumber: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{10}$')]),
        email: new FormControl(''), //
      }),
      clientAddress: new FormGroup({
        name: new FormControl('', [Validators.required, Validators.pattern('[A-ZÑÁÉÍÓÚÜ ]+$')]),
        outerNumber: new FormControl('', [Validators.required, Validators.pattern('^[0-9]+')]),
        insideNumber: new FormControl('', [Validators.required, Validators.pattern('^[0-9]+')]),
        state: new FormControl('', [Validators.required, Validators.pattern('[A-ZÑÁÉÍÓÚÜ ]+$')]),
        city: new FormControl('', [Validators.required, Validators.pattern('[A-ZÑÁÉÍÓÚÜ ]+$')]),
      }),
      contactPerson: new FormGroup({
        name: new FormControl('', [Validators.required, Validators.pattern('[A-ZÑÁÉÍÓÚÜ ]+$')]),
        paternalSurname: new FormControl('', [Validators.required, Validators.pattern('[A-ZÑÁÉÍÓÚÜ ]+$')]),
        maternalSurname: new FormControl('', [Validators.required, Validators.pattern('[A-ZÑÁÉÍÓÚÜ ]+$')]),
        phoneNumber: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{10}$')]),
      }),
      paymentMethod: new FormGroup({
        fullName: new FormControl('', [Validators.required, Validators.pattern('[A-ZÑÁÉÍÓÚÜ ]+$')]),
        numberCard: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{16}')]),
        numberCVC: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{3}')]),
        dateCard: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{2}-[0-9]{2}')]),
        flag: new FormControl('', Validators.required),
      }),
      payment: new FormGroup({
        paymentDescription: new FormControl('MENSUALIDAD DE JULIO'),
        dueDate: new FormControl('10-AGO-2024'),
        startDate: new FormControl('04/07/2024'),
        endDate: new FormControl('03/08/2024'),
        totalBalance: new FormControl(''),
        flag: new FormControl(''),
      }),
      clientPlanTrainingUnit: new FormGroup({
        startDate: new FormControl('Julio de 2024'),
        planId: new FormControl('', Validators.required),
        trainingUnitId: new FormControl(''),
      })
    });
  }

  test(){

    this.json.value.client.email = this.json.value.user;

    this.json.value.payment.flag = this.json.value.paymentMethod.flag;

    const plan = this.plans.find(item => {
    return item.name === this.json.value.clientPlanTrainingUnit.planId; 
    });

    this.json.value.clientPlanTrainingUnit.planId = plan;

    console.log(plan?.price);

    this.json.value.payment.totalBalance = plan?.price;

    this.json.value.clientPlanTrainingUnit.trainingUnitId = this.unit;

    console.log(this.json);
    console.log(this.json.value)

    this.service.postOneNewClient(this.json.value)

  }

}