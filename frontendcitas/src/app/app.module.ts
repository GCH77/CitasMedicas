import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CoreModule } from './core/core.module';
import { SharedModule } from './shared/shared.module';
import { AdminModule } from './admin/admin.module';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './pageNotFound/pageNotFound.component';
import { LayoutComponent } from './layout/layout.component';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
   declarations: [
      AppComponent,
      HomeComponent,
      PageNotFoundComponent,
      LayoutComponent
   ],
   imports: [
      BrowserModule,
      AppRoutingModule,
      HttpClientModule,
      NgxPaginationModule,
      CoreModule,
      SharedModule,
      AdminModule
   ],
   providers: [],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
