import { Injectable } from '@angular/core';
import Product from '../models/Product';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CatalogService {
  products = new BehaviorSubject<Product[]>([]);
  constructor() { }

  async getAll() {
    const products = await fetch("http://localhost:8080/products")
    .then(res=>res.json())
    .then((json :Product[])=>this.products.next(json))
  }


}
