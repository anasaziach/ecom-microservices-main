import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import Product from '../../../models/Product';
import { ProductComponent } from '../../../component/product/product.component';
import { CartItem } from '../../../models/Cart';
import { ProductCartComponent } from '../../../component/product-cart/product-cart.component';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule,ProductComponent,ProductCartComponent],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css'
})
export class CartComponent {
  cartItems : CartItem[] =[
    {
      product:{
        id: 1,
        productName: 'product1',
        price: 100,
        discription: 'discription1',
        category: 'category1',
        availability: 10
      },
      quantity:1
    },
    {
      product:{
        id: 2,
        productName: 'product2',
        price: 200,
        discription: 'discription2',
        category: 'category2',
        availability: 20
      },
      quantity:2
    }
  ]
}
