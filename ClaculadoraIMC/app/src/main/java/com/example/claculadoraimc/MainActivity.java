package com.example.claculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Declarando variaveis para usar no metodo//
    EditText editTextAltura;
    EditText editTextPeso;
    TextView TextViewResultado;
    Button button;
    //ImageView ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //"linkando ações"
        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        TextViewResultado = findViewById(R.id.TextViewResultado);
        //ImageView = findViewById(R.id.imageView);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //passando os dados para Float
                Float peso = Float.parseFloat(editTextPeso.getText().toString());
                Float altura = Float.parseFloat(editTextAltura.getText().toString());

                //calculando resultado (imc = peso/(altura+altura))
                Float imc = peso / (altura * altura);
                //TextViewResultado.setText(String.valueOf(imc));

                //irParaSegundaTela()

                //if (imc < 18.5){
                //ImageView.setImageResource(R.drawable.abaixopeso);
                //}
                Intent intent = new Intent(getApplicationContext(),TelaDois.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}