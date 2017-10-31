package com.zaaach.citypickerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zaaach.citypicker.CityPickerActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_PICK_CITY = 233;
    private TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTV = (TextView) findViewById(R.id.tv_result);
        findViewById(R.id.btn_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> hostCitys=new ArrayList<String>();
              Intent intent=  new Intent(MainActivity.this, CityPickerActivity.class);
                intent.putExtra("locationcity","济南市");
                intent.putExtra("locationDistrict","高新区");

                hostCitys.add("济南");
                hostCitys.add("北京");
                hostCitys.add("安阳");
                hostCitys.add("泰山");
                hostCitys.add("泰山");
                hostCitys.add("泰山");
                hostCitys.add("泰山");
                hostCitys.add("泰山");
                hostCitys.add("泰山");
                intent.putStringArrayListExtra("hotCitys",hostCitys);
                startActivityForResult(intent,
                        REQUEST_CODE_PICK_CITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK){
            if (data != null){
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                resultTV.setText("当前选择：" + city);
            }
        }
    }
}
