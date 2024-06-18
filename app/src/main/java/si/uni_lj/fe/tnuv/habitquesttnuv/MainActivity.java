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
import java.util.Objects;

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
    private ServerHabitDatabase serverHabitsDb;

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

        // Naloži podatke s Firebasa
        serverHabitsDb = ServerHabitDatabase.getInstance(this);
        new DeleteServerTasks().execute();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("habit")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            //document.get("title").toString();
                            ServerHabit serverHabit = new ServerHabit();
                            serverHabit.setTitle(document.get("title").toString());
                            serverHabit.setDescription(document.get("description").toString());
                            serverHabit.setType(document.get("type").toString());
                            serverHabit.setXp(Integer.parseInt(document.get("xp").toString()));

                            if (document.get("focus") != null) {
                                serverHabit.setFocus(Double.parseDouble(document.get("focus").toString()));
                            }
                            if (document.get("hp") != null) {
                                serverHabit.setHp(Double.parseDouble(document.get("hp").toString()));
                            }

                            new InsertServerTask().execute(serverHabit);
                        }
                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();

        habitsDb = UserHabitDatabase.getInstance(this);
        UserHabitDao userHabitDao = habitsDb.userHabitDao();
    }

    private class DeleteServerTasks extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            serverHabitsDb.serverHabitDao().deleteAllHabits();
            return null;
        }
    }

    private class InsertServerTask extends AsyncTask<ServerHabit, Void, Void> {
        @Override
        protected Void doInBackground(ServerHabit... serverHabits) {
            serverHabitsDb.serverHabitDao().insert(serverHabits[0]);
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