package com.sss.razansameerabushaban_adapter_task4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PostAdapter extends BaseAdapter {

    private final Context c;
    private final int resource;
    private final ArrayList<Post> posts;
    public android.view.View View;

    public PostAdapter (Context c , int resource , ArrayList<Post> posts){
        this.c=c;
        this.resource=resource;
        this.posts=posts;
    }
    public void AddItem(Post post){
        this.posts.add(post);
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Post getItem(int i)
    {
        return posts.get(i);
    }

    @Override
    public long getItemId(int i) {

        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v = View;
        if (v == null) {
            v = LayoutInflater.from(c).inflate(resource, null, false);
        }
        TextView tv_data = v.findViewById(R.id.custom_post_tv_date);
        TextView tv_name = v.findViewById(R.id.custom_post_tv_name);
        TextView tv_following= v.findViewById(R.id.custom_post_tv_following_data);
        TextView tv_followers= v.findViewById(R.id.custom_post_tv_followers_data);
        TextView tv_posts= v.findViewById(R.id.custom_post_tv_posts_data);
        TextView tv_body= v.findViewById(R.id.custom_post_tv_body);

        Post p = getItem(i);
        tv_data.setText(p.getData());
        tv_name.setText(p.getName());
        tv_body.setText(p.getBody());
        tv_followers.setText(p.getFollowers()+"");
        tv_following.setText(p.getFollowing()+"");
        tv_posts.setText(p.getPosts()+"");

        return v;
    }
}

