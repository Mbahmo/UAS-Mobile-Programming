package com.example.uasmobileprogramming.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 2/3/17.
 */
public class PostPutDelDosen {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Dosen mDosen;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Dosen getKontak() {
        return mDosen;
    }
    public void setKontak(Dosen Dosen) {
        mDosen = Dosen;
    }

}