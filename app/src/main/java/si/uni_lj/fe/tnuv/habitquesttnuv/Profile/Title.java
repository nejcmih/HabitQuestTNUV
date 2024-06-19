package si.uni_lj.fe.tnuv.habitquesttnuv.Profile;

public class Title {
    static int titleCount = 0;
    private int id;
    private String name;
    private String desc;
    private boolean unlocked;

    public Title(int id, String name, String desc, boolean unlocked) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.unlocked = false;
    }
    public Title(String name, String desc, boolean unlocked) {
        this.id = titleCount*5000 + 1;
        titleCount++;
        this.name = name;
        this.desc = desc;
        this.unlocked = false;
    }

    public static int getTitleCount() {
        return titleCount;
    }

    public static void setTitleCount(int titleCount) {
        Title.titleCount = titleCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }
}
