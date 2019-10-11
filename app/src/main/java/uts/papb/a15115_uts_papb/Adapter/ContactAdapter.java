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
import uts.papb.a15115_uts_papb.Model.Contact;
import uts.papb.a15115_uts_papb.R;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ListViewHolder> {
    private ArrayList<Contact> listContact;
    public OnItemClickCallback onItemClickCallback;

    public ContactAdapter(ArrayList<Contact> listContact) {
        this.listContact = listContact;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_row_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Contact contact = listContact.get(position);
        holder.tvNama.setText(contact.getNama());
        holder.tvNomer.setText(contact.getNomer());
        Glide.with(holder.itemView.getContext())
                .load(contact.getFoto())
                .apply(new RequestOptions().override(60,60))
                .into(holder.civFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listContact.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listContact.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvNomer;
        CircleImageView civFoto;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvNomer = itemView.findViewById(R.id.tv_isi_chat);
            civFoto = itemView.findViewById(R.id.civ_foto);
        }
    }
    public interface OnItemClickCallback{
        void onItemClicked(Contact data);
    }

}
