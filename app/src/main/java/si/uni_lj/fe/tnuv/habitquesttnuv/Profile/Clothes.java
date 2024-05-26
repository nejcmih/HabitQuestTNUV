package si.uni_lj.fe.tnuv.habitquesttnuv.Profile;

import android.icu.text.CaseMap;

import java.io.Console;
import java.util.HashMap;

import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.Clothe;
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.FaceClothe;
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.HairClothe;
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.LowerClothe;
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.SkinClothe;
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.UpperClothe;
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.WeaponClothe;

public class Clothes {
    //ta class bo imel slovar vseh oblacil, locen na tipe
    private HashMap<Integer, FaceClothe> faceMap;
    private HashMap<Integer, HairClothe> hairMap;
    private HashMap<Integer, LowerClothe> lowerMap;
    private HashMap<Integer, SkinClothe> skinMap;
    private HashMap<Integer, UpperClothe> upperMap;
    private HashMap<Integer, WeaponClothe> weaponMap;

    public Clothes(){
        this.faceMap = new HashMap<Integer, FaceClothe>();
        this.hairMap = new HashMap<Integer, HairClothe>();
        this.lowerMap = new HashMap<Integer, LowerClothe>();
        this.skinMap = new HashMap<Integer, SkinClothe>();
        this.upperMap = new HashMap<Integer, UpperClothe>();
        this.weaponMap = new HashMap<Integer, WeaponClothe>();
    }

    public void addClothe(Clothe obleka){
        //doda specific obleko na seznam pravega tipa;
        if(obleka instanceof FaceClothe){
            faceMap.putIfAbsent(obleka.getId(), (FaceClothe)obleka);
        } else if (obleka instanceof HairClothe) {
            hairMap.putIfAbsent(obleka.getId(), (HairClothe) obleka);
        } else if (obleka instanceof LowerClothe) {
            lowerMap.putIfAbsent(obleka.getId(), (LowerClothe) obleka);
        } else if (obleka instanceof SkinClothe) {
            skinMap.putIfAbsent(obleka.getId(), (SkinClothe) obleka);
        } else if (obleka instanceof UpperClothe) {
            upperMap.putIfAbsent(obleka.getId(), (UpperClothe)obleka);
        } else if (obleka instanceof WeaponClothe) {
            weaponMap.putIfAbsent(obleka.getId(), (WeaponClothe) obleka);
        } else{
            System.out.println("Funkcija addClothe ni nasla pravega tipa obleke za: " + obleka.getName());
        }
    }
}
