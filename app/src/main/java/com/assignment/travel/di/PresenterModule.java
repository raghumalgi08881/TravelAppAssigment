package com.assignment.travel.di;

import android.content.Context;

import com.assignment.travel.repository.TravelWebServiceInteractor;
import com.assignment.travel.ui.home.HomeContract;
import com.assignment.travel.ui.home.HomePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

  @Provides
  @Singleton
  HomeContract.UserActionsListener provideRoomsListPresenter(Context context) {
    return new HomePresenter(context);
  }


  @Provides
  @Singleton
  TravelWebServiceInteractor provideRoomsRepo(Context context) {
    return new TravelWebServiceInteractor(context);
  }
}