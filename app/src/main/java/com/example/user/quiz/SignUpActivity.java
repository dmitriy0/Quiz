package com.example.user.quiz;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private String mLogin;
    private String mPassword;
    private String mPasswordRepeat;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        setContentView(R.layout.activity_sign_up);
        Button reg = (Button) findViewById(R.id.button4); // кнопка регистрации
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLogin = ((EditText) findViewById(R.id.Login)).getText().toString();
                mPassword = ((EditText) findViewById(R.id.Password)).getText().toString();
                mPasswordRepeat = ((EditText) findViewById(R.id.RepeatPassword)).getText().toString();
                if ("".equals(mLogin) || "".equals(mPassword) || "".equals(mPasswordRepeat)) {
                    Toast.makeText(getApplicationContext(), "Одно из полей не заполненно. Пожалуйста, заполните все поля и повторите отправку", Toast.LENGTH_LONG).show();
                } else{ if (mPasswordRepeat.equals(mPassword)){
                    addUser();
                }else {
                    Toast.makeText(getApplicationContext(), "Пароли не совпадают, повторите попытку", Toast.LENGTH_LONG).show();
                }
                }

            }
        });

    }
    private void addUser() {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(mLogin + "", mPassword + "").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                    //Toast.makeText(getApplicationContext(), "Регистрация успешна", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);

                    intent.putExtra("PARAM", 2);

                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Регистрация провалена", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}



