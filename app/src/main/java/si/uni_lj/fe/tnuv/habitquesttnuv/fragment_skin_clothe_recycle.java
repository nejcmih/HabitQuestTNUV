package si.uni_lj.fe.tnuv.habitquesttnuv;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.LowerClothe;
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.SkinClothe;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_skin_clothe_recycle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_skin_clothe_recycle extends Fragment {
    private RecyclerView recyclerView2;
    ArrayList<SkinClothe> skinClothes = new ArrayList<>();
    int[] skinClotheImages={
            R.drawable.koza,
            R.drawable.ph_skin2,
            R.drawable.ph_skin3,
            R.drawable.ph_skin4,
            R.drawable.ph_skin5,
    };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_skin_clothe_recycle() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_skin_clothe_recycle.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_skin_clothe_recycle newInstance(String param1, String param2) {
        fragment_skin_clothe_recycle fragment = new fragment_skin_clothe_recycle();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private void setUpSkinClothe(){
        String[] skinClotheNames = getResources().getStringArray(R.array.skinClotheName);

        for(int i = 0; i<skinClotheNames.length; i++){
            skinClothes.add(new SkinClothe(skinClotheImages[i], skinClotheNames[i]));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skin_clothe_recycle, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        setUpSkinClothe();

        recyclerView2 = view.findViewById(R.id.RecyclerSkin);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //recyclerView2.setHasFixedSize(true);
        SkinClothe_RecycleViewAdapter adapter6 = new SkinClothe_RecycleViewAdapter(getContext(), skinClothes);
        recyclerView2.setAdapter(adapter6);
        adapter6.notifyDataSetChanged();
    }
}