package si.uni_lj.fe.tnuv.habitquesttnuv;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DejanskiCustomiseActivity extends AppCompatActivity {
    private ImageButton btnEna, btnDva, btnTri, btnStiri, btnPet, btnSest;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dejanskicustomise);
        replaceFragment(new fragment_face_recycle());
        FragmentManager fragmentManager = getSupportFragmentManager();

        this.btnEna = findViewById(R.id.imageView17);
        this.btnDva = findViewById(R.id.imageView16);
        this.btnTri = findViewById(R.id.imageView3);
        this.btnStiri = findViewById(R.id.imageView18);
        this.btnPet = findViewById(R.id.imageView2);
        this.btnSest = findViewById(R.id.imageView4);
        this.btnEna.setBackgroundColor(getResources().getColor(R.color.yellow));
        this.btnEna.setOnClickListener(new EnaClickListener(this.btnEna, this.btnDva, this.btnTri, this.btnStiri, this.btnPet, this.btnSest, fragmentManager));
        this.btnDva.setOnClickListener(new DvaClickListener(this.btnEna, this.btnDva, this.btnTri, this.btnStiri, this.btnPet, this.btnSest, fragmentManager));
        this.btnTri.setOnClickListener(new TriClickListener(this.btnEna, this.btnDva, this.btnTri, this.btnStiri, this.btnPet, this.btnSest, fragmentManager));
        this.btnStiri.setOnClickListener(new StiriClickListener(this.btnEna, this.btnDva, this.btnTri, this.btnStiri, this.btnPet, this.btnSest, fragmentManager));
        this.btnPet.setOnClickListener(new PetClickListener(this.btnEna, this.btnDva, this.btnTri, this.btnStiri, this.btnPet, this.btnSest, fragmentManager));
        this.btnSest.setOnClickListener(new SestClickListener(this.btnEna, this.btnDva, this.btnTri, this.btnStiri, this.btnPet, this.btnSest, fragmentManager));






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



//        RecyclerView recyclerView2 = findViewById(R.id.RecyclerUpper);
//        setUpUpperClothe();
//        UpperClothe_RecyclewViewAdapter adapter2 = new UpperClothe_RecyclewViewAdapter(this, upperBodyClothes);
//        recyclerView2.setAdapter(adapter2);
//        recyclerView2.setLayoutManager(new LinearLayoutManager(this));


    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment);
        fragmentTransaction.commit();
    }


    private class EnaClickListener implements View.OnClickListener {
        private ImageButton btnEna, btnDva, btnTri, btnStiri, btnPet, btnSest;
        private FragmentManager fragmentManager;
        EnaClickListener(ImageButton btnEna, ImageButton btnDva, ImageButton btnTri, ImageButton btnStiri, ImageButton btnPet, ImageButton btnSest, FragmentManager fragmentManager){
            super();
            this.fragmentManager = fragmentManager;
            this.btnEna = btnEna;
            this.btnDva = btnDva;
            this.btnTri = btnTri;
            this.btnStiri = btnStiri;
            this.btnPet = btnPet;
            this.btnSest = btnSest;

        }
        @Override
        public void onClick(View v) {
            Log.v("gumbi", "Button 1 clicked");
            this.btnEna.setBackgroundColor(getResources().getColor(R.color.yellow));
            // Additional logic for button 1
            this.fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView2, fragment_face_recycle.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("name")
                    .commit();
            this.btnDva.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnTri.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnStiri.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnPet.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnSest.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    private class DvaClickListener implements View.OnClickListener {
        private ImageButton btnEna, btnDva, btnTri, btnStiri, btnPet, btnSest;
        private FragmentManager fragmentManager;
        DvaClickListener(ImageButton btnEna, ImageButton btnDva, ImageButton btnTri, ImageButton btnStiri, ImageButton btnPet, ImageButton btnSest, FragmentManager fragmentManager){
            super();
            this.fragmentManager = fragmentManager;
            this.btnEna = btnEna;
            this.btnDva = btnDva;
            this.btnTri = btnTri;
            this.btnStiri = btnStiri;
            this.btnPet = btnPet;
            this.btnSest = btnSest;

        }
        @Override
        public void onClick(View v) {
            Log.v("gumbi", "Button 1 clicked");
            this.btnDva.setBackgroundColor(getResources().getColor(R.color.yellow));
            // Additional logic for button 1
            this.fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView2, fragment_hair_clothe_recycle.class, null)
                    .setReorderingAllowed(true)
//                    .addToBackStack("name")
                    .commit();
            this.btnEna.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnTri.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnStiri.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnPet.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnSest.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }


    private class TriClickListener implements View.OnClickListener {
        private ImageButton btnEna, btnDva, btnTri, btnStiri, btnPet, btnSest;
        private FragmentManager fragmentManager;
        TriClickListener(ImageButton btnEna, ImageButton btnDva, ImageButton btnTri, ImageButton btnStiri, ImageButton btnPet, ImageButton btnSest, FragmentManager fragmentManager){
            super();
            this.fragmentManager = fragmentManager;
            this.btnEna = btnEna;
            this.btnDva = btnDva;
            this.btnTri = btnTri;
            this.btnStiri = btnStiri;
            this.btnPet = btnPet;
            this.btnSest = btnSest;

        }
        @Override
        public void onClick(View v) {
            Log.v("gumbi", "Button 1 clicked");
            this.btnTri.setBackgroundColor(getResources().getColor(R.color.yellow));
            // Additional logic for button 1
            this.fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView2, fragment_skin_clothe_recycle.class, null)
                    .setReorderingAllowed(true)
//                    .addToBackStack("name")
                    .commit();
            this.btnDva.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnEna.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnStiri.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnPet.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnSest.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }


    private class StiriClickListener implements View.OnClickListener {
        private ImageButton btnEna, btnDva, btnTri, btnStiri, btnPet, btnSest;
        private FragmentManager fragmentManager;
        StiriClickListener(ImageButton btnEna, ImageButton btnDva, ImageButton btnTri, ImageButton btnStiri, ImageButton btnPet, ImageButton btnSest, FragmentManager fragmentManager){
            super();
            this.fragmentManager = fragmentManager;
            this.btnEna = btnEna;
            this.btnDva = btnDva;
            this.btnTri = btnTri;
            this.btnStiri = btnStiri;
            this.btnPet = btnPet;
            this.btnSest = btnSest;

        }
        @Override
        public void onClick(View v) {
            Log.v("gumbi", "Button 1 clicked");
            this.btnStiri.setBackgroundColor(getResources().getColor(R.color.yellow));
            // Additional logic for button 1
            this.fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView2, fragment_upperBodyRecycle.class, null)
                    .setReorderingAllowed(true)
//                    .addToBackStack("name")
                    .commit();
            this.btnEna.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnTri.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnDva.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnPet.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnSest.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    private class PetClickListener implements View.OnClickListener {
        private ImageButton btnEna, btnDva, btnTri, btnStiri, btnPet, btnSest;
        private FragmentManager fragmentManager;
        PetClickListener(ImageButton btnEna, ImageButton btnDva, ImageButton btnTri, ImageButton btnStiri, ImageButton btnPet, ImageButton btnSest, FragmentManager fragmentManager){
            super();
            this.fragmentManager = fragmentManager;
            this.btnEna = btnEna;
            this.btnDva = btnDva;
            this.btnTri = btnTri;
            this.btnStiri = btnStiri;
            this.btnPet = btnPet;
            this.btnSest = btnSest;

        }
        @Override
        public void onClick(View v) {
            Log.v("gumbi", "Button 1 clicked");
            this.btnPet.setBackgroundColor(getResources().getColor(R.color.yellow));
            // Additional logic for button 1
            this.fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView2, fragment_lower_clothe_recycle.class, null)
                    .setReorderingAllowed(true)
//                    .addToBackStack("name")
                    .commit();
            this.btnEna.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnTri.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnStiri.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnDva.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnSest.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    private class SestClickListener implements View.OnClickListener {
        private ImageButton btnEna, btnDva, btnTri, btnStiri, btnPet, btnSest;
        private FragmentManager fragmentManager;
        SestClickListener(ImageButton btnEna, ImageButton btnDva, ImageButton btnTri, ImageButton btnStiri, ImageButton btnPet, ImageButton btnSest, FragmentManager fragmentManager){
            super();
            this.fragmentManager = fragmentManager;
            this.btnEna = btnEna;
            this.btnDva = btnDva;
            this.btnTri = btnTri;
            this.btnStiri = btnStiri;
            this.btnPet = btnPet;
            this.btnSest = btnSest;

        }
        @Override
        public void onClick(View v) {
            Log.v("gumbi", "Button 1 clicked");
            this.btnSest.setBackgroundColor(getResources().getColor(R.color.yellow));
            // Additional logic for button 1
            this.fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView2, fragment_weapon_clothe_recycle.class, null)
                    .setReorderingAllowed(true)
//                    .addToBackStack("name")
                    .commit();
            this.btnEna.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnTri.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnStiri.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnPet.setBackgroundColor(getResources().getColor(R.color.white));
            this.btnDva.setBackgroundColor(getResources().getColor(R.color.white));
        }


    }
    public void start_pojdiVCustomClothes(View v){
        Intent intent = new Intent(this, CustomClothesActivity.class);
        startActivity(intent);

    }
}
