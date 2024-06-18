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

public class AddGoodHabitActivity extends AppCompatActivity {

    private UserHabitDatabase habitsDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_good_habit);
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

    public void saveGoodHabit(View v) {
        EditText vnosName = findViewById(R.id.editGoodName);
        EditText vnosDescription = findViewById(R.id.editGoodDesc);
        EditText vnosFocus = findViewById(R.id.editGoodFocus);
        EditText vnosXp = findViewById(R.id.editGoodXP);

        String name = vnosName.getText().toString();
        String description = vnosDescription.getText().toString();
        Double focus = Double.parseDouble(vnosFocus.getText().toString());
        int xp = Integer.parseInt(vnosXp.getText().toString());

        UserHabit userHabit = new UserHabit();
        userHabit.setTitle(name);
        userHabit.setDescription(description);
        userHabit.setType("good");
        userHabit.setFocus(focus);
        userHabit.setXp(xp);

        new InsertUserHabitTask().execute(userHabit);

        finishAddGoodHabit(v);
    }

    private class InsertUserHabitTask extends AsyncTask<UserHabit, Void, Void> {
        @Override
        protected Void doInBackground(UserHabit... userHabits) {
            habitsDb.userHabitDao().insert(userHabits[0]);
            return null;
        }
    }

    public void finishAddGoodHabit(View v) {
        AddGoodHabitActivity.this.finish();
    }
}