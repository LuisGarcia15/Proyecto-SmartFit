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

    public getName(): string{
        return this.name;
    }

    public setName(name: string): void{
        this.name = name;
    }

    public getOuterNumber(): string {
        return this.outerNumber;
      }
    
      public setOuterNumber(value: string) {
        this.outerNumber = value;
      }

      public getInsideNumber(): string {
        return this.insideNumber;
      }
    
      public setInsideNumber(value: string) {
        this.insideNumber = value;
      }
    
      public getState(): string {
        return this.state;
      }
    
      public setState(value: string) {
        this.state = value;
      }
    
      public getCity(): string {
        return this.city;
      }
    
      public setCity(value: string) {
        this.city = value;
      }

  }
