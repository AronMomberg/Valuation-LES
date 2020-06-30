package com.example.valuation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class tela3 extends AppCompatActivity {

    TextView valorEmpresa;
    Button btRefazer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        //REFERÊNCIAR OS OBJETOS
        valorEmpresa = (TextView)findViewById(R.id.txtValorFinal);
        btRefazer = (Button)findViewById(R.id.btnRefazer);

        //AÇÃO BOTÃO REFAZER
        btRefazer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //PEGAR VALOR DA OUTRA TELA
        Intent dados = getIntent();
        if(dados != null){
            String dadosRecebidos = dados.getStringExtra("resultadoUltimo");
            Log.d("filtro", dadosRecebidos+ " valor");
            valorEmpresa.setText(dadosRecebidos.toString());
            if(dadosRecebidos != null) {
                String resultadoUltimoano = dadosRecebidos;
                valorEmpresa.setText(dadosRecebidos);
            }
        }
    }
}