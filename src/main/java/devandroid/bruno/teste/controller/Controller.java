package devandroid.bruno.teste.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.bruno.teste.model.Classe;

public class Controller {

    @NonNull
    @Override
    public String toString() {
        Log.d("Controller-MVC", "Controller iniciada...");
        return super.toString();
    }

    public void salvar(Classe objeto) {
        Log.d("Controller-MVC", "Enviado!"+objeto.toString());
    }
}
