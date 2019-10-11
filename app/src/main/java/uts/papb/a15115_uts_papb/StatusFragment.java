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

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import uts.papb.a15115_uts_papb.Adapter.StatusAdapter;
import uts.papb.a15115_uts_papb.Data.StatusData;
import uts.papb.a15115_uts_papb.Model.Status;

public class StatusFragment extends Fragment {
    private RecyclerView rvViewed, rvRecent;
    private ArrayList<Status> recentList = new ArrayList<>();
    private ArrayList<Status> viewedList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_status, container, false);
        rvViewed = view.findViewById(R.id.rv_viewed);
        rvRecent = view.findViewById(R.id.rv_recent);
        CircleImageView civFoto = view.findViewById(R.id.civ_fotoProp);
        Glide.with(container.getContext()).load("https://ruko.technow.id/storage/user/2").into(civFoto);

        viewedList.addAll(StatusData.getListViewed());
        recentList.addAll(StatusData.getListRecent());

        showRecyclerView();

        return view;
    }

    private void showRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvViewed.setLayoutManager(layoutManager);
        StatusAdapter statusAdapter = new StatusAdapter(viewedList, true);
        rvViewed.setAdapter(statusAdapter);
        statusAdapter.setOnClickItemCallback(new StatusAdapter.OnClickItemCallback() {
            @Override
            public void onItemClicked(Status data) {
                Intent i = new Intent(getContext(), DetailActivity.class);
                i.putExtra("text1", "Status");
                i.putExtra("text2", data.getNama());
                i.putExtra("text3", data.getWaktu());
                startActivity(i);
            }
        });

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getContext());
        rvRecent.setLayoutManager(layoutManager2);
        StatusAdapter statusAdapter2 = new StatusAdapter(recentList, false);
        rvRecent.setAdapter(statusAdapter2);
        statusAdapter2.setOnClickItemCallback(new StatusAdapter.OnClickItemCallback() {
            @Override
            public void onItemClicked(Status data) {
                Intent i = new Intent(getContext(), DetailActivity.class);
                i.putExtra("text1", "Status");
                i.putExtra("text2", data.getNama());
                i.putExtra("text3", data.getWaktu());
                startActivity(i);
            }
        });


    }
}
