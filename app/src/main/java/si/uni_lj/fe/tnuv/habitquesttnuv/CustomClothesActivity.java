package si.uni_lj.fe.tnuv.habitquesttnuv;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.UpperClothe;

public class CustomClothesActivity extends AppCompatActivity {
    ArrayList<UpperClothe> upperBodyClothes = new ArrayList<>();
    int[] upperBodyClothesImages = {
            R.drawable.majica,
            R.drawable.ph_upper2,
            R.drawable.ph_upper3,
            R.drawable.ph_upper4,
            R.drawable.ph_upper5
    };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_customclothes);




            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
            RecyclerView recyclerView2 = findViewById(R.id.RecyclerUpper);
            setUpUpperClothe();
            UpperClothe_RecyclewViewAdapter adapter2 = new UpperClothe_RecyclewViewAdapter(this, upperBodyClothes);
            recyclerView2.setAdapter(adapter2);
            recyclerView2.setLayoutManager(new LinearLayoutManager(this));


        }


    private void setUpUpperClothe(){
        String[] upperClotheNames = getResources().getStringArray(R.array.upperClotheName);

        for(int i = 0; i<upperClotheNames.length; i++){
            upperBodyClothes.add(new UpperClothe(upperBodyClothesImages[i], upperClotheNames[i]));
        }
    }

        public void finishCustomClothes(View v) {
            CustomClothesActivity.this.finish();
        }
}
