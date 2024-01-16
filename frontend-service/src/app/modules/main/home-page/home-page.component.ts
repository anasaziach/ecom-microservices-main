import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductComponent } from '../../../component/product/product.component';
import Product from '../../../models/Product';

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [CommonModule,ProductComponent],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {
  products : Product[]=[
    {
      id: 1,
      productName: 'product1',
      price: 100,
      discription: 'discription1',
      category: 'category1',
      availability: 10
    },
    {
      id: 2,
      productName: 'product2',
      price: 200,
      discription: 'discription2',
      category: 'category2',
      availability: 20
    },
    {
      id: 3,
      productName: 'product3',
      price: 300,
      discription: 'discription3',
      category: 'category3',
      availability: 30
    },
    {
      id: 4,
      productName: 'product4',
      price: 400,
      discription: 'discription4',
      category: 'category4',
      availability: 40
    }
  ]
}
