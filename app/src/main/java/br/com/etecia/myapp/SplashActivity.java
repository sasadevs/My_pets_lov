package br.com.etecia.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {
    EditText edtEmail, edtSenha;
    Button btnSair, btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.splash_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnSair = findViewById(R.id.btnSair);




        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }


        });
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, senha;

                email = edtEmail.getText().toString();
                senha = edtSenha.getText().toString();

                if (email.equals("etecia") && senha.equals("etecia")){
                    Intent intent = new Intent(getApplicationContext(),
                            MenuprincipalActivity.class);
                    startActivity(Intent);

                    finish();

                }
                else
                    Toast.makeText(getApplicationContext(), "Usuário ou senha inválidos!!!", Toast.LENGTH_SHORT).show();


                Toast.makeText(getApplicationContext(), "Acessando o Sistemas!!!", Toast.LENGTH_LONG).show();
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




        //criar método thread para abrir janela
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
        //Abrir janela de login
                Intent intent = new Intent(getApplicationContext(),
                        LoginActivity.class);
                startActivity(intent);


            }
        }, 2000);

    }
}