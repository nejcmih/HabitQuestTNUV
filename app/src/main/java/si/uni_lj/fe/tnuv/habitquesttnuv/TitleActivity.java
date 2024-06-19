package si.uni_lj.fe.tnuv.habitquesttnuv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Title;

public class TitleActivity extends AppCompatActivity {
    ArrayList<Title> titlesArray = new ArrayList<>();



//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.titleslayout, container, false);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.titleslayout);
        RecyclerView recyclerView2 = findViewById(R.id.RecyclerTitle);
        setUpTitle();

        Title_RecycleViewAdapter adapter8 = new Title_RecycleViewAdapter(this, titlesArray);
        recyclerView2.setAdapter(adapter8);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.titliID), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setUpTitle(){
        String[] titleNames = getResources().getStringArray(R.array.titles);
        String[] titleDescs = getResources().getStringArray(R.array.titlesDesc);

        for(int i = 0; i<titleNames.length; i++){
            titlesArray.add(new Title(titleNames[i], titleDescs[i], false));
        }
    }
}
