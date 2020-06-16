package com.example.uasmobileprogramming.Model.Dosen;

import com.google.gson.annotations.SerializedName;


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
    public Dosen getDosen() {
        return mDosen;
    }
    public void setDosen(Dosen Dosen) {
        mDosen = Dosen;
    }

}