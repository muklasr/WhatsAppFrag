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

import uts.papb.a15115_uts_papb.Adapter.ChatAdapter;
import uts.papb.a15115_uts_papb.Model.Chat;

public class ChatFragment extends Fragment {
    private RecyclerView rvChat;
    private ArrayList<Chat> chatList;
    private View view;
    private ChatAdapter chatAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.view = inflater.inflate(R.layout.fragment_chat, container, false);
        this.rvChat = view.findViewById(R.id.rv_chat);
        this.chatList = new ArrayList<>();
        this.chatList.add(new Chat("Ardia", "Hallo apa kabar", "Today, 15:20", "https://ruko.technow.id/storage/user/105"));
        this.chatList.add(new Chat("Ady", "Hallo apa kabar", "Today, 11:20", "https://ruko.technow.id/storage/user/2"));
        this.chatList.add(new Chat("Rizky", "Hallo apa kabar", "Today, 10:20", "https://ruko.technow.id/storage/user/103"));
        this.chatList.add(new Chat("Bima", "Hallo apa kabar", "Yesterday, 21:20", "https://ruko.technow.id/storage/user/8"));
        this.chatList.add(new Chat("Naufal", "Hallo apa kabar", "Yesterday, 10:20", "https://ruko.technow.id/storage/user/13"));
        this.chatList.add(new Chat("Rudi", "Hallo apa kabar", "Yesterday, 05:20", "https://ruko.technow.id/storage/user/105"));
        this.chatList.add(new Chat("Nadia", "Hallo apa kabar", "Yesterday, 01:20", "https://ruko.technow.id/storage/user/2"));
        this.chatList.add(new Chat("Mulyono", "Hallo apa kabar", "25 September, 20:20", "https://ruko.technow.id/storage/user/103"));
        this.chatList.add(new Chat("Triyogo", "Hallo apa kabar", "24 September, 01:20", "https://ruko.technow.id/storage/user/8"));
        this.chatList.add(new Chat("Kusumo", "Hallo apa kabar", "25 September, 00:20", "https://ruko.technow.id/storage/user/13"));
        this.rvChat.setLayoutManager(new LinearLayoutManager(getContext()));
        this.chatAdapter = new ChatAdapter(this.chatList);
        this.rvChat.setAdapter(this.chatAdapter);
        this.chatAdapter.setOnItemClickCallback(new ChatAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Chat data) {
                Intent i = new Intent(getContext(), DetailActivity.class);
                i.putExtra("text1", "Chat");
                i.putExtra("text2", data.getNama());
                i.putExtra("text3", data.getIsi());
                startActivity(i);
            }
        });
        return this.view;
    }
}