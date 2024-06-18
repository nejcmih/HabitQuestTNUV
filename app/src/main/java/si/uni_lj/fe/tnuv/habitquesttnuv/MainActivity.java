package si.uni_lj.fe.tnuv.habitquesttnuv;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.UpperClothe;

public class MainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {

//    ArrayList<UpperClothe> upperBodyClothes = new ArrayList<>();
//    int[] upperBodyClothesImages = {
//            R.drawable.majica,
//            R.drawable.ph_upper2,
//            R.drawable.ph_upper3,
//            R.drawable.ph_upper4,
//            R.drawable.ph_upper5
//    };

    BottomNavigationView bottomNavigationView;
    GoodHabitFragment goodHabitFragment = new GoodHabitFragment();
    BadHabitFragment badHabitFragment = new BadHabitFragment();
    DailyTasksFragment dailyTasksFragment = new DailyTasksFragment();
    EventRaidFragment eventRaidFragment = new EventRaidFragment();
    ProfileFragment profileFragment = new ProfileFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RecyclerView recyclerView2 = findViewById(R.id.RecyclerUpper);
//        setUpUpperClothe();
//        UpperClothe_RecyclewViewAdapter adapter2 = new UpperClothe_RecyclewViewAdapter(this, upperBodyClothes);
//        recyclerView2.setAdapter(adapter2);
//        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_good);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("habit")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d(TAG, document.getData().toString());
                        }
                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }
                });
    }

//    private void setUpUpperClothe(){
//        String[] upperClotheNames = getResources().getStringArray(R.array.upperClotheName);
//
//        for(int i = 0; i<upperClotheNames.length; i++){
//            upperBodyClothes.add(new UpperClothe(upperBodyClothesImages[i], upperClotheNames[i]));
//        }
//    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId() == R.id.menu_good) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, goodHabitFragment)
                    .commit();
            return true;
        }
        else if (item.getItemId() == R.id.menu_bad) {
            getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout, badHabitFragment)
                        .commit();
            return true;
        }
        else if (item.getItemId() == R.id.menu_event) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, eventRaidFragment)
                    .commit();
            return true;
        }
        else if (item.getItemId() == R.id.menu_daily) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, dailyTasksFragment)
                    .commit();
            return true;
        }
        else if (item.getItemId() == R.id.menu_profile) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, profileFragment)
                    .commit();
            return true;
        }
        return false;
    }

    public void startAddGoodHabit(View v) {
        Intent intent = new Intent(MainActivity.this, AddGoodHabitActivity.class);
        startActivity(intent);
    }

    public void startAddBadHabit(View v) {
        Intent intent = new Intent(MainActivity.this, AddBadHabitActivity.class);
        startActivity(intent);
    }

    public void startAddDailyTask(View v) {
        Intent intent = new Intent(MainActivity.this, AddDailyTaskActivity.class);
        startActivity(intent);
    }

    public void start_customClothes(View v){
        Intent intent = new Intent(MainActivity.this, CustomClothesActivity.class);
        startActivity(intent);
    }
}