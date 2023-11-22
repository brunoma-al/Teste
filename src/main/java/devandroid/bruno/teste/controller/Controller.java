package devandroid.bruno.teste.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.bruno.teste.model.Classe;
import devandroid.bruno.teste.view.MainActivity;

public class Controller {

    SharedPreferences preferences;
    SharedPreferences.Editor teste;
    public static final String NOME_PREFERENCES = "Teste";

    public Controller(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        teste = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("Controller-MVC", "Controller iniciada...");
        return super.toString();
    }

    public void enviar(Classe objeto) {
        Log.d("Controller-MVC", "Enviado!" + objeto.toString());

        teste.putString("primeiroNome",objeto.getPrimeiroNome());
        teste.putString("motivoCandidatura",objeto.getMotivoCandidatura());
        teste.apply();
    }

    public Classe buscar(Classe objeto) {

        objeto.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        objeto.setMotivoCandidatura(preferences.getString("motivoCandidatura", "NA"));
        return objeto;
    }

    public void limpar() {
        teste.clear();
        teste.apply();
    }
}
