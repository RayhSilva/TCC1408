package com.example.SOSCAPIVARI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaInicial extends AppCompatActivity {
    private TextView text_cadastrar;
    Button btnLogin;
    Button btnSemCadastro;
    SQLiteDatabase bancoDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        IniciarComponentes();
        text_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TelaInicial.this, CriarConta.class);
                startActivity(intent);
            }
        });

        btnLogin = (Button) findViewById(R.id.btnEntrar);
        btnSemCadastro = (Button) findViewById(R.id.btnSemCadastro);

        btnSemCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SemCadastro();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cadastro_Entrar();
            }
        });
            criarBancoDados();


    }

    public void criarBancoDados () {

        try {
            bancoDados = openOrCreateDatabase("sosCapivari", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS usuario (" +
                    " Email VARCHAR PRIMARY KEY" +
                    " , Senha VARCHAR" +
                    " , Nome VARCHAR" +
                    ", Tipo VARCHAR)"); // 'comum' ou 'adm'
            //bancoDados.execSQL("DELETE FROM animal");
            bancoDados.execSQL("INSERT INTO usuario (Email,Senha) VALUES('wagner','123','comum') ");
            bancoDados.execSQL("INSERT INTO usuario (Email,Senha,Tipo) VALUES('ray','12324687651','adm') ");
            bancoDados.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void Cadastro_Entrar() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void SemCadastro() {
        Intent intent = new Intent(this, TelaPrincipal.class);
        startActivity(intent);
    }



private void IniciarComponentes(){
    text_cadastrar= findViewById(R.id.text_cadastrar);
}}