package com.kampana.dropkid.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.kampana.dropkid.R;

public class DropKidActivity extends AppCompatActivity {

    private Button dropButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drop_kid_activity_content);
        bindsViews();
        addListenersAndValidators();
    }

    private void addListenersAndValidators() {
        dropButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void bindsViews() {
        dropButton = (Button) findViewById(R.id.dropButton);
    }
}
