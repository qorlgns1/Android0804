package naver.rlgns1129.android0804;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    //Fragment 의 List 생성
    ArrayList<Fragment> fragments;

    //생성자 - 상위 클래스에 기본 생성자가 없어서 생성
    public MyPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        //스와이프로 보여질 프래그먼트 리스트를 생성
        fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new ThreeFragment());
    }

    @NonNull
    @Override
    //실제 출력될 Fragment를 설정하는 메소드
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    //출력할 Fragment 개수를 설정하는 멤소
    @Override
    //이 메소드가 리턴한 만큼 다른 메소드를 수행
    public int getCount() {
        //직접 상수를 쓰지말고, 아래와 같은 방식으로 리턴.
        return fragments.size();
    }
}
