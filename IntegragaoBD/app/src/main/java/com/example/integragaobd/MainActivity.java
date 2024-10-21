package com.example.integragaobd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase romulo;
    EditText editNome, editDataNsc, editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        editEmail= findViewById(R.id.editEmail);
        editDataNsc = findViewById(R.id.editDataNsc);

        romulo = openOrCreateDatabase("meu db",MODE_PRIVATE, null);
        romulo.execSQL("CREATE TABLE pessoas (id int primary key autoincrement,nome varchar, email varchar, dtnsc date)");



    }
}