package com.example.prakash.apartment.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prakash.apartment.Pojo.Album_data;
import com.example.prakash.apartment.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by prakash on 3/30/2017.
 */

public class Gallery extends Fragment {
    View mainView;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
mainView=inflater.inflate(R.layout.gallery_layout,container,false);

recyclerView=(RecyclerView)mainView.findViewById(R.id.album_recycler);



        return mainView;
    }


    class GalleryRecycler extends RecyclerView.Adapter<GalleryHolder> {

        Context context;
        ArrayList<Album_data> data;
        LayoutInflater layoutinflater;

        public GalleryRecycler(Context context, ArrayList<Album_data> data) {
            this.context = context;
            this.data = data;
            layoutinflater = LayoutInflater.from(context);

        }

        @Override
        public GalleryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = layoutinflater.inflate(R.layout.gallery_album_design, parent, false);
            GalleryHolder holder = new GalleryHolder(view, context, data);
            return holder;
        }

        @Override
        public void onBindViewHolder(final GalleryHolder holder, int position) {
            final Album_data current = data.get(position);
            holder.mText.setText(current.getMunitname());

            Picasso.with(context)
                    .load(current.getmImage())
                    .placeholder(R.drawable.defult)   // optional
                    .error(R.drawable.defult)      // optional
                    .resize(600, 340)
                    .into(holder.gImage);



        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    class GalleryHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView gImage;
        TextView mText;

        Context context;
        ArrayList<Album_data> data;

        public GalleryHolder(View itemView, Context context, ArrayList<Album_data> data) {
            super(itemView);
            this.context = context;
            this.data = data;

            itemView.setOnClickListener((View.OnClickListener) this);

            mText = (TextView) itemView.findViewById(R.id.gallery_label);
            gImage = (ImageView) itemView.findViewById(R.id.gallary_image);

        }

        @Override
        public void onClick(View v) {
            int positon=getAdapterPosition();
            Album_data current = data.get(positon);


//            Intent i = new Intent(context, Gallery_album.class);
//            i.putExtra("nid",current.getNid());
//            context.startActivity(i);

        }
    }

}
