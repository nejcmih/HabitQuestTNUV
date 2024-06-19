package si.uni_lj.fe.tnuv.habitquesttnuv;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.FaceClothe;
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.UpperClothe;
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Player;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_face_recycle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_face_recycle extends Fragment implements RecyclerViewInterface{

    private RecyclerView recyclerView2;
    ArrayList<FaceClothe> faceClothes = new ArrayList<>();
    int[] faceClotheImages = {
            R.drawable.obraz,
            R.drawable.ph_face2,
            R.drawable.ph_face3,
            R.drawable.ph_face4,
            R.drawable.ph_face5
    };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_face_recycle() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_face_recycle.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_face_recycle newInstance(String param1, String param2) {
        fragment_face_recycle fragment = new fragment_face_recycle();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private void setUpFaceClothe(){
        String[] faceClotheNames = getResources().getStringArray(R.array.faceName);

        for(int i = 0; i<faceClotheNames.length; i++){
            faceClothes.add(new FaceClothe(faceClotheImages[i], faceClotheNames[i]));
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
        return inflater.inflate(R.layout.fragment_face_recycle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        setUpFaceClothe();

        recyclerView2 = view.findViewById(R.id.RecyclerFace);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //recyclerView2.setHasFixedSize(true);
        FaceClothe_RecycleViewAdapter adapter3 = new FaceClothe_RecycleViewAdapter(getContext(), faceClothes, this);
        recyclerView2.setAdapter(adapter3);
        adapter3.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        //klikanje na specific item
        System.out.println(faceClothes.get(position).getPictureId());
        Toast.makeText(this.getContext(), faceClothes.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}