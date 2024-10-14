package com.example.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        DAOPlaneta pdao = new DAOPlaneta();
        PlanetaAdapter pdaop = new PlanetaAdapter(this, R.layout.planeta, pdao.getPlanetas());

        listView.setAdapter(pdaop);
    }
}