package com.sss.razansameerabushaban_adapter_task4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;

import java.util.ArrayList;

public class AddPostActivity extends AppCompatActivity {
    static final String POST_CONS_NAME = "post";
    EditText et_name, et_body, et_date, et_followers, et_following, et_posts;
    Button btn_add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        et_name = findViewById(R.id.add_post_name);
        et_body = findViewById(R.id.add_post_body);
        et_date = findViewById(R.id.add_post_date);
        et_followers = findViewById(R.id.add_post_followers);
        et_following = findViewById(R.id.add_post_following);
        et_posts = findViewById(R.id.add_post_posts);
        btn_add = findViewById(R.id.btn_post_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                String body = et_body.getText().toString();
                String date = et_date.getText().toString();
                int followers= Integer.parseInt( et_followers.getText().toString());
                int following= Integer.parseInt( et_following.getText().toString());
                int posts = Integer.parseInt( et_posts.getText().toString());

                Post post = new Post(name, body, date, followers , following , posts);

                Intent intent = new Intent();
                intent.putExtra(POST_CONS_NAME, post);

                setResult(RESULT_OK,intent);
                finish();

            }
        });



    }

}