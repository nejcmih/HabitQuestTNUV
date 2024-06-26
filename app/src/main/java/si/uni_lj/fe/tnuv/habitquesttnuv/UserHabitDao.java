package si.uni_lj.fe.tnuv.habitquesttnuv;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserHabitDao {
    @Query("SELECT * FROM userhabit")
    List<UserHabit> getAll();

    @Query("SELECT * FROM userhabit WHERE id = :id")
    UserHabit getHabitById(int id);

    @Query("SELECT * FROM userhabit WHERE type = :type")
    List<UserHabit> getByType(String type);

    @Insert
    void insert(UserHabit userhabit);

    @Insert
    void insertAll(UserHabit... userhabits);

    @Delete
    void delete(UserHabit userhabit);

    @Query("SELECT title FROM userhabit WHERE id = :id")
    String getTitleById(int id);
}
