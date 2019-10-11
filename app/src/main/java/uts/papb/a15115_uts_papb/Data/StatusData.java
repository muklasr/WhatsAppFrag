package uts.papb.a15115_uts_papb.Data;

import java.util.ArrayList;

import uts.papb.a15115_uts_papb.Model.Status;

public class StatusData {
    public static String[][] data = new String[][]{
            {"Ardia", "05:20", "https://ruko.technow.id/storage/user/105", "false"},
            {"Ady", "11:20", "https://ruko.technow.id/storage/user/2", "false"},
            {"Rizky", "20:20", "https://ruko.technow.id/storage/user/103", "false"},
            {"Bima", "01:20", "https://ruko.technow.id/storage/user/8", "false"},
            {"Naufal", "00:20", "https://ruko.technow.id/storage/user/13", "false"},
            {"Ardia", "05:20", "https://ruko.technow.id/storage/user/105", "false"},
            {"Ady", "11:20", "https://ruko.technow.id/storage/user/2", "false"},
            {"Ardia", "05:20", "https://ruko.technow.id/storage/user/105", "true"},
            {"Ady", "11:20", "https://ruko.technow.id/storage/user/2", "true"},
            {"Rizky", "20:20", "https://ruko.technow.id/storage/user/103", "true"},
            {"Bima", "01:20", "https://ruko.technow.id/storage/user/8", "true"},
            {"Naufal", "00:20", "https://ruko.technow.id/storage/user/13", "true"},
            {"Ardia", "05:20", "https://ruko.technow.id/storage/user/105", "true"},
            {"Ady", "11:20", "https://ruko.technow.id/storage/user/2", "true"},
            {"Rizky", "20:20", "https://ruko.technow.id/storage/user/103", "true"},
            {"Bima", "01:20", "https://ruko.technow.id/storage/user/8", "true"},
            {"Naufal", "00:20", "https://ruko.technow.id/storage/user/13", "true"},

    };

    public static ArrayList<Status> getListRecent() {
        ArrayList<Status> list = new ArrayList<>();
        for (String[] datane : data) {
            if(datane[3]=="false") {
                Status status = new Status();
                status.setNama(datane[0]);
                status.setWaktu(datane[1]);
                status.setFoto(datane[2]);
                status.setViewed(datane[3]);
                list.add(status);
            }
        }
        return list;
    }

    public static ArrayList<Status> getListViewed() {
        ArrayList<Status> list = new ArrayList<>();
        for (String[] datane : data) {
            if(datane[3]=="true") {
                Status status = new Status();
                status.setNama(datane[0]);
                status.setWaktu(datane[1]);
                status.setFoto(datane[2]);
                status.setViewed(datane[3]);
                list.add(status);
            }
        }
        return list;
    }
}
