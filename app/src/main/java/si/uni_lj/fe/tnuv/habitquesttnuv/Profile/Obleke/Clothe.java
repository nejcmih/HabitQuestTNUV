package si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke;
//to je parent class vseh oblacil
//Vsaki kos oblacila ima svoj tip, id, pictureId, ime in boolean ce je unlocked
public class Clothe {
    static int clotheCount = 0;
    private int id;
    private int pictureId; //id slikice
    private String name;
    private boolean unlocked;

    public Clothe(int id, int pictureId, String name) {
        this.id = id;
        this.id = 1000+clotheCount;
        this.pictureId = pictureId;
        this.name = name;
        this.unlocked = false;
    }

    public Clothe(int pictureId, String name) {
        clotheCount = clotheCount+1;
        this.id = 1000+clotheCount;
        this.pictureId = pictureId;
        this.name = name;
        this.unlocked = false;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPictureId() {
        return this.pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUnlocked() {
        return this.unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }
}
