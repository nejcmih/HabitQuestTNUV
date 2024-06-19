package si.uni_lj.fe.tnuv.habitquesttnuv;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ServerHabitDao {
    @Query("SELECT * FROM serverhabit")
    List<ServerHabit> getAll();

    @Insert
    void insert(ServerHabit serverhabit);

    @Insert
    void insertAll(ServerHabit... serverhabits);

    @Delete
    void delete(ServerHabit serverhabit);

    @Query("DELETE FROM serverhabit")
    void deleteAllHabits();

    @Query("SELECT title FROM serverhabit WHERE id = :id")
    String getTitleById(int id);
}
