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
  public newUser!: FormGroup;
  private service!: BackendService;

  constructor(service: BackendService){
    this.service = service;

    this.service.unit$.subscribe(item => {
      this.unit = item;
    });

    this.service.getAllPlans().subscribe(item => {
      this.plans = item
    });

    this.newUser = new FormGroup({
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

    this.newUser.value.client.email = this.newUser.value.user;

    this.newUser.value.payment.flag = this.newUser.value.paymentMethod.flag;

    const plan = this.plans.find(item => {
    return item.name === this.newUser.value.clientPlanTrainingUnit.planId; 
    });

    this.newUser.value.clientPlanTrainingUnit.planId = plan;

    this.newUser.value.payment.totalBalance = plan?.price;

    this.newUser.value.clientPlanTrainingUnit.trainingUnitId = this.unit;

//    console.log(this.newUser);
//    console.log(this.newUser.value);

    const newLogin = {
      user: this.newUser.value.user,
      password: this.newUser.value.password,
    };

    this.service.postOneNewClient(this.newUser.value, newLogin)

  }

}