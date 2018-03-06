package com.assignment.travel.ui.home;

import android.content.Context;

import com.assignment.travel.TravelAssigmentApplication;
import com.assignment.travel.model.ApiResponse;
import com.assignment.travel.model.Carousel;
import com.assignment.travel.repository.TravelWebServiceInteractor;
import com.assignment.travel.repository.TravelWebserviceListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class HomePresenter implements HomeContract.UserActionsListener,TravelWebserviceListener {

    @Inject
    TravelWebServiceInteractor webServiceInteractor;

    private HomeContract.View  view;


    public HomePresenter(Context context) {
        ((TravelAssigmentApplication)context).getAppComponent().inject(this);

    }


    @Override
    public void setView(HomeContract.View view){
        this.view = view;
    }





    @Override
    public void onSuccess(ApiResponse response) {
        view.setProgressIndicator(false);
        view.loadResponse(response);
    }


    @Override
    public List<Carousel> filterCarousels(List<Carousel> carousels, List<Integer> ids){
        List<Carousel> carouselList = new ArrayList<>();
        for (Carousel carousel :carousels){
            if(ids.contains(carousel.id)){
                carouselList.add(carousel);
            }
        }

        return carouselList;

    }

    @Override
    public void onFailure() {
        view.setProgressIndicator(false);
        view.failedToFetchResponse();
    }

    @Override
    public void getApiResponse() {
        view.setProgressIndicator(true);
        webServiceInteractor.getResponse(this);
    }
}
