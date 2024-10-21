package com.example.integragaobd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase romulo;
    EditText editNome, editDataNsc, editEmail;
    Button button;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editDataNsc = findViewById(R.id.editDataNsc);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);



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
        carregarlist();
    }
    public void carregarlist() {
        Cursor cursor = romulo.rawQuery("SELECT * FROM pessoas", null);
        cursor.moveToFirst();
        ArrayList<String> nomes = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            nomes.add(cursor.getString(1));
            cursor.moveToNext();
        }
        ArrayAdapter<String> adap = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, nomes);
        listView.setAdapter(adap);

    }
}
