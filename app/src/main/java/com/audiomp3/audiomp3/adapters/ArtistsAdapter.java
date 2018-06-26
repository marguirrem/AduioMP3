package com.audiomp3.audiomp3.adapters;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.audiomp3.audiomp3.R;
import com.audiomp3.audiomp3.services.ResponseArtists;

import java.util.ArrayList;

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ViewHolderArtists>
implements View.OnClickListener{
    private View.OnClickListener listener;

    ArrayList<ResponseArtists>artists_list;

    public ArtistsAdapter(ArrayList<ResponseArtists> artists_list) {
        this.artists_list = artists_list;
    }

    @NonNull
    @Override
    public ViewHolderArtists onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.artist_list_item,null,false);
        view.setOnClickListener(this);
        return new ViewHolderArtists(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderArtists holder, int position) {
        //holder.imageView.setImageURI(artists_list.get(position).getPhoto());
        holder.tvNameArtist.setText(artists_list.get(position).getName());
        holder.tvDescriptionArtist.setText(artists_list.get(position).getBio());
    }

    @Override
    public int getItemCount() {
        return artists_list.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolderArtists extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvNameArtist,tvDescriptionArtist;

        public ViewHolderArtists(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivArtist);
            tvNameArtist = itemView.findViewById(R.id.tvNameArtist);
            tvDescriptionArtist = itemView.findViewById(R.id.tvDescriptionArtist);

        }
    }
}
