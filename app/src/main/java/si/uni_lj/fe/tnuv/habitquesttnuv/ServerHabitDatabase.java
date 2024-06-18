package si.uni_lj.fe.tnuv.habitquesttnuv;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ServerHabit.class}, version = 2)
public abstract class ServerHabitDatabase extends RoomDatabase {
    private static ServerHabitDatabase instance;
    public abstract ServerHabitDao serverHabitDao();

    public static synchronized ServerHabitDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            ServerHabitDatabase.class, "habitquest_db")
                    .fallbackToDestructiveMigration()  // Handle migration if necessary
                    .build();
        }
        return instance;
    }
}
