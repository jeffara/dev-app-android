package br.com.fiap.demolayoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText etUser;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText) findViewById(R.id.etUserID);
        etPassword = (EditText) findViewById(R.id.etPasswordID);
        btnLogin = (Button) findViewById(R.id.btnLoginID);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cadastroActivity = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(cadastroActivity);

            }
        });
    }
}