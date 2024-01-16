import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import Product from '../../models/Product';

@Component({
  selector: 'app-product-cart',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product-cart.component.html',
  styleUrl: './product-cart.component.css'
})
export class ProductCartComponent {
  @Input() product!: Product;
  @Input() quantity!: number;
}
