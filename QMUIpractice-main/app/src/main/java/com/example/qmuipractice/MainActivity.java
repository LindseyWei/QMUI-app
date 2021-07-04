package com.example.qmuipractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button Login;
    private Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login=(Button)findViewById(R.id.logIn);
        Register=(Button)findViewById(R.id.register);
        setOnClickListener();
        /*Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(MainActivity.this,nextActivity.class);
                startActivity(intent);
                //Toast.makeText(MainActivity.this,"bingo", Toast.LENGTH_LONG).show();
            }
            public void onClick(View view){

            }
        });*/
    }
    private void setOnClickListener(){
        OnClick onClick=new OnClick();
        Login.setOnClickListener(onClick);
        Register.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v)
        {
            Intent intent =null;
            switch(v.getId()) {
                case R.id.logIn:
                    intent=new Intent(MainActivity.this,nextActivity.class);
                    startActivity(intent);
                    break;
                case R.id.register:
                    intent=new Intent(MainActivity.this,RegisterActivity.class);
                    startActivity(intent);
                    break;
            }
            startActivity(intent);
        }
    }
}


