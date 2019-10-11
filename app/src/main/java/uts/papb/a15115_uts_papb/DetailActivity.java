package uts.papb.a15115_uts_papb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();
        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText(getIntent().getStringExtra("text1"));
        TextView tv2 = findViewById(R.id.tv2);
        tv2.setText(getIntent().getStringExtra("text2"));
        TextView tv3 = findViewById(R.id.tv3);
        tv3.setText(getIntent().getStringExtra("text3"));
    }
}
