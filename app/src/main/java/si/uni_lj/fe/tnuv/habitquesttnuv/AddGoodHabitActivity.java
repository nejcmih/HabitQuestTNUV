package si.uni_lj.fe.tnuv.habitquesttnuv;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class AddGoodHabitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_good_habit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void saveGoodHabit(View v) {
        EditText vnosName = findViewById(R.id.editGoodName);
        EditText vnosDescription = findViewById(R.id.editGoodDesc);
        EditText vnosFocus = findViewById(R.id.editGoodFocus);
        EditText vnosXp = findViewById(R.id.editGoodXP);

        String name = vnosName.getText().toString();
        String description = vnosDescription.getText().toString();
        float focus = Float.parseFloat(vnosFocus.getText().toString());
        int xp = Integer.parseInt(vnosXp.getText().toString());

        String sestavljen = "\ntitle: " + name + "\ndescription: " + description + "\ntype: good" + "\nfocus: " + focus + "\nxp: " + xp + "\n";

        //Log.d(TAG, sestavljen);
        //vpisiVDatoteko(sestavljen);
        finishAddGoodHabit(v);
    }
    private void vpisiVDatoteko(String vsebina){

        try {
            //ustvarimo izhodni tok
            FileOutputStream os = openFileOutput("habits.txt", Context.MODE_PRIVATE | Context.MODE_APPEND);
            //zapisemo posredovano vsebino v datoteko
            os.write(vsebina.getBytes());
            //sprostimo izhodni tok
            os.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String beriIzDatoteke(){

        // ustvarimo vhodni podatkovni tok
        FileInputStream inputStream;

        //ugotovimo, koliko je velika datoteka
        File file = new File(getFilesDir(), "habits.txt");
        int length = (int) file.length();

        //pripravimo spremenljivko, v katero se bodo prebrali podatki
        byte[] bytes = new byte[length];

        //preberemo podatke
        try {
            inputStream = openFileInput("habits.txt");
            inputStream.read(bytes);
            inputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //podatke pretvorimo iz polja bajtov v znakovni niz
        String vsebina = new String(bytes);

        return vsebina;
    }


    public void finishAddGoodHabit(View v) {
        AddGoodHabitActivity.this.finish();
    }
}