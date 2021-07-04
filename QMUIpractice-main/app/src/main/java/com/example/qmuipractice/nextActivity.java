package com.example.qmuipractice;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qmuipractice.util.HttpUtil;
import com.example.qmuipractice.util.MyContants;

public class nextActivity extends AppCompatActivity {

    Button Login;
    private EditText userName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next);
        Login=findViewById(R.id.register);
        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        setOnClickListener();
        if(Build.VERSION.SDK_INT>9){
            StrictMode.ThreadPolicy policy =new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }
    private void setOnClickListener(){
        OnClick onClick=new OnClick();
        Login.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v)
        {
            try {
                String result = HttpUtil.getRequest(MyContants.BASE_URL + "LoginServlet?name=" + userName.getText().toString() + "&password=" + password.getText().toString());
                int res = Integer.parseInt(result.trim());
                System.out.println(res + "==" + (res == 0));
                if (res == 0) {
                    Toast.makeText(nextActivity.this, "Login failed！Please check your information！", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    Intent intent = null;
                    Toast.makeText(nextActivity.this, "Registered successfully!", Toast.LENGTH_LONG).show();
                    intent = new Intent(nextActivity.this, StartActivity.class);
                    startActivity(intent);
                }
            }
            catch(Exception e)
            {
                Toast.makeText(nextActivity.this, "Login failed！Please check your internet connection！", Toast.LENGTH_LONG).show();
                e.printStackTrace();
                return;
            }
        }
    }
}
