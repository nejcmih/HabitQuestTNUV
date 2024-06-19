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

public class LowerClothe_RecycleViewAdapter extends RecyclerView.Adapter<LowerClothe_RecycleViewAdapter.MyViewHolder>{
    Context context;
    ArrayList<LowerClothe> lowerClotheModels;
    public LowerClothe_RecycleViewAdapter(Context context, ArrayList<LowerClothe> lowerClotheModels){
        this.context = context;
        this.lowerClotheModels = lowerClotheModels;
    }




    @NonNull
    @Override
    public LowerClothe_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lower_clothe_recyclerview_row, parent, false);
        return new LowerClothe_RecycleViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LowerClothe_RecycleViewAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(lowerClotheModels.get(position).getPictureId());
        holder.textView.setText(lowerClotheModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.lowerClotheModels.size();
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
