package naver.rlgns1129.android0804;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class NavigationActivity extends AppCompatActivity {
    DrawerLayout drawer;
    //메뉴를 토글할 변수
    ActionBarDrawerToggle toggle;
    //현재 메뉴 표시 여부를 저장할 변수
    boolean isDrawOpend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        //네비게이션 출력 설정
        drawer = (DrawerLayout)findViewById(
                R.id.main_drawer);
        //토글 생성
        toggle = new ActionBarDrawerToggle(
                this, drawer,
                R.string.drawer_open, R.string.drawer_close);
        //액션 바에 출력
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.syncState();

        //메뉴를 눌렀을 때 수행할 코드를 작성
        NavigationView navigationView =
                (NavigationView)findViewById(R.id.main_draw_view);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        //메뉴 아이디를 찾아옴
                        int id = item.getItemId();
                        if(id == R.id.menu_drawer_home){
                            Toast.makeText(NavigationActivity.this,
                                    "홈을 선택", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(NavigationActivity.this,
                                    "메시지를 선택", Toast.LENGTH_LONG).show();
                        }

                        return false;
                    }
                });


    }

    //삼선 버튼을 눌렀을 때 호출되는 메소드
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(toggle.onOptionsItemSelected(item)){
            return false;
        }
        return super.onOptionsItemSelected(item);
    }
}