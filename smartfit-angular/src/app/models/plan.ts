export class Plan{

    public id!: number;
    public name: string;
    public price: number;

    constructor(name:string, price: number){
        this.name = name;
        this.price = price;
    }
  }
