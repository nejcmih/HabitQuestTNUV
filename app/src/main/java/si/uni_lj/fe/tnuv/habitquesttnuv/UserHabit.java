package si.uni_lj.fe.tnuv.habitquesttnuv;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userhabit")
public class UserHabit {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "focus")
    private Double focus;

    @ColumnInfo(name = "hp")
    private Double hp;

    @ColumnInfo(name = "xp")
    private Integer xp;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Double getFocus() {
        return focus;
    }
    public void setFocus(Double focus) {
        this.focus = focus;
    }
    public Double getHp() {
        return hp;
    }
    public void setHp(Double hp) {
        this.hp = hp;
    }
    public Integer getXp() {
        return xp;
    }
    public void setXp(Integer xp) {
        this.xp = xp;
    }

}

