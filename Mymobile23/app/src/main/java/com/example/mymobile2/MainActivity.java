package com.example.mymobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {
    //AppCompatActivity 복사 붙여넣기!!!
    EditText edit1;
    EditText edit2;
    Button button1;
    TextView text1;
    String m_id = "abcd";
    String m_pass = "123";
    String input1 = "", input2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //상태바 없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //화면과 변수의 연결
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        button1 = findViewById(R.id.button1);
        text1 = findViewById(R.id.text1);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                input1 = edit1.getText().toString();
                input2 = edit2.getText().toString();
                if(input1.equals(m_id) && input2.equals(m_pass)){
                    //Toast.makeText(getApplicationContext(), "로그인에 성공했습니다!", Toast.LENGTH_LONG).show();
                    //text1.setText("로그인에 성공했습니다.");
                    Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                    intent.putExtra("myId", m_id);
                    startActivity(intent);
                    //finish();

                }else{
                    Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 일치하지 않습니다ㅜ", Toast.LENGTH_LONG).show();
                    //text1.setText("로그인에 실패했습니다.");
                }


            }
        });

    }

    @Override
    protected void onDestroy() {
        Toast.makeText(getApplicationContext(), "빠이빠이~~!", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}