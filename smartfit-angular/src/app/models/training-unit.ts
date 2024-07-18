import { TrainingUnitAddress } from "./training-unit-address";
export class TrainingUnit{

    public id!: number;
    public name: string;
    public idTrainingUnitAddress: TrainingUnitAddress ;

    constructor(name: string, idTrainingUnitAddress: TrainingUnitAddress){
        this.name = name;
        this.idTrainingUnitAddress = idTrainingUnitAddress;
    }

  }