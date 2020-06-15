package com.example.uasmobileprogramming.Rest;
/**
 * Created by root on 2/3/17.
 */

import com.example.uasmobileprogramming.Model.GetDosen;
import com.example.uasmobileprogramming.Model.PostPutDelDosen;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("dosen_android")
    Call<GetDosen> getDosen();
    @FormUrlEncoded
    @POST("dosen")
    Call<PostPutDelDosen> postDosen(@Field("nama") String nama,
                                      @Field("nomor") String nomor);
    @FormUrlEncoded
    @PUT("dosen")
    Call<PostPutDelDosen> putDosen(@Field("id") String id,
                                     @Field("nama") String nama,
                                     @Field("nomor") String nomor);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "dosen", hasBody = true)
    Call<PostPutDelDosen> deleteDosen(@Field("IdDosen") String id);
}