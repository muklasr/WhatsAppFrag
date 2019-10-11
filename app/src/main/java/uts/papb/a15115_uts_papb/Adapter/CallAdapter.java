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
import uts.papb.a15115_uts_papb.Model.Call;
import uts.papb.a15115_uts_papb.R;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.ListViewHolder> {
    private ArrayList<Call> callList;
    public OnItemClickCallback onClickCallback;

    public CallAdapter(ArrayList<Call> callList) {
        this.callList = callList;
    }

    public void setOnClickCallback(OnItemClickCallback onClickCallback) {
        this.onClickCallback = onClickCallback;
    }

    @NonNull
    @Override
    public CallAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.call_row_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CallAdapter.ListViewHolder holder, int position) {
        Call call = callList.get(position);

        holder.tvNama.setText(call.getNama());
        holder.tvWaktu.setText(call.getWaktu());
        Glide.with(holder.itemView.getContext())
                .load(call.getFoto())
                .apply(new RequestOptions().override(60,60))
                .into(holder.civFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCallback.onItemClicked(callList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return callList.size();
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

    public interface OnItemClickCallback {
        void onItemClicked(Call data);
    }
}
