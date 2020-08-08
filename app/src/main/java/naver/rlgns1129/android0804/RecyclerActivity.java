package naver.rlgns1129.android0804;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

//재사용 가능한 항목 뷰를 위한 클래스
class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView title;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        //시스템이 제공하는 택스트 뷰를 사용
        title = itemView.findViewById(android.R.id.text1);
    }
}

//RecyclerView에 항목을 만들어주는 Adapter 클래스
class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
    //출력할 데이터 리스트 변수
    //Adapter는 넘겨받은 데이터를 가지고 뷰의 개수를 설정하고
    //출력할 뷰 모양을 만들어주고 그 뷰에 데이터를 출력해주는 클래스
    //Adapter는 Model 이 아님
    //스마트폰에서 모델의 역할은 Activity 또는 별도의 클래스를 생성
    //데이터의 변화가 생겼을 때 데이터를 재출력할려면 주입받는 데이터가 있어야 합니다.
    List<String> list;

    public MyAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //항목 뷰를 생성해서 ViewHolder에게 넘겨줌
        //안드로이드가 제공하는 뷰를 사용
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);

        return new MyViewHolder(view);
    }
    //출력할 데이터를 매핑하는 클래스
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //현재 위치에 해당하는 데이터를 가져오기
        String item = list.get(position);
        holder.title.setText(item);
    }

    @Override
    //출력할 행의 개수를 설정하는 메소드
    public int getItemCount() {
        return list.size();
    }
}

//각 항목을 세부적인 옵션을 설정할 클래스
class MyItemDecoration extends  RecyclerView.ItemDecoration{
    //항목 뷰가 배치될 때 호출되는 메소드
    //outRect 가 외곽 여백 - margin
    //parent - RecyclerView
    //View -  각 항목 뷰
    //state - 현재 상태
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
        //현재 항목 뷰의 인덱스 찾아오기
        int index = parent.getChildAdapterPosition(view) + 1;
//        //예시
//        //Item - category, itemname : category로 정렬
//        Item current = list.get(index);
//        Item prev = llist.get(index - 1);
//        if(current.category.equals(prev.category)){
//            outRect.set(20,20,20,20);
//        }else{
//            outRect.set(20,20,20,60);
//        }

        //3개를 출력하고 여백을 조금 더 설정
        if(index % 3 == 0){
            outRect.set(20,20,20,60);
        }else{
            outRect.set(20,20,20,20);
        }
        //여러 개의 데이터를 출력할 때 그룹 별로 여백을 다르게 지정하고자 하면
        //index로 출력할 데이터를 찾아오고 이전 데이터와의 그룹이 다르면 여백이 많이 설정
        //여러 개의 데이터를 가져올 떄 자주 활용하는 컬럼으로 정렬해서 가져오기

        //뷰의 배경색을 설정
        view.setBackgroundColor(0xFFECECE9);
        ViewCompat.setElevation(view, 20.0f);
    }
}

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        //RecyclerView 찾아오기
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler);

        //출력할 데이터 생성
        ArrayList<String> list = new ArrayList<>();
        list.add("변수");
        list.add("연산자");
        list.add("제어문");
        list.add("배열");
        list.add("클래스");
        list.add("상속과 다형성");
        list.add("인터페이스");
        list.add("내부클래스");
        list.add("예외처리");

        //레이아웃 설정
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //표형태로 그리드 레이아웃을 만들고 싶으면 recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        //(this,4) <- 숫자는 행의 개수
        //recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        //어댑터 설정
        MyAdapter adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
        //아이템 데코레이션 설정
        recyclerView.addItemDecoration(new MyItemDecoration());



    }
}