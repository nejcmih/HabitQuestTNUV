package si.uni_lj.fe.tnuv.habitquesttnuv;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddBadHabitActivity extends AppCompatActivity {

    private UserHabitDatabase habitsDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_bad_habit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        habitsDb = UserHabitDatabase.getInstance(this);
    }

    public void saveBadHabit(View v) {
        EditText vnosName = findViewById(R.id.editBadName);
        EditText vnosDescription = findViewById(R.id.editBadDesc);
        EditText vnosHp = findViewById(R.id.editBadHp);
        EditText vnosXp = findViewById(R.id.editBadXp);

        String name = vnosName.getText().toString();
        String description = vnosDescription.getText().toString();
        Double hp = Double.parseDouble(vnosHp.getText().toString());
        int xp = Integer.parseInt(vnosXp.getText().toString());

        UserHabit userHabit = new UserHabit();
        userHabit.setTitle(name);
        userHabit.setDescription(description);
        userHabit.setType("bad");
        userHabit.setHp(hp);
        userHabit.setXp(xp);

        new InsertUserHabitTask().execute(userHabit);

        finishAddBadHabit(v);
    }

    private class InsertUserHabitTask extends AsyncTask<UserHabit, Void, Void> {
        @Override
        protected Void doInBackground(UserHabit... userHabits) {
            habitsDb.userHabitDao().insert(userHabits[0]);
            return null;
        }
    }

    public void finishAddBadHabit(View v) {
        AddBadHabitActivity.this.finish();
    }
}