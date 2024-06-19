package si.uni_lj.fe.tnuv.habitquesttnuv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.FaceClothe;
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.LowerClothe;
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.WeaponClothe;

public class WeaponClothe_RecycleViewAdapter extends RecyclerView.Adapter<WeaponClothe_RecycleViewAdapter.MyViewHolder>{
    Context context;
    ArrayList<WeaponClothe> weaponClotheModels;
    public WeaponClothe_RecycleViewAdapter(Context context, ArrayList<WeaponClothe> weaponClotheModels){
        this.context = context;
        this.weaponClotheModels = weaponClotheModels;
    }




    @NonNull
    @Override
    public WeaponClothe_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.weapon_clothe_recyclerview_row, parent, false);
        return new WeaponClothe_RecycleViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeaponClothe_RecycleViewAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(weaponClotheModels.get(position).getPictureId());
        holder.textView.setText(weaponClotheModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.weaponClotheModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView37);
        }
    }
}
