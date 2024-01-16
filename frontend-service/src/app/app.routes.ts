import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadChildren: () => import('./modules/main/main.module').then(m => m.MainModule)
    }
];
