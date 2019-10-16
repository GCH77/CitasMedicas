import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './pageNotFound/pageNotFound.component';
import{ LayoutComponent } from './layout/layout.component';

const routes: Routes = [
  { 
    path: '', 
    component: LayoutComponent,
    children: [
      { 
        path: '', 
        redirectTo: '/home',
        pathMatch: 'full' 
      },
      {
        path: 'home',
        component: HomeComponent
      },
      { 
        path: 'admin', 
        loadChildren: () => import('./admin/admin.module').then(adm => adm.AdminModule)
      }
    ]
  },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
