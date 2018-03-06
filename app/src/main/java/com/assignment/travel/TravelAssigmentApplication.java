package com.assignment.travel;

import android.app.Application;

import com.assignment.travel.di.AppComponent;
import com.assignment.travel.di.AppModule;
import com.assignment.travel.di.DaggerAppComponent;


public class TravelAssigmentApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }
    public AppComponent getAppComponent() {
        return appComponent;
    }

    protected AppComponent initDagger(TravelAssigmentApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }
}
