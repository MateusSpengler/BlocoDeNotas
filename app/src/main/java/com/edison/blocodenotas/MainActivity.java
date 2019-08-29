package com.edison.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences.Editor editor = null;
    private static final String PREFERENCIAS_FILE = "Notas";
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Bloco de Notas");

        final EditText notas = findViewById(R.id.text_notas);

        final TextView resultado = findViewById(R.id.text_resultado);

        Button botao_salvar = (Button) findViewById(R.id.btn_salvar);

        Button botao_recuperar = (Button) findViewById(R.id.btn_recuperar);

        preferences = getSharedPreferences(PREFERENCIAS_FILE, MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("teste","asdasdasd");
        editor.commit();
        preferences.getString("teste","Erro ao Recuperar a String");
        Toast.makeText(MainActivity.this,preferences.getString("teste","Erro ao Recuperar a String"), Toast.LENGTH_LONG).show();

        botao_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("teste", String.valueOf(notas.getText()));
                editor.commit();


            }
        });

        botao_recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resultado.setText(preferences.getString("teste","Erro a0 Recuperar a String"));

            }
        });

    }


}
