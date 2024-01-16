import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainRoutingModule } from './main.route';
import { ProductComponent } from '../../component/product/product.component';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MainRoutingModule,
    ProductComponent
  ]
})
export class MainModule { }
