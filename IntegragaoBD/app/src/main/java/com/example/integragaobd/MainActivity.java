package com.example.integragaobd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase romulo;
    EditText editNome, editDataNsc, editEmail;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editDataNsc = findViewById(R.id.editDataNsc);
        button = findViewById(R.id.button);

        romulo = openOrCreateDatabase("meu db", MODE_PRIVATE, null);
        romulo.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY,nome varchar, email varchar, dtnsc date)");

        //Romulo
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = editNome.getText().toString();
                String email = editEmail.getText().toString();
                ContentValues cv = new ContentValues();
                cv.put("nome",nome);
                cv.put("email",email);

                long status = romulo.insert("pessoas", null,cv);
                if (status > 0){
                    Toast.makeText(getApplicationContext(),"Usuario inserido", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(getApplicationContext(),"erro",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
