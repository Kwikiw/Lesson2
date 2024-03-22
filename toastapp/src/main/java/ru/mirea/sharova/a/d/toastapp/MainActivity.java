package ru.mirea.sharova.a.d.toastapp;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button buttonCount;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {

        editText = findViewById(R.id.editText);
        buttonCount = findViewById(R.id.button);

        String inputText = editText.getText().toString();
        int characterCount = inputText.length();
        String message = "СТУДЕНТ № 26 ГРУППА БСБО-09-21 Количество символов - " + characterCount;
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}