package uts.papb.a15115_uts_papb.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import uts.papb.a15115_uts_papb.Model.Chat;
import uts.papb.a15115_uts_papb.R;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ListViewHolder> {
    private ArrayList<Chat> chatList;
    public OnItemClickCallback onItemClickCallback;

    public ChatAdapter(ArrayList<Chat> chatList) {
        this.chatList = chatList;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ChatAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_row_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ChatAdapter.ListViewHolder holder, int position) {
        Chat chat = chatList.get(position);

        holder.tvNama.setText(chat.getNama());
        holder.tvChat.setText(chat.getIsi());
        holder.tvWaktu.setText(chat.getWaktu());
        Glide.with(holder.itemView.getContext())
                .load(chat.getFoto())
                .apply(new RequestOptions().override(60,60))
                .into(holder.civFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(chatList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNama, tvChat, tvWaktu;
        private CircleImageView civFoto;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvChat = itemView.findViewById(R.id.tv_isi_chat);
            tvWaktu = itemView.findViewById(R.id.tv_waktu);
            civFoto = itemView.findViewById(R.id.civ_foto);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Chat data);
    }
}
