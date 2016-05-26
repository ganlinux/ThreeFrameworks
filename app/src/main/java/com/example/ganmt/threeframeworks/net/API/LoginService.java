package com.example.ganmt.threeframeworks.net.API;


import com.example.ganmt.threeframeworks.net.request.ReqLogin;
import com.example.ganmt.threeframeworks.net.response.RspLogin;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author ganmt
 *
 */
public interface LoginService {
    @POST("/mcm/api/user/login")
    Call<RspLogin> login(@Body ReqLogin username);
}
