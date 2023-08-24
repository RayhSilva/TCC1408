package com.example.SOSCAPIVARI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CriarConta extends AppCompatActivity {
        EditText txtNomeC,txtEmailC, txtConfEmail, txtSenhaC, txtConfSenha;
        Button btnCadastrar;
        SQLiteDatabase bancoDados;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        txtNomeC = (EditText) findViewById(R.id.txtNomeC);
        txtEmailC = (EditText) findViewById(R.id.txtEmailC);
        txtConfEmail = (EditText) findViewById(R.id.txtConfEmail);
        txtSenhaC = (EditText) findViewById(R.id.txtSenhaC);
        txtConfSenha = (EditText) findViewById(R.id.txtConfSenhaC);
        btnCadastrar = (Button) findViewById(R.id.btnEntrar);


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cadastrar();
                // vai chamar o metodo de fazer login
            }
        });

    }


    public void Cadastrar() {
        if (!TextUtils.isEmpty(txtNomeC.getText().toString())  && !TextUtils.isEmpty(txtEmailC.getText().toString())
            && !TextUtils.isEmpty(txtConfEmail.getText().toString()) && !TextUtils.isEmpty(txtSenhaC.getText().toString())
              && !TextUtils.isEmpty(txtConfSenha.getText().toString())){

            //Aqui pode fazer um IF pra verificar se as senhas são iguais e tbm se os emails são iguais

            try {
                bancoDados = openOrCreateDatabase("sosCapivari", MODE_PRIVATE, null);
                String sql = "INSERT INTO usuario (Nome,Email,Senha) VALUES (?,?,?)";
                SQLiteStatement stmt = bancoDados.compileStatement(sql);
                stmt.bindString(1, txtNomeC.getText().toString());
                stmt.bindString(2, txtEmailC.getText().toString());
                stmt.bindString(3, txtSenhaC.getText().toString());

                stmt.executeInsert();
                bancoDados.close();
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }





    public void MinhaTela2 (){
        Intent intent = new Intent(this, TelaPrincipal.class);
        startActivity(intent);}






    }
