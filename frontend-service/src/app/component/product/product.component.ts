import { Component,OnInit,Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import Product from '../../models/Product';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit{
  @Input() product !:Product;


  ngOnInit(): void {
    
  }



}