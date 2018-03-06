package com.assignment.travel.repository;


import com.assignment.travel.model.ApiResponse;

public interface TravelWebserviceListener {
     void onSuccess(ApiResponse response);
    void onFailure();

}
