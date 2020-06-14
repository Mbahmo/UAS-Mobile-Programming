package com.example.uasmobileprogramming.Rest;
/**
 * Created by root on 2/3/17.
 */

import com.example.uasmobileprogramming.Model.Dosen;
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
    @GET("kontak_android")
    Call<GetDosen> getKontak();
    @FormUrlEncoded
    @POST("kontak")
    Call<PostPutDelDosen> postKontak(@Field("nama") String nama,
                                      @Field("nomor") String nomor);
    @FormUrlEncoded
    @PUT("kontak")
    Call<PostPutDelDosen> putKontak(@Field("id") String id,
                                     @Field("nama") String nama,
                                     @Field("nomor") String nomor);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
    Call<PostPutDelDosen> deleteKontak(@Field("id") String id);
}