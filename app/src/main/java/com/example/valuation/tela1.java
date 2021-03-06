package com.example.valuation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.BreakIterator;
import java.text.DecimalFormat;

public class tela1 extends AppCompatActivity {

    TextView resultado;
    TextView resultadoFinal;
    EditText ano1;
    EditText ano2;
    EditText ano3;
    Button btcalcular;
    ImageButton btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //REFERENCIANDO OBJETOS
        resultado = (TextView)findViewById(R.id.txtUltimoResultado);
        resultadoFinal = (TextView) findViewById(R.id.txtResultadoFinal);
        ano1 = (EditText) findViewById(R.id.edtAno1);
        ano2 = (EditText) findViewById(R.id.edtAno2);
        ano3 = (EditText) findViewById(R.id.edtAno3);
        btcalcular = (Button) findViewById(R.id.btnCalcular);
        btVoltar = (ImageButton)findViewById(R.id.btnVoltar);

        //PEGAR VALOR DA OUTRA TELA
        Intent dados = getIntent();
        if(dados != null){
            String dadosRecebidos = dados.getStringExtra("resultadoUltimo");
            Log.d("filtro", dadosRecebidos+ "");
            resultadoFinal.setText(dadosRecebidos.toString());
            if(dadosRecebidos != null) {
                String resultadoUltimoano = dadosRecebidos;
                resultado.setText(dadosRecebidos);
            }
        }

        //LIMPAR O EDITTEXT AO TOCAR
        ano1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) ano1.setText("");
                return false;
            }
        });
        ano2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) ano2.setText("");
                return false;
            }
        });
        ano3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) ano3.setText("");
                return false;
            }
        });

        //AÇÃO BOTÃO CALCULAR
        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //IR PARA A PRÓXIMA TELA
                Intent intent = new Intent(getApplicationContext(), tela3.class);
                startActivity(intent);

                //COMEÇANDO O CALCULO
                //CONVERTENDO STRING PARA DOUBLE
                double Aresultado = Double.parseDouble(resultado.getText().toString());
                double Aano1 = Double.parseDouble(ano1.getText().toString());
                double Aano2 = Double.parseDouble(ano2.getText().toString());
                double Aano3 = Double.parseDouble(ano3.getText().toString());

                //DECLARANDO O CRESCIMENTO DOS ANOS 4 E 5 IGUAL DO ANO 3
                double Aano4 = Aano3;
                double Aano5 = Aano3;

                //TRANSFORMANDO OS CRESCIMENTOS ANUAIS EM DECIMAIS
                double ano1D = Aano1 / 100;
                double ano2D = Aano2 / 100;
                double ano3D = Aano3 / 100;
                double ano4D = Aano4 / 100;
                double ano5D = Aano5 / 100;

                //ESTIMANDO O CRESCIMENTO DOS ANOS 1 AO 5
                double resultadoAno1 = Aresultado + (Aresultado * ano1D);
                double resultadoAno2 = resultadoAno1 + (resultadoAno1 * ano2D);
                double resultadoAno3 = resultadoAno2 + (resultadoAno2 * ano3D);
                double resultadoAno4 = resultadoAno3 + (resultadoAno3 * ano4D);
                double resultadoAno5 = resultadoAno4 + (resultadoAno4 * ano5D);

                //TAXA SELIC
                double txSELIC = 0.025;

                //TRAZENDO OS CRESCIMENTOS PARA O VALOR PRESENTE ATRAVÉS DA TAXA SELIC
                double VPAno1 = resultadoAno1 / (1 + txSELIC);
                double VPAno2 = resultadoAno2 / (1 + txSELIC);
                double VPAno3 = resultadoAno3 / (1 + txSELIC);
                double VPAno4 = resultadoAno4 / (1 + txSELIC);
                double VPAno5 = resultadoAno5 / (1 + txSELIC);

                //VALOR DA EMPRESA
                double valorEmpresa = VPAno1 + VPAno2 + VPAno3 + VPAno4 + VPAno5;

                //FORMATANDO O VALOR DA EMPRESA PARA DUAS CASAS
                String resultado = String.format("%.2f", valorEmpresa);

                //EXIBINDO O RESULTADO
                resultadoFinal.setText("R$ " + resultado);

                //ENVIA PARA OUTRA TELA
                Intent intentEnviadora = new Intent(getApplicationContext(), tela3.class);
                intentEnviadora.putExtra("resultadoUltimo", resultadoFinal.getText().toString());
                startActivity(intentEnviadora);
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}