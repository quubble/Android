package com.example.intentopennextscreen;

import android.text.method.ScrollingMovementMethod;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //Adding back-button to the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra("Value");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);

        /* Adding Scrollbars method to TextView, after importing the Scrollbar class*/
        textView.setMovementMethod(new ScrollingMovementMethod());
        /* Adding Text to TextView*/
        textView.setText(message);
		
    }
}