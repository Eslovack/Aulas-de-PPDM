package com.example.sortei;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

     EditText editTextNume1;
     EditText editTextNume2 ;
     TextView ResultadoSorteio;
     Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNume1 = findViewById(R.id.editTextNume1);
        editTextNume2 = findViewById(R.id.editTextNume2);
        ResultadoSorteio= findViewById(R.id.ResultadoSorteio);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min = Integer.parseInt(editTextNume1.getText().toString());
                int max = Integer.parseInt(editTextNume2.getText().toString());
                int numeroSorteado = new Random().nextInt((max - min) + 1) + min;
                ResultadoSorteio.setText("Número sorteado: " + numeroSorteado);
                ///
            }
        });
    }

}