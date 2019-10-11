package uts.papb.a15115_uts_papb;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uts.papb.a15115_uts_papb.Adapter.CallAdapter;
import uts.papb.a15115_uts_papb.Model.Call;

public class CallsFragment extends Fragment {
    private RecyclerView rvCall;
    private ArrayList<Call> callList;
    private View view;
    private CallAdapter callAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.view = inflater.inflate(R.layout.fragment_calls, container, false);
        this.rvCall = view.findViewById(R.id.rv_call);
        this.callList = new ArrayList<>();
        this.callList.add(new Call("Ardia","Today, 15:20", "https://ruko.technow.id/storage/user/105"));
        this.callList.add(new Call("Ady","Today, 11:20", "https://ruko.technow.id/storage/user/2"));
        this.callList.add(new Call("Rizky","Today, 10:20", "https://ruko.technow.id/storage/user/103"));
        this.callList.add(new Call("Bima","Yesterday, 21:20", "https://ruko.technow.id/storage/user/8"));
        this.callList.add(new Call("Naufal","Yesterday, 10:20", "https://ruko.technow.id/storage/user/13"));
        this.callList.add(new Call("Ardia","Yesterday, 05:20", "https://ruko.technow.id/storage/user/105"));
        this.callList.add(new Call("Ady","Yesterday, 01:20", "https://ruko.technow.id/storage/user/2"));
        this.callList.add(new Call("Rizky","25 September, 20:20", "https://ruko.technow.id/storage/user/103"));
        this.callList.add(new Call("Bima","24 September, 01:20", "https://ruko.technow.id/storage/user/8"));
        this.callList.add(new Call("Naufal","25 September, 00:20", "https://ruko.technow.id/storage/user/13"));
        this.rvCall.setLayoutManager( new LinearLayoutManager(getContext()));
        this.callAdapter = new CallAdapter(this.callList);
        this.rvCall.setAdapter(this.callAdapter);
        this.callAdapter.setOnClickCallback(new CallAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Call data) {
                Intent i = new Intent(getContext(), DetailActivity.class);
                i.putExtra("text1", "Call");
                i.putExtra("text2", data.getNama());
                i.putExtra("text3", data.getWaktu());
                startActivity(i);
            }
        });
        return this.view;
    }
}