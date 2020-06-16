package com.example.uasmobileprogramming.Rest;

import com.example.uasmobileprogramming.Model.Dosen.GetDosen;
import com.example.uasmobileprogramming.Model.Dosen.PostPutDelDosen;
import com.example.uasmobileprogramming.Model.Mahasiswa.GetMahasiswa;
import com.example.uasmobileprogramming.Model.Mahasiswa.PostPutDelMahasiswa;

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
    @GET("mahasiswa_android")
    Call<GetMahasiswa> getMahasiswa();

    @FormUrlEncoded
    @POST("dosen")
    Call<PostPutDelDosen> postDosen(@Field("namadosen") String nama,
                                      @Field("notelp") String nomor);
    @FormUrlEncoded
    @POST("mahasiswa")
    Call<PostPutDelMahasiswa> postMahasiswa(@Field("nim") String id,@Field("namamahasiswa") String nama,
                                        @Field("notelp") String nomor);

    @FormUrlEncoded
    @PUT("dosen")
    Call<PostPutDelDosen> putDosen(@Field("iddosen") String id,
                                   @Field("namadosen") String nama,
                                   @Field("notelp") String nomor);
    @FormUrlEncoded
    @PUT("mahasiswa")
    Call<PostPutDelDosen> putMahasiswa(@Field("nim") String id,
                                   @Field("namahasiswa") String nama,
                                   @Field("notelp") String nomor);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "dosen", hasBody = true)
    Call<PostPutDelDosen> deleteDosen(@Field("iddosen") String id);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "mahasiswa", hasBody = true)
    Call<PostPutDelDosen> deleteMahasiswa(@Field("nim") String id);


}