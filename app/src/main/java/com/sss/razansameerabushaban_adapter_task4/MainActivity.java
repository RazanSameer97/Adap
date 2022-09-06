package com.sss.razansameerabushaban_adapter_task4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final int REQ_CODE_ADD=1;
    PostAdapter adapter;
    ListView lv;
    Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.test_list);
        btn_add = findViewById(R.id.list_btn_add);

        ArrayList<Post> posts = new ArrayList<>();
        PostAdapter adapter = new PostAdapter(this, R.layout.custom_post_layout,posts);
        lv.setAdapter(adapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddPostActivity.class);
                startActivityForResult(intent, REQ_CODE_ADD);
            }

        });

}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE_ADD && resultCode == RESULT_OK){
            Post post = (Post) data.getSerializableExtra(AddPostActivity.POST_CONS_NAME);
            adapter.AddItem(post);
            adapter.notifyDataSetChanged();

        }
    }
}

