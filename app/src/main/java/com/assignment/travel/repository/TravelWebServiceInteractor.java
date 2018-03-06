package com.assignment.travel.repository;

import android.content.Context;

import com.assignment.travel.TravelAssigmentApplication;
import com.assignment.travel.api.TravelApiService;
import com.assignment.travel.model.ApiResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TravelWebServiceInteractor {


    @Inject
    TravelApiService apiService;
    public TravelWebServiceInteractor(Context context){
        ((TravelAssigmentApplication)context).getAppComponent().inject(this);
    }


    public void getResponse(final TravelWebserviceListener listener){
        Call<ApiResponse> call = apiService.getResponse();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                listener.onSuccess(response.body());

            }
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                listener.onFailure();
            }

        });

    }






}
