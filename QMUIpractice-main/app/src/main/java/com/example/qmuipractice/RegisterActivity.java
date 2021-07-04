package com.example.qmuipractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity{
    Button Register;
    private EditText userName;
    private EditText password;
    private EditText email;
    private EditText secondPassword;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        userName = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.passwd1);
        secondPassword = (EditText) findViewById(R.id.passwd2);
        Register=findViewById(R.id.register);
        setOnClickListener();

    }
    private void setOnClickListener(){
        OnClick onClick=new OnClick();
        Register.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v)
        {
            /*try {
                String result = HttpUtil.getRequest(MyContants.BASE_URL + "Login?name="+userName.getText().toString()+"&password="+password.getText().toString());
                if (result == null || "error".equals(result)){
                    Toast.makeText(RegisterActivity.this, "登陆失败！请检查输入信息和网络连接!", 2).show();
                    return ;
                }
                else {

                }
            } catch (Exception e) {
                Toast.makeText(RegisterActivity.this, "登陆失败！请检查网络连接!", 2).show();
                e.printStackTrace();
                return ;
            }*/

            Intent intent =null;
            Toast.makeText(RegisterActivity.this,"Registered successfully!",Toast.LENGTH_LONG).show();
            intent=new Intent(RegisterActivity.this,StartActivity.class);
            startActivity(intent);
        }

    }
}
