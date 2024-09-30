package com.example.claculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaDois extends AppCompatActivity {


    TextView textAlturaR;
    TextView textPesoR;
    TextView tvRecebe;
    ImageView Image;
    Button button2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_dois);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textAlturaR = findViewById(R.id.textAlturaR);
        textPesoR = findViewById(R.id.textPesoR);
        tvRecebe = findViewById(R.id.tvRecebe);
        Image = findViewById(R.id.Image);

        Intent i = getIntent();
        Bundle b = i.getExtras();


        Float peso = b.getFloat("peso");
        Float altura = b.getFloat("altura");
        Float imc = b.getFloat("imc");


        textAlturaR.setText(String.valueOf(altura));
        textPesoR.setText(String.valueOf(peso));
        tvRecebe.setText(String.valueOf(imc));

        if (imc < 18.5) {
            tvRecebe.setText(imc.toString());
            Image.setImageResource(R.drawable.abaixopeso);

        } else if (imc >= 18.5 && imc <= 24.9){
            tvRecebe.setText(imc.toString());
            Image.setImageResource(R.drawable.normal);

        } else if (imc >= 25 && imc <= 29.9 ){
            tvRecebe.setText(imc.toString());
            Image.setImageResource(R.drawable.sobrepeso);
        } else if (imc > 29.9 && imc <= 34.9 ){
            tvRecebe.setText(imc.toString());
            Image.setImageResource(R.drawable.obesidade1);

        } else if (imc > 34.9 && imc <= 39){
            tvRecebe.setText(imc.toString());
            Image.setImageResource(R.drawable.obesidade2);
        } else if (imc > 39){
            tvRecebe.setText(imc.toString());
            Image.setImageResource(R.drawable.obesidade3);
        }

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(o);
            }
        });

    }
}