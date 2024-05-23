package si.uni_lj.fe.tnuv.habitquesttnuv;

public class Habit {
    private int id;
    private String title;
    private float difficulty;
    private int maxProgress;
    private int progress;
    private int dayBeforeDecay;
    private boolean done;
    //TODO: A se naj rewards doda tu ali je tipHabita specific?

    public Habit(String title, float difficulty, int maxProgress){
        this.title = title;
        this.difficulty = difficulty;
        this.maxProgress = maxProgress;
        this.id = 1; //TODO: Ob konstruktu naj preveri v databazi kaj je id od prejsnjega habit in da +1 (da bodo po id-jih in sequence
        this.progress = 0;
        this.dayBeforeDecay = 30; //TODO: To bova pol dolocala, do torka se ne rabiva
        this.done = false;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(float difficulty) {
        this.difficulty = difficulty;
    }

    public int getMaxProgress() {
        return this.maxProgress;
    }

    public void setMaxProgress(int maxProgress) {
        this.maxProgress = maxProgress;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getDayBeforeDecay() {
        return this.dayBeforeDecay;
    }

    public void setDayBeforeDecay(int dayBeforeDecay) {
        this.dayBeforeDecay = dayBeforeDecay;
    }

    public boolean isDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
