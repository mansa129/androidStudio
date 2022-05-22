package com.example.mymobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MenuActivity2 extends AppCompatActivity {
    TextView menu_total;
    TextView menu_plus1;
    TextView menu_count1;
    TextView menu_minus1;
    TextView menu_plus2;
    TextView menu_count2;
    TextView menu_minus2;
    TextView menu_plus3;
    TextView menu_count3;
    TextView menu_minus3;
    TextView menu_plus4;
    TextView menu_count4;
    TextView menu_minus4;
    TextView menu_total1;



    String id;
    int count = 0, total_price = 0;
    int count1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, //상태바 제거
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu2);

        menu_total = findViewById(R.id.menu_total);
        menu_plus1 = findViewById(R.id.menu_plus1);
        menu_minus1 = findViewById(R.id.menu_minus1);
        menu_count1 = findViewById(R.id.menu_count1);
        menu_plus2 = findViewById(R.id.menu_plus2);
        menu_minus2 = findViewById(R.id.menu_minus2);
        menu_count2 = findViewById(R.id.menu_count2);
        menu_plus3 = findViewById(R.id.menu_plus3);
        menu_minus3 = findViewById(R.id.menu_minus3);
        menu_count3 = findViewById(R.id.menu_count3);
        menu_plus4 = findViewById(R.id.menu_plus4);
        menu_minus4 = findViewById(R.id.menu_minus4);
        menu_count4 = findViewById(R.id.menu_count4);

        getData();

        menu_plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                total_price= total_price +50000;
                menu_total.setText(Integer.toString(total_price));
                menu_count1.setText(Integer.toString(count));
            }
        });
        menu_minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count>0){
                    count--;
                    total_price= total_price - 50000;
                }
                menu_count1.setText(Integer.toString(count));
                if(total_price<0){
                    total_price =0;
                }
                menu_total.setText(Integer.toString(total_price));
            }
        });

        menu_plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count1++;
                total_price= total_price +1000000;
                menu_total.setText(Integer.toString(total_price));
                menu_count1.setText(Integer.toString(count1));
            }
        });
        menu_minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count1>0){
                    count1--;
                    total_price= total_price - 1000000;
                }
                menu_count1.setText(Integer.toString(count1));
                if(total_price<0){
                    total_price =0;
                }
                menu_total.setText(Integer.toString(total_price));
            }
        });
    }



    //함수 생성
    void getData(){
        id = getIntent().getStringExtra("myId");
       // menu_text1.setText(id);
    }
}