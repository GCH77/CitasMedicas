import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HeaderComponent} from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { PaginationComponent } from './components/pagination/pagination.component';


@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    PaginationComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    PaginationComponent
  ]
})
export class SharedModule { }
