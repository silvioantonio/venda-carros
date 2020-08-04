import { VeiculoGuard } from './../../guards/veiculo.guard';
import { CreateComponent } from './../create/create.component';
import { VeiculoComponent } from './veiculo.component';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

const veiculoRoutes = [
  {path: '', component: VeiculoComponent, canActivateChild: [VeiculoGuard], children:[
    {path:'create', component: CreateComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(veiculoRoutes)],
  exports: [RouterModule]
})
export class VeiculoRoutingModule {}
