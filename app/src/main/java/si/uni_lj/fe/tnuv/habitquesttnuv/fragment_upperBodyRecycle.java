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

import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.UpperClothe;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_upperBodyRecycle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_upperBodyRecycle extends Fragment {
    private RecyclerView recyclerView2;
        ArrayList<UpperClothe> upperBodyClothes = new ArrayList<>();
    int[] upperBodyClothesImages = {
            R.drawable.majica,
            R.drawable.ph_upper2,
            R.drawable.ph_upper3,
            R.drawable.ph_upper4,
            R.drawable.ph_upper5
    };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_upperBodyRecycle() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_upperBodyRecycle.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_upperBodyRecycle newInstance(String param1, String param2) {
        fragment_upperBodyRecycle fragment = new fragment_upperBodyRecycle();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
//                    RecyclerView recyclerView2 = findViewById(R.id.RecyclerUpper);
//            setUpUpperClothe();
//            UpperClothe_RecyclewViewAdapter adapter2 = new UpperClothe_RecyclewViewAdapter(this.getContext(), upperBodyClothes);
//            recyclerView2.setAdapter(adapter2);
//            recyclerView2.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

        private void setUpUpperClothe(){
        String[] upperClotheNames = getResources().getStringArray(R.array.upperClotheName);

        for(int i = 0; i<upperClotheNames.length; i++){
            upperBodyClothes.add(new UpperClothe(upperBodyClothesImages[i], upperClotheNames[i]));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upper_body_recycle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        setUpUpperClothe();

        recyclerView2 = view.findViewById(R.id.RecyclerUpper);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //recyclerView2.setHasFixedSize(true);
        UpperClothe_RecyclewViewAdapter adapter2 = new UpperClothe_RecyclewViewAdapter(getContext(), upperBodyClothes);
        recyclerView2.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();
    }
    
}