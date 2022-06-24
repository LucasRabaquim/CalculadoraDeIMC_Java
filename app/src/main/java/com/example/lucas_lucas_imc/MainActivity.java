package com.example.lucas_lucas_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editPeso,editAltura,editSexo;
    TextView txtResultado;
    RadioButton btnMasculino,btnFeminino;
    float peso, altura;
    int sexo;
    String resultado;
    final String mensagem[] = {"Abaixo do Normal","Normal","Obesidade Leve","Obesidade Moderada","Obesidade Mórbida"};
    final double valores[][] = {
            {0,20,26,30,43},
            {0,19,24,29,39}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        editSexo = findViewById(R.id.editSexo);
        txtResultado = findViewById(R.id.txtResultado);
        btnMasculino = findViewById(R.id.rbtnMasculino);
        btnFeminino = findViewById(R.id.rbtnFeminino);
    }

    public void Calcula(View view){
        peso = Float.parseFloat(editPeso.getText().toString());
        altura = Float.parseFloat(editAltura.getText().toString());
        double imc = peso / Math.pow(altura,2);
        if(btnMasculino.isChecked()) sexo = 1;
      //  if(btnFeminino)
        for(int i=0; i<5;i++){
            if(imc >= valores[sexo][i]) resultado = mensagem[i];
        }
        txtResultado.setText(resultado);
    }

}