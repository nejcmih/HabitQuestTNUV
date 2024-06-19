package si.uni_lj.fe.tnuv.habitquesttnuv;

import static android.content.ContentValues.TAG;

import static si.uni_lj.fe.tnuv.habitquesttnuv.MainActivity.*;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GoodHabitFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GoodHabitFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GoodHabitFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GoodHabitFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GoodHabitFragment newInstance(String param1, String param2) {
        GoodHabitFragment fragment = new GoodHabitFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    //private UserHabitDatabase habitsDb;
    private ListView lv;
    private List<UserHabit> listGoodHabits;
    private UserHabitDatabase habitsDb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        habitsDb = UserHabitDatabase.getInstance(getContext());

        //new SelectUserGoodHabits().execute("good");

        /*
        new Thread() {
            @Override
            public void run() {
                getActivity().runOnUiThread(() -> showHabits());
            }
        }.start();
        */
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_good_habit, container, false);
        lv = view.findViewById(R.id.list);

        return view;
    }

    private void showHabits() {
        ArrayList<HashMap<String, String>> seznam = convertToArrayList(listGoodHabits);
        SimpleAdapter adapter = new SimpleAdapter(
                getContext(),
                seznam,
                R.layout.habit_item,
                new String[]{"title", "description", "focus"},
                new int[]{R.id.habitLabelTitle, R.id.habitLabelDesc, R.id.habitLabelAttr}
        );
        lv.setAdapter(adapter);
    }

    /** @noinspection deprecation*/
    private class SelectUserGoodHabits extends AsyncTask<String, Void, List<UserHabit>> {
        @Override
        protected List<UserHabit> doInBackground(String... types) {
            List<UserHabit> userHabits = habitsDb.userHabitDao().getByType(types[0]);
            Log.d(TAG, String.valueOf(userHabits.size()));
            return userHabits;
        }
        @Override
        protected void onPostExecute(List<UserHabit> userHabits) {
            super.onPostExecute(userHabits);

            //Collections.copy(listGoodHabits, userHabits);
        }
    }

    private class SelectUserGoodHabit extends AsyncTask<Integer, Void, UserHabit> {
        @Override
        protected UserHabit doInBackground(Integer... ids) {
            UserHabit userHabit = habitsDb.userHabitDao().getHabitById(ids[0]);
            Log.d(TAG, userHabit.toString());
            return userHabit;
        }
        @Override
        protected void onPostExecute(UserHabit userHabit) {
            super.onPostExecute(userHabit);
        }
    }

    private ArrayList<HashMap<String, String>> koncniSeznam = new ArrayList<>();
    public ArrayList<HashMap<String, String>> convertToArrayList(List<UserHabit> list) {
        for (int i = 0; i < list.size(); i++) {
            UserHabit habit = list.get(i);
            HashMap<String, String> temp = new HashMap<>();
            temp.put("title", habit.getTitle());
            temp.put("desc", habit.getDescription());
            temp.put("focus", habit.getFocus().toString());

            koncniSeznam.add(temp);
        }
        return koncniSeznam;
    }
}