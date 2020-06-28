package com.example.valuation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.*;
import android.view.*;
import android.app.*;

import android.os.Bundle;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton;
    private Button proximo;
    EditText resultadoUltimoano;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //REFERENCIANDO OBJETOS
        imageButton = (ImageButton) findViewById(R.id.imgBtnAjuda);
        proximo = (Button) findViewById(R.id.btnProximo);
        resultadoUltimoano = (EditText)findViewById(R.id.edtResultadoUltimoAno);

        //AÇÃO DO BOTÃO PRÓXIMO
        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ENVIA PARA OUTRA TELA
                Intent intentEnviadora = new Intent(getApplicationContext(), tela1.class);
                intentEnviadora.putExtra("resultadoUltimo", resultadoUltimoano.getText().toString());
                startActivity(intentEnviadora);
            }
        });

        //AÇÃO DO BOTÃO AJUDA (?)
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "RESULTADO = RECEITAS - DESPESAS", Toast.LENGTH_SHORT).show();
            }
        });

        //LIMPAR O EDITTEXT AO TOCAR
        resultadoUltimoano.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) resultadoUltimoano.setText("");
                return false;
            }
        });
    }
}