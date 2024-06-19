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

import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.HairClothe;
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.LowerClothe;

public class HairClothe_RecycleViewAdapter extends RecyclerView.Adapter<HairClothe_RecycleViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<HairClothe> hairClotheModels;
    public HairClothe_RecycleViewAdapter(Context context, ArrayList<HairClothe> hairClotheModels){
        this.context = context;
        this.hairClotheModels = hairClotheModels;
    }

    @NonNull
    @Override
    public HairClothe_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.hair_clothe_recyclerview_row, parent, false);
        return new HairClothe_RecycleViewAdapter.MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull HairClothe_RecycleViewAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(hairClotheModels.get(position).getPictureId());
        holder.textView.setText(hairClotheModels.get(position).getName());
    }
    @Override
    public int getItemCount() {
        return this.hairClotheModels.size();
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
