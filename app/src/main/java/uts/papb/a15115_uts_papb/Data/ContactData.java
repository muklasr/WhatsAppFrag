package uts.papb.a15115_uts_papb.Data;

import java.util.ArrayList;

import uts.papb.a15115_uts_papb.Model.Contact;

public class ContactData {
    public static String[][] data = new String[][]{
            {"Ardia", "081330646518", "https://ruko.technow.id/storage/user/105"},
            {"Ady", "081330646518", "https://ruko.technow.id/storage/user/2"},
            {"Rizky", "081330646518", "https://ruko.technow.id/storage/user/103"},
            {"Bima", "081330646518", "https://ruko.technow.id/storage/user/8"},
            {"Naufal", "081330646518", "https://ruko.technow.id/storage/user/13"},

    };

    public static ArrayList<Contact> getListData() {
        ArrayList<Contact> list = new ArrayList<>();
        for (String[] datane : data) {
            Contact contact = new Contact();
            contact.setNama(datane[0]);
            contact.setNomer(datane[1]);
            contact.setFoto(datane[2]);
            list.add(contact);
        }
        return list;
    }

}
