import { VeiculoService } from './../veiculo.service';
import { CreateComponent } from './../create/create.component';
import { VeiculoRoutingModule } from './veiculo.routing.module';
import { VeiculoComponent } from './veiculo.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  imports: [
    CommonModule,
    VeiculoRoutingModule,
    HttpClientModule
  ],
  exports: [],
  declarations: [VeiculoComponent, CreateComponent],
  providers: [VeiculoService],
})
export class VeiculoModule {}
