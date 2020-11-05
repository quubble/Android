package com.example.intentopennextscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText editText1;
    public Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* finding the user-input provided in the editText as an object  */
        editText1 = (EditText) findViewById(R.id.editText1);
        editText1.addTextChangedListener(textWatcher);

        /*Finding Button Element*/
        submit = (Button) findViewById(R.id.button1);
        // Set enable or disable button depending on text in edit text on launch.
        // Text watcher will work once we start setting/typing in the EditText.
        enableDisableTheButton();

    }

    private void enableDisableTheButton() {
        String message = editText1.getText().toString().trim();
        submit.setEnabled(!message.isEmpty());
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            enableDisableTheButton();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    /* Called when the user taps the Send button */
    public void sendMessage(View view) {
        /* Creating instance of Intent object */
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        /* converting the user-input of editText as String  */
        String message = editText1.getText().toString().trim();
        /* sending the message to other activity as Key-Value Pair */
        intent.putExtra("Value", message);

        /* starting the intent */
        startActivity(intent);
    }
}
