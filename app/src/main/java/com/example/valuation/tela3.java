package com.example.valuation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tela3 extends AppCompatActivity {

    TextView valorEmpresa;
    private Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        //REFERÊNCIAR OS OBJETOS
        valorEmpresa = (TextView)findViewById(R.id.txtValorFinal);
        btVoltar = (Button) findViewById(R.id.btnVoltar);

        //AÇÃO BOTÃO VOLTAR
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), tela1.class);
                startActivity(intent);
            }
        });

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