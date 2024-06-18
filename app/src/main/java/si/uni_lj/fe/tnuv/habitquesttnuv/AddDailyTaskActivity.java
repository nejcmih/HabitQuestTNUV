package si.uni_lj.fe.tnuv.habitquesttnuv;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddDailyTaskActivity extends AppCompatActivity {

    private UserHabitDatabase habitsDb;
    String selectedType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_daily_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner vnosType = findViewById(R.id.editDailyType);
        vnosType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
                selectedType = parent.getItemAtPosition(position).toString().toLowerCase();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        habitsDb = UserHabitDatabase.getInstance(this);
    }

    public void saveDailyTask(View v) {
        EditText vnosName = findViewById(R.id.editDailyName);
        EditText vnosDescription = findViewById(R.id.editDailyDesc);
        EditText vnosXp = findViewById(R.id.editDailyXp);

        String name = vnosName.getText().toString();
        String description = vnosDescription.getText().toString();
        int xp = Integer.parseInt(vnosXp.getText().toString());

        UserHabit userHabit = new UserHabit();
        userHabit.setTitle(name);
        userHabit.setDescription(description);
        userHabit.setType(selectedType);
        userHabit.setXp(xp);

        new InsertUserHabitTask().execute(userHabit);

        finishAddDailyTask(v);
    }

    private class InsertUserHabitTask extends AsyncTask<UserHabit, Void, Void> {
        @Override
        protected Void doInBackground(UserHabit... userHabits) {
            habitsDb.userHabitDao().insert(userHabits[0]);
            return null;
        }
    }

    public void finishAddDailyTask(View v) {
        AddDailyTaskActivity.this.finish();
    }
}