package naver.rlgns1129.android0804;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Button list , dialog, fragment;

    Button btn1 , btn2, btn3;

    FragmentManager fm;
    OneFragment oneFragment;
    TwoFragment twoFragment;
    ThreeFragment threeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.list);
        btn2 = (Button)findViewById(R.id.dialog);
        btn3 = (Button)findViewById(R.id.fragment);

        //FragmentManager 생성
        fm = getSupportFragmentManager();
        //Fragment 객체 생성
        oneFragment = new OneFragment();
        //화면을 갱신할 준비
        FragmentTransaction tf = fm.beginTransaction();
        tf.addToBackStack(null);
        //메인 컨테이너 영역에 oneFragment를 출력
        tf.add(R.id.main_container, oneFragment);
        //화면을 갱신
        tf.commit();

        //방법 1
//        //각각의 이벤트 핸들러 만들기 btn2, btn2 동일
//        btn1.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();



        //방법 2
        //버튼 들의 이벤트 처리 객체
        Button.OnClickListener handler = new Button.OnClickListener(){
            @Override
            //이벤트 처리 메소드의 매개변수 정보를 이용하면
            //이벤트가 발생한 객체와 그 이벤트 처리를 위해서 필요한 정보를 가져올 수 있습니다.
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.list:
                        FragmentTransaction tf = fm.beginTransaction();
                        tf.addToBackStack(null);
                        //tf.add(R.id.main_container, oneFragment); <- 처음에만..!
                        tf.replace(R.id.main_container,oneFragment);
                        tf.commit();
                        return;
                    case R.id.dialog:
                        //대화상자는 다른 프래그먼트와 교체되는 것이 아니고
                        //프래그먼트 위에 출력되는 것입니다.
                        if(twoFragment.isVisible() == false){
                            twoFragment.show(fm, null);
                        }
                        return;
                    case R.id.fragment:
                        FragmentTransaction tf2 = fm.beginTransaction();
                        tf2.addToBackStack(null);
                        tf2.replace(R.id.main_container,threeFragment);
                        tf2.commit();
                        return;
                }
            }
        };
        //버튼에 클릭 이벤트 처리를 위한 핸들러 연결
        btn1.setOnClickListener(handler);
        btn2.setOnClickListener(handler);
        btn3.setOnClickListener(handler);


//        //방법 3
//        //자기에게 implements 한 경우는
//        btn1.setOnClickListener(this);
//        btn2.setOnClickListener(this);
//        btn3.setOnClickListener(this);


    }

//    //방법 3 - 맨위에 public class MainActivity extends AppCompatActivity implements Button.OnClickListener
//    @Override
//    public void onClick(View view) {
//
//        switch (view.getId()){
//
//        }
//    }


}