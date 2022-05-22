 package com.example.mymobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

 public class ItemActivity extends AppCompatActivity {
    String id;
   static TextView item_total;
    GridView grid_view;
    static int total_price = 0;
    Button item_payment;

    String pdt_name[]={"헤드폰", "노트북","패드","휴대폰","컴퓨터","라디오","마우스","TV","선풍기"};
    int pdt_photo[] = {R.drawable.headphones, R.drawable.computer, R.drawable.ipad, R.drawable.phone,
            R.drawable.computer1, R.drawable.radio, R.drawable.mouse, R.drawable.tv, R.drawable.air };
    int pdt_price[] = {50000, 1000000, 500000, 450000, 2000000, 60000, 7000, 4500000, 35430};
    int pdt_count[] = {0, 0, 0, 0, 0, 0, 0, 0, 0,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, //상태바 제거
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_item);

        item_total = findViewById(R.id.item_total);
        grid_view = findViewById(R.id.grid_view);
        item_payment = findViewById(R.id.item_payment);

        item_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ItemActivity.this, "결제 완료", Toast.LENGTH_SHORT).show();
            }
        });

        item_total.setText("총 가격:" + total_price+ "원");

        ItemAdapter adapter = new ItemAdapter(ItemActivity.this, pdt_name, pdt_photo, pdt_price, pdt_count);
        grid_view.setAdapter(adapter);



    }
    public String addComma ( int number){
        String result = "";
        StringBuffer sb = new StringBuffer();
        result = "" + number;
        sb.append(result);
        if (number < 1000) {
            result = "" + number;
        } else if (number < 1000000) {
            //1000,9999,99999,999999
            if (number < 10000) {
                // 99990
                result = "" + number;
                sb.append(result);
                sb.insert(1, ",");
            } else if (number < 100000) {
                result = "" + number;
                sb.append(result);
                sb.insert(2, ",");
            } else {
                //99999
                result = "" + number;
                sb.append(result);
                sb.insert(3, ",");

            }
        } else if (number < 1000000000) {
            if (number < 10000000) {
                //9999999
                sb.insert(4, ",");
                sb.insert(1, ",");
            } else if (number < 100000000) {
                //99999999
                sb.insert(5, ",");
                sb.insert(2, ",");
            } else {
                //999,999,999
                sb.insert(6, ",");
                sb.insert(3, ",");
            }
        }

        return sb.toString();
    }
}
