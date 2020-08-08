package naver.rlgns1129.android0804;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class OneFragment extends ListFragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //상위 클래스의 메소드를 호출
        super.onViewCreated(view, savedInstanceState);
        //출력할 데이터 생성
        String [] oop = {"Encapsulation", "Inheritance" , "Polymorphism"};
        //Adapter 생성
        //항상 데이터와 똑같은 자료형으로 설정
                   //<String> : 항상 데이터와 똑같은 자료형으로 설정//getActivity() : ? , android.R.layout.simple_list_item_1 : 모양 , oop : 데이터
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, oop);
        //어답터 연결
        this.setListAdapter(adapter);

    }

    @Override
    //listView는 이벤트가 발생한 ListView
    //v는 이벤트가 발생한 항목 뷰
    //position은 누른 항목의 인덱스
    //id는 v의 id ( 구분하기 위해 일련번호 형태로 매긴다)
    public void onListItemClick(@NonNull ListView listView, @NonNull View v, int position, long id) {
        //상위 클래스의 메소드를 호출
        //내가 직접 구현한 메소드를 오버라이딩할때는
        //반드시 상위클래스를 호출해 주어야 하지만 기본적으로 내용이 없으면 호출을 안해도
        //오류는 나지 않는다. 하지만 그래도 해주는 것이 좋음
        super.onListItemClick(listView, v, position, id);

        //선택한 데이터 찾아오기
        String item = (String)listView.getAdapter().getItem(position);

        //Toast 출력
        Toast.makeText(getActivity(), item , Toast.LENGTH_LONG).show();

    }
}
