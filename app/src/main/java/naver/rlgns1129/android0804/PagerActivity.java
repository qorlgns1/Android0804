package naver.rlgns1129.android0804;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class PagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        //어답터 생성
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);
    }
}