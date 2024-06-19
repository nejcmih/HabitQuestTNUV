package si.uni_lj.fe.tnuv.habitquesttnuv.Profile;

import java.util.HashSet;
import java.util.TreeSet;

public class Player {
    private String username;
    private int streak;
    private int level;
    private int xp;
    private int xpToLevel;
    private String chosenTitle;
    private TreeSet<String> titles;
    private float currentFocus;
    private float maxFocus;
    private int currentHealth;
    private int maxHealh;
    private int[] izbiraObleke; //0 = koza, 1 = obraz, 2 = lasje, 3 = zgornjaObleka, 4 = spodnjaObleka, 5 = orozje

    public Player(String username){
        //inicializacija profila
        this.username = username;
        this.streak = 0;
        this.level = 1;
        this.xp = 0;
        this.xpToLevel = level*5; //TODO: Dodaj bolj natancno xp scaling
        this.chosenTitle = "Beginner";
        this.titles = new TreeSet<String>();
        titles.add("Beginner");
        this.currentFocus = 10;
        this.maxFocus = 10;
        this.currentHealth = 100;
        this.maxHealh = 100; //TODO: Health malo drugačne vrednosti?
        this.izbiraObleke = new int[]{0, 0, 0, 0, 0, 0};
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStreak() {
        return this.streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return this.xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXpToLevel() {
        return this.xpToLevel;
    }

    public void setXpToLevel(int xpToLevel) {
        this.xpToLevel = xpToLevel;
    }

    public String getChosenTitle() {
        return this.chosenTitle;
    }

    public void setChosenTitle(String chosenTitle) {
        this.chosenTitle = chosenTitle;
    }

    public TreeSet<String> getTitles() {
        return this.titles;
    }

    public void setTitles(TreeSet<String> titles) {
        this.titles = titles;
    }

    public float getCurrentFocus() {
        return this.currentFocus;
    }

    public void setCurrentFocus(float currentFocus) {
        this.currentFocus = currentFocus;
    }

    public float getMaxFocus() {
        return this.maxFocus;
    }

    public void setMaxFocus(int maxFocus) {
        this.maxFocus = maxFocus;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealh() {
        return this.maxHealh;
    }

    public void setMaxHealh(int maxHealh) {
        this.maxHealh = maxHealh;
    }

    public int[] getIzbiraObleke() {
        return this.izbiraObleke;
    }

    public void setIzbiraObleke(int[] izbiraObleke) {
        this.izbiraObleke = izbiraObleke;
    }
}
