import { TrainingUnitAddress } from "./training-unit-address";
export class TrainingUnit{
    public name: string;
    public idTrainingUnitAddress: TrainingUnitAddress ;

    constructor(name: string, idTrainingUnitAddress: TrainingUnitAddress){
        this.name = name;
        this.idTrainingUnitAddress = idTrainingUnitAddress;
    }

    public getName(): string{
        return this.name;
    }

    public setName(name: string): void{
        this.name = name;
    }

    public getTrainingUnitAddress(): TrainingUnitAddress{
        return this.idTrainingUnitAddress;
    }

    public setTrainingUnitAddress(idTrainingUnitAddress: TrainingUnitAddress): void{
        this.idTrainingUnitAddress = idTrainingUnitAddress;
    }
  }