package si.uni_lj.fe.tnuv.habitquesttnuv;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.auth.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

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

    private UserHabitDatabase habitsDb;

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
    }

    @Override
    protected void onStart() {
        super.onStart();

        habitsDb = UserHabitDatabase.getInstance(this);
        UserHabitDao userHabitDao = habitsDb.userHabitDao();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("habit")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            //Log.d(TAG, document.getData().toString());
                        }
                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }
                });

        /*
        UserHabit userHabit = new UserHabit();
        userHabit.setTitle("Testni Naslov");
        userHabit.setDescription("heyheyhey");
        userHabit.setType("good");
        userHabit.setFocus(1.4);
        userHabit.setXp(20);

        new InsertUserHabitTask().execute(userHabit);
        */

        new GetTitleByIdTask().execute(0);

    }

    private class InsertUserHabitTask extends AsyncTask<UserHabit, Void, Void> {
        @Override
        protected Void doInBackground(UserHabit... userHabits) {
            habitsDb.userHabitDao().insert(userHabits[0]);
            return null;
        }
    }

    private class GetAllUserHabitsTask extends AsyncTask<Void, Void, List<UserHabit>> {
        @Override
        protected List<UserHabit> doInBackground(Void... voids) {
            return habitsDb.userHabitDao().getAll();
        }

        @Override
        protected void onPostExecute(List<UserHabit> userHabits) {
            super.onPostExecute(userHabits);
            Log.d(TAG, userHabits.toString());
        }
    }

    private class GetTitleByIdTask extends AsyncTask<Integer, Void, String> {
        @Override
        protected String doInBackground(Integer... ids) {
            return habitsDb.userHabitDao().getTitleById(ids[0]);
        }

        @Override
        protected void onPostExecute(String title) {
            super.onPostExecute(title);
            Log.d(TAG, title);
        }
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