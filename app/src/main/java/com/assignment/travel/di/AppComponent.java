package com.assignment.travel.di;


import com.assignment.travel.repository.TravelWebServiceInteractor;
import com.assignment.travel.ui.home.HomeActivity;
import com.assignment.travel.ui.home.HomePresenter;

import javax.inject.Singleton;

import dagger.Component;



    @Singleton
    @Component(modules = {AppModule.class, PresenterModule.class,NetworkModule.class,ModelModule.class})
    public interface AppComponent {

        void inject(HomeActivity homeActivity);
        void inject(TravelWebServiceInteractor webServiceInteractor);
        void inject(HomePresenter homePresenter);
    }


