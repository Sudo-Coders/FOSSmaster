package com.hackathon.sudocoders.fossmaster.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.provider.CalendarContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackathon.sudocoders.fossmaster.InsideRepoActivity;
import com.hackathon.sudocoders.fossmaster.Model.MyRepo;
import com.hackathon.sudocoders.fossmaster.R;
import com.hackathon.sudocoders.fossmaster.Model.MyRepo;
import com.hackathon.sudocoders.fossmaster.Utils.SharedPref;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by jatin on 31/3/17.
 */

public class MyreposAdapter extends RecyclerView.Adapter<MyreposAdapter.MyRepoViewHolder> {


    private final ArrayList<MyRepo> users;
    private final Context context;


    public MyreposAdapter(ArrayList<MyRepo> users, Context context) {
        this.users = users;
        this.context = context;

    }


    @Override
    public MyRepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_repos, parent, false);
        MyRepoViewHolder mrv = new MyRepoViewHolder(v, users, context);
        return mrv;
    }

    @Override
    public void onBindViewHolder(MyRepoViewHolder holder, int position) {
        final SharedPref sharedPref = new SharedPref(context);
        final MyRepo user = users.get(position);
        holder.no_stars.setText(user.getStars());
        holder.fork_total.setText(user.getNo_forks());
        holder.desc.setText(user.getDesc());
        if (user.getDesc() == null) {
            holder.desc.setText("<No Description>");
        }
        holder.name.setText(user.getName());
        holder.language.setText(user.getLanguage());

        holder.repo_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPref.setRepoName(user.getName());

                Intent i = new Intent(context, InsideRepoActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);     //To make activity a part of new task on history stack.
                context.startActivity(i);

            }
        });

        String lang_name = user.getLanguage();
        Resources resources = context.getResources();
        Drawable d;
        if (user.getLanguage() == null) {
            holder.language_icon.setVisibility(View.GONE);
            holder.language.setVisibility(View.GONE);
        } else {
            switch (lang_name) {
                case "C":
                    d = resources.getDrawable(R.drawable.shape_oval_c);
                    break;
                case "Ruby":
                    d = resources.getDrawable(R.drawable.shape_oval_ruby);
                    break;
                case "JavaScript":
                    d = resources.getDrawable(R.drawable.shape_oval_javascript);
                    break;
                case "Swift":
                    d = resources.getDrawable(R.drawable.shape_oval_swift);
                    break;
                case "C#":
                    d = resources.getDrawable(R.drawable.shape_oval_objective_c);
                    break;
                case "C++":
                    d = resources.getDrawable(R.drawable.shape_oval_c_plus);
                    break;
                case "Python":
                    d = resources.getDrawable(R.drawable.shape_oval_python);
                    break;
                case "C1":
                    d = resources.getDrawable(R.drawable.shape_oval_c_sharp);
                    break;
                case "HTML":
                    d = resources.getDrawable(R.drawable.shape_oval_html);
                    break;
                case "Java":
                    d = resources.getDrawable(R.drawable.shape_oval_java);
                    break;
                case "Kotlin":
                    d = resources.getDrawable(R.drawable.shape_oval_kotlin);
                    break;
                case "Go":
                    d = resources.getDrawable(R.drawable.shape_oval_go);
                    break;
                case "Lua":
                    d = resources.getDrawable(R.drawable.shape_oval_lua);
                    break;
                case "Matlab":
                    d = resources.getDrawable(R.drawable.shape_oval_matlab);
                    break;
                case "Pascal":
                    d = resources.getDrawable(R.drawable.shape_oval_pascal);
                    break;
                case "Perl":
                    d = resources.getDrawable(R.drawable.shape_oval_perl);
                    break;
                case "PHP":
                    d = resources.getDrawable(R.drawable.shape_oval_php);
                    break;
                case "R":
                    d = resources.getDrawable(R.drawable.shape_oval_r);
                    break;
                case "Scala":
                    d = resources.getDrawable(R.drawable.shape_oval_scala);
                    break;
                case "ASP":
                    d = resources.getDrawable(R.drawable.shape_oval_asp);
                    break;
                case "CSS":
                    d = resources.getDrawable(R.drawable.shape_oval_css);
                    break;

                default:
                    d = resources.getDrawable(R.drawable.shape_oval_default);

            }
            holder.language_icon.setBackground(d);
        }


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyRepoViewHolder extends RecyclerView.ViewHolder {
        CardView repo_card;
        TextView no_stars;
        ImageView star;
        TextView fork_total;
        TextView desc;
        TextView name;
        TextView language;
        ImageView language_icon;

        public MyRepoViewHolder(View itemView, ArrayList<MyRepo> users, Context context) {
            super(itemView);
            repo_card = (CardView) itemView.findViewById(R.id.repo_card);
            no_stars = (TextView) itemView.findViewById(R.id.stars_total);
            star = (ImageView) itemView.findViewById(R.id.star);
            fork_total = (TextView) itemView.findViewById(R.id.forks_total);
            desc = (TextView) itemView.findViewById(R.id.subtitle);
            name = (TextView) itemView.findViewById(R.id.title);
            language = (TextView) itemView.findViewById(R.id.language);
            language_icon = (ImageView) itemView.findViewById(R.id.language_icon);
        }
    }
}