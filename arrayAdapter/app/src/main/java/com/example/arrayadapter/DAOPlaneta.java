package com.example.arrayadapter;

import java.util.ArrayList;

public class DAOPlaneta {

        ArrayList<Planeta> planetas;

        public DAOPlaneta() {

                planetas = new ArrayList<>();
                planetas.add(new Planeta("Romulo", R.drawable.mercury));
                planetas.add(new Planeta("Terra", R.drawable.earth));
                planetas.add(new Planeta("Volkswagem", R.drawable.sun));



        }
}
