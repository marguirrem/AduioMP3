package com.audiomp3.audiomp3.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.audiomp3.audiomp3.R;
import com.audiomp3.audiomp3.activities.HomeActivity;
import com.audiomp3.audiomp3.adapters.ArtistsAdapter;
import com.audiomp3.audiomp3.interfaces.Artists;
import com.audiomp3.audiomp3.services.ResponseArtists;
import com.audiomp3.audiomp3.services.ResponseLogin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArtistsFragment extends Fragment {
    static PeticionArtists peticionArtists;
    ArrayList<ResponseArtists> artists_list;
    RecyclerView recyclerView;
    View rootView;

    public ArtistsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        llamarAlServicio();
        rootView = inflater.inflate(R.layout.fragment_artists, container, false);
        artists_list = new ArrayList<ResponseArtists>();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewArtists);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArtistsAdapter adapter = new ArtistsAdapter(artists_list);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private void llamarAlServicio() {
        peticionArtists = new PeticionArtists();
        peticionArtists.execute();
    }

    public class PeticionArtists extends AsyncTask<Void, Void, Void> {


        public PeticionArtists() {

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ArtistsAdapter adapter2 = new ArtistsAdapter(artists_list);
            adapter2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Name: " +
                            artists_list.get(recyclerView.getChildAdapterPosition(v))
                                    .getName() + "BIO:  " + artists_list.get(recyclerView.getChildAdapterPosition(v))
                            .getBio(), Toast.LENGTH_SHORT).show();
                }
            });
            recyclerView.setAdapter(adapter2);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            final String url = "http://192.168.0.18:8000";
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Artists service = retrofit.create(Artists.class);
            Call<List<ResponseArtists>> call = service.getArtists();
            try {
                List<ResponseArtists> respuesta = call.execute().body();

                if(!respuesta.isEmpty()){
                    for(int i =0;i< respuesta.size();i++){
                        artists_list.add(respuesta.get(i));
                    }
                }else{
                    Toast.makeText(getActivity(), "ERROR: Intenta más tarde", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
