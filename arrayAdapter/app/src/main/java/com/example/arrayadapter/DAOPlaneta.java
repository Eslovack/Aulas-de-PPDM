package com.example.arrayadapter;

import java.util.ArrayList;

public class DAOPlaneta {

        ArrayList<Planeta> planetas;

        public DAOPlaneta() {

                planetas = new ArrayList<>();
                planetas.add(new Planeta("Romulo", R.drawable.mercury));
                planetas.add(new Planeta("Terra", R.drawable.earth));
                planetas.add(new Planeta("Bolsonaro", R.drawable.bolonasu));
                planetas.add(new Planeta("Shika", R.drawable.shika));
                planetas.add(new Planeta("Cadeirante?", R.drawable.cadeirante));


        }
        public ArrayList<Planeta>getPlanetas(){return planetas;}
}
