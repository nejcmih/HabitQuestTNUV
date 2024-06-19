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
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.SkinClothe;

public class SkinClothe_RecycleViewAdapter extends RecyclerView.Adapter<SkinClothe_RecycleViewAdapter.MyViewHolder>{
    Context context;
    ArrayList<SkinClothe> skinClotheModels;
    public SkinClothe_RecycleViewAdapter(Context context, ArrayList<SkinClothe> skinClotheModels){
        this.context = context;
        this.skinClotheModels = skinClotheModels;
    }




    @NonNull
    @Override
    public SkinClothe_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.skin_clothe_recyclerview_row, parent, false);
        return new SkinClothe_RecycleViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkinClothe_RecycleViewAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(skinClotheModels.get(position).getPictureId());
        holder.textView.setText(skinClotheModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.skinClotheModels.size();
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
