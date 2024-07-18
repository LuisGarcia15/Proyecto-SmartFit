export class TrainingUnitAddress{

    public name: string;
    public outerNumber: string;
    public insideNumber: string;
    public state: string;
    public city: string;

    constructor(name:string, outerNumber: string, insideNumber: string, state: string, city: string){
        this.name = name;
        this.outerNumber = outerNumber;
        this.insideNumber = insideNumber;
        this.state = state;
        this.city = city;
    }
  }
