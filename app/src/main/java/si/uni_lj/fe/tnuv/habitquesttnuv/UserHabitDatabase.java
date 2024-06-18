package si.uni_lj.fe.tnuv.habitquesttnuv;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserHabit.class}, version = 1)
public abstract class UserHabitDatabase extends RoomDatabase {
    private static UserHabitDatabase instance;
    public abstract UserHabitDao userHabitDao();

    public static synchronized UserHabitDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            UserHabitDatabase.class, "habitquest_db")
                    .fallbackToDestructiveMigration()  // Handle migration if necessary
                    .build();
        }
        return instance;
    }
}
