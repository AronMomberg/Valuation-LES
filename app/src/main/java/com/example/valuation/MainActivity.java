package com.example.valuation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.*;
import android.view.*;
import android.app.*;

import android.os.Bundle;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private Button proximo;
    EditText resultadoUltimoano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        proximo = (Button) findViewById(R.id.btnProximo);
        resultadoUltimoano = (EditText)findViewById(R.id.edtResultadoUltimoAno);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*double resultadoUltimo = Double.parseDouble(resultadoUltimoano.getText().toString());
                Intent intentEnviadora = new Intent(getApplicationContext(), tela1.class);
                Bundle parametros = new Bundle();
                parametros.putDouble("chave_resultado", resultadoUltimo);
                intentEnviadora.putExtras(parametros);
                startActivity(intentEnviadora);*/

                Intent intent = new Intent(getApplicationContext(), tela1.class);
                startActivity(intent);
            }
        });
        resultadoUltimoano.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) resultadoUltimoano.setText("");
                return false;
            }
        });
    }

    public  void irParaTela1(View view){
        Intent intencao = new Intent(this,tela1.class);
        double resultadoUltimo = Double.parseDouble(resultadoUltimoano.getText().toString());
        Bundle parametros = new Bundle();
        parametros.putDouble("chave_resultado", resultadoUltimo);
        intencao.putExtras(parametros);
        startActivity(intencao);
    }
}