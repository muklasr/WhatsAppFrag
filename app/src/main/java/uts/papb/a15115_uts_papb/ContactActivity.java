package uts.papb.a15115_uts_papb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import uts.papb.a15115_uts_papb.Adapter.ContactAdapter;
import uts.papb.a15115_uts_papb.Model.Contact;
import uts.papb.a15115_uts_papb.Data.ContactData;

public class ContactActivity extends AppCompatActivity {
    private RecyclerView rvContact;
    private ArrayList<Contact> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        setTitle("Contact");

        rvContact = findViewById(R.id.rv_contact);

        contactsList.addAll(ContactData.getListData());

        showRecyclerView();
    }

    private void showRecyclerView() {
        rvContact.setLayoutManager(new LinearLayoutManager(this));
        ContactAdapter contactAdapter = new ContactAdapter(contactsList);
        rvContact.setAdapter(contactAdapter);
        contactAdapter.setOnItemClickCallback(new ContactAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Contact data) {
                Intent i = new Intent(ContactActivity.this, DetailActivity.class);
                i.putExtra("text1", "Contact");
                i.putExtra("text2", data.getNama());
                i.putExtra("text3", data.getNomer());
                startActivity(i);
            }
        });
    }
}