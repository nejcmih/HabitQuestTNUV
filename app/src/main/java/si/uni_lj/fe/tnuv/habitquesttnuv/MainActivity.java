package si.uni_lj.fe.tnuv.habitquesttnuv;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;

public class MainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {

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

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_good);
    }

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
}