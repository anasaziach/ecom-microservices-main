import { Injectable } from '@angular/core';
import Product from '../models/Product';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  productData:any = new BehaviorSubject([]);

  constructor() { 

  }



  getCartItems() {
    
  }
  getAll(){
    fetch("http://localhost:8080/products")
    .then(res=>res.json())
    .then(json=>{console.log(json);return json})
    .then((json:Product[])=>this.productData.next(json.map((i:Product)=>i)))
  }


  async get(endpoint:String){
    return fetch('http://localhost:8080/'+endpoint)
  }
}
