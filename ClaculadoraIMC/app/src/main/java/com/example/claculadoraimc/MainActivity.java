package com.example.claculadoraimc;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editTextNome;
    EditText editTextPeso ;
    EditText editTextAltura;
    TextView lbl;

    float imc;
    float peso;
    float altura;
    String nome;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                editTextPeso = findViewById(R.id.editTextPeso);
                editTextAltura = findViewById(R.id.editTextAltura);

                peso = Float.parseFloat(String.valueOf(editTextPeso.getText()));
                altura = Float.parseFloat(String.valueOf(editTextAltura.getText()));
                imc = (peso)/(altura*altura);

                Intent i = new Intent(getApplicationContext(),TelaDois.class);
                i.putExtra("peso",peso);
                i.putExtra("altura",altura);
                i.putExtra("imc",imc);
                startActivity(i);

            }
        });
    }
}