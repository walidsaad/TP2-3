package com.example.walid.tp2_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddOSActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_os);
        editText = (EditText) findViewById(R.id.item);
    }

    public void addItem(View v) {
        Intent intent = new Intent();
        intent.putExtra("item", editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancel(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }
}