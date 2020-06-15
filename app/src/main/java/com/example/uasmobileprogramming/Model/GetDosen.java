package com.example.uasmobileprogramming.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by root on 2/3/17.
 */

public class GetDosen {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Dosen> listDataDosen;
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
    public List<Dosen> getListDataDosen() {
        return listDataDosen;
    }
    public void setListDataDosen(List<Dosen> listDataDosen) {
        this.listDataDosen = listDataDosen;
    }
}