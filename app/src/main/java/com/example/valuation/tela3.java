package com.example.valuation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tela3 extends AppCompatActivity {

    private Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        btVoltar = (Button) findViewById(R.id.btnVoltar);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), tela1.class);
                startActivity(intent);
            }
        });
    }
    public void pegarResultado(View fragmentView){
        Bundle parametros = getIntent().getExtras();
        double resultado = parametros.getDouble("chave_final");
    }
}