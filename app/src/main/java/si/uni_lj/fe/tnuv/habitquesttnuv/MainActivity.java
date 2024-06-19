package si.uni_lj.fe.tnuv.habitquesttnuv;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.UpperClothe;
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Player;

/** @noinspection deprecation*/
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

    private ServerHabitDatabase serverHabitsDb;

    /** @noinspection deprecation*/
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
                            serverHabit.setTitle(Objects.requireNonNull(document.get("title")).toString());
                            serverHabit.setDescription(Objects.requireNonNull(document.get("description")).toString());
                            serverHabit.setType(Objects.requireNonNull(document.get("type")).toString());
                            serverHabit.setXp(Integer.parseInt(Objects.requireNonNull(document.get("xp")).toString()));

                            if (document.get("focus") != null) {
                                serverHabit.setFocus(Double.parseDouble(Objects.requireNonNull(document.get("focus")).toString()));
                            }
                            if (document.get("hp") != null) {
                                serverHabit.setHp(Double.parseDouble(Objects.requireNonNull(document.get("hp")).toString()));
                            }

                            new InsertServerTask().execute(serverHabit);
                        }
                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }
                });

        new SelectHabitDescription().execute();


        //inicializirajUporabnika
        //TODO: Naj iz sql baze ali pa iz jsona prebere podatke za inicializacijo igralca
        //Tukaj devam dummy data noter ta cas ko ni baze
        //ker ni neke baze zadaj, ne morem unlockinga nastimat
        Player igralec = new Player("Luka Koromac");
        igralec.setStreak(6);
        igralec.setLevel(2);
        igralec.setXp(1120);
        igralec.setXpToLevel(1200);
        igralec.setCurrentFocus(2.4f);
        igralec.setMaxFocus(3);
        igralec.setChosenTitle("Peace Promoter");
        int[] izbor = {0,0,0,0,0,0};
        igralec.setIzbiraObleke(izbor);



    }

    private class SelectHabitDescription extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            String habitDesc = serverHabitsDb.serverHabitDao().getDescById(20);
            if (habitDesc == null) {
                Log.d(TAG, "desc je null");
            }
            else {
                Log.d(TAG, habitDesc);
            }
            return habitDesc;
        }
        @Override
        protected void onPostExecute(String habitDesc) {
            super.onPostExecute(habitDesc);

            //Collections.copy(listGoodHabits, userHabits);
        }
    }

    /** @noinspection deprecation*/
    private class DeleteServerTasks extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            serverHabitsDb.serverHabitDao().deleteAllHabits();
            return null;
        }
    }

    /** @noinspection deprecation*/
    private class InsertServerTask extends AsyncTask<ServerHabit, Void, Void> {
        @Override
        protected Void doInBackground(ServerHabit... serverHabits) {
            serverHabitsDb.serverHabitDao().insert(serverHabits[0]);
            return null;
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