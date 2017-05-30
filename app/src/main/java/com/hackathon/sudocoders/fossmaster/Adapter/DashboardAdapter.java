package com.hackathon.sudocoders.fossmaster.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.hackathon.sudocoders.fossmaster.Model.DashboardUserDetail;
import com.hackathon.sudocoders.fossmaster.R;

import java.util.ArrayList;

/**
 * Created by jatin on 1/4/17.
 */

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder> {

    private final ArrayList<DashboardUserDetail> users;
    private final Context context;

    public DashboardAdapter(ArrayList<DashboardUserDetail> users, Context context) {
        this.users = users;
        this.context = context;

    }

    @Override
    public DashboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_dashboard, parent, false);
        DashboardViewHolder mrv = new DashboardViewHolder(v);
        return mrv;
    }

    @Override
    public void onBindViewHolder(final DashboardViewHolder holder, int position) {

        DashboardUserDetail user = users.get(position);
        holder.user_name.setText(user.getUser_name());
        Glide.with(context).load(user.getUser_image_url()).into(holder.user_image);
        Glide.with(context).load(user.getUser_image_url()).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.user_image) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.user_image.setImageDrawable(circularBitmapDrawable);
            }
        });
        System.out.println(user.getUser_image_url());

        if (user.getType().equals("CreateEvent")) {

            holder.description2.setVisibility(View.GONE);
            holder.reponame.setText("Created a Repository " + user.getRepo_name());
        }
        if (user.getType().equals("ForkEvent")) {

            holder.reponame.setText("Forked " + user.getRepo_name());

            String[] separated = user.getRepo_name().split("/");
            holder.description2.setText("Forked Repository is at " + user.getUser_name() + "/" + separated[1]);
        }

        if (user.getType().equals("WatchEvent")) {
            holder.reponame.setText("Starred " + user.getRepo_name());
            holder.description2.setVisibility(View.GONE);
        }
        if (user.getType().equals("MemberEvent")) {
            holder.reponame.setText("Added a Contributor to Repo " + user.getRepo_name());
            holder.description2.setVisibility(View.GONE);
        }

        System.out.println(user.getType());


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class DashboardViewHolder extends RecyclerView.ViewHolder {

        TextView user_name;
        //  TextView type;
        TextView reponame;

        TextView description2;
        ImageView user_image;


        public DashboardViewHolder(View itemView) {
            super(itemView);
            user_name = (TextView) itemView.findViewById(R.id.user_name);
            //   type= (TextView) itemView.findViewById(R.id.type);
            reponame = (TextView) itemView.findViewById(R.id.desc);
            description2 = (TextView) itemView.findViewById(R.id.desc2);
            user_image = (ImageView) itemView.findViewById(R.id.imgview);
        }
    }
}