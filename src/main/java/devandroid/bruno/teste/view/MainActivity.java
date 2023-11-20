package devandroid.bruno.teste.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.bruno.teste.R;
import devandroid.bruno.teste.model.Classe;
import devandroid.bruno.teste.controller.Controller;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "Teste";
    Controller controller;
    Classe objeto;
    EditText editNome;
    EditText editCandidatura;

    Button btnLimpar;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor teste = preferences.edit();

        objeto = new Classe();
        objeto.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        objeto.setMotivoCandidatura(preferences.getString("motivoCandidatura", ""));

        /*objeto.setPrimeiroNome("");
        objeto.setMotivoCandidatura("");*/

        editNome = findViewById(R.id.editNome);
        editCandidatura = findViewById(R.id.editCandidatura);

        editNome.setText(objeto.getPrimeiroNome());
        editCandidatura.setText(objeto.getMotivoCandidatura());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnEnviar = findViewById(R.id.btnEnviar);

        /*editNome.setText(objeto.getPrimeiroNome());
        editCandidatura.setText(objeto.getMotivoCandidatura());*/

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNome.setText("");
                editCandidatura.setText("");
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objeto.setPrimeiroNome(editNome.getText().toString());
                objeto.setMotivoCandidatura(editCandidatura.getText().toString());

                Toast.makeText(MainActivity.this, "Enviado!"+objeto.toString(), Toast.LENGTH_SHORT).show();

                teste.putString("primeiroNome",objeto.getPrimeiroNome());
                teste.putString("motivoCandidatura",objeto.getMotivoCandidatura());
                teste.apply();

                controller.enviar(objeto);
            }
        });

        Log.i("POOAndroid", "Teste"+objeto.toString());
    }
}