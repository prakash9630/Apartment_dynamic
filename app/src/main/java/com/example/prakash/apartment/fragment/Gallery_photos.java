package com.example.prakash.apartment.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.prakash.apartment.Pojo.Album_photo;
import com.example.prakash.apartment.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by prakash on 4/3/2017.
 */

public class Gallery_photos extends Fragment {
    View mainView;
    RecyclerView recyclerView;

    ArrayList<Album_photo> data;

    String url="";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView=inflater.inflate(R.layout.gallery_photo_layout,container,false);

             recyclerView=(RecyclerView)mainView.findViewById(R.id.galler_photo_recycler);

        return mainView;
    }

//    void getData()
//    {
//
//        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET,url, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//
//                data=new ArrayList<>();
//
//                try {
//                    JSONObject fieldImage=response.getJSONObject("field_image");
//
//                    String title=response.getString("title");
//
//                    JSONArray imagearrey=fieldImage.getJSONArray("und");
//
//                    for (int ii=0;ii<imagearrey.length();ii++)
//                    {
//                        JSONObject objimage=imagearrey.getJSONObject(ii);
//
//                        String image=objimage.getString("filename");
//
//
////                        datagetter=new Album_data(image);
////                        data.add(datagetter);
//                    }
//
//
//
//
////
////                    adapter=new AlbumRecycler(Gallery_album.this,data);
////                    recyclerView.setAdapter(adapter);
////
////                    recyclerView.setLayoutManager(new GridLayoutManager(Gallery_album.this,2));
////                    toolbar.setTitle(title);
//
//
//
//                } catch (JSONException e) {
//
////                    Toast.makeText(Gallery_album.this, "network problem", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
////                Toast.makeText(Gallery_album.this,"Check your internet connection", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        request.setRetryPolicy(new DefaultRetryPolicy(
//                5000,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//        RequestQueue queue = Volley.newRequestQueue(this);
//        queue.add(request);
//
//    }


    class AlbumRecycler extends RecyclerView.Adapter<AlbumHolder>
    {
        Context context;
        LayoutInflater layoutInflater;
        ArrayList<Album_photo> data;
        Dialog dialog;


        public AlbumRecycler(Context context, ArrayList<Album_photo> data) {
            this.context = context;
            this.data = data;
            layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public AlbumHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=layoutInflater.inflate(R.layout.gallery_photo_layout,parent,false);
            AlbumHolder holder=new AlbumHolder(view,context,data);
            return holder;

        }

        @Override
        public void onBindViewHolder(AlbumHolder holder, final int position) {
            final Album_photo current = data.get(position);

            Picasso.with(context)
                    .load("http://www.retreatservicedapartments.com/sites/default/files/"+current.getImage())
                    .placeholder(R.drawable.defult)   // optional
                    .error(R.drawable.defult)      // optional
                    .resize(600, 340)                        // optional
                    // optional
                    .into(holder.image);




            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    dialog = new Dialog(context);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.fullscreen_image);
                    final ImageView ivZoomedImage = (ImageView) dialog.findViewById(R.id.fullscreen_image);



                    String imgUrl = current.getImage();


                    Picasso.with(context).setIndicatorsEnabled(false);


                    Picasso.with(context)
                            .load("http://www.retreatservicedapartments.com/sites/default/files/"+imgUrl)
                            .into(ivZoomedImage);

                    dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                    dialog.show();






                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
    class AlbumHolder extends RecyclerView.ViewHolder
    {

        ImageView image;

        Context context;
        ArrayList<Album_photo> data;


        public AlbumHolder(View itemView,Context context,ArrayList<Album_photo> data) {
            super(itemView);
            this.context=context;
            this.data=data;

            image=(ImageView)itemView.findViewById(R.id.singe_image);

        }
    }



}
