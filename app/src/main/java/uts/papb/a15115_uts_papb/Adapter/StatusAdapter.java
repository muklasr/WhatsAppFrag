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
import uts.papb.a15115_uts_papb.Model.Status;
import uts.papb.a15115_uts_papb.R;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ListViewHolder> {
    private ArrayList<Status> statusList;
    private Boolean viewed;
    public OnClickItemCallback onClickItemCallback;

    public StatusAdapter(ArrayList<Status> statusList, Boolean viewed) {
        this.statusList = statusList;
        this.viewed = viewed;
    }

    public void setOnClickItemCallback(OnClickItemCallback onClickItemCallback) {
        this.onClickItemCallback = onClickItemCallback;
    }

    @NonNull
    @Override
    public StatusAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewed) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewed_row_item, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_row_item, parent, false);
        }
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StatusAdapter.ListViewHolder holder, int position) {
        Status status = statusList.get(position);

        holder.tvNama.setText(status.getNama());
        holder.tvWaktu.setText(status.getWaktu());
        Glide.with(holder.itemView.getContext())
                .load(status.getFoto())
                .apply(new RequestOptions().override(54,54))
                .into(holder.civFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemCallback.onItemClicked(statusList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return statusList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNama, tvWaktu;
        private CircleImageView civFoto;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvWaktu = itemView.findViewById(R.id.tv_waktu);
            civFoto = itemView.findViewById(R.id.civ_foto);
        }
    }

    public interface OnClickItemCallback{
        void onItemClicked(Status data);
    }
}
