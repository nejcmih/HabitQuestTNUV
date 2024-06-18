package si.uni_lj.fe.tnuv.habitquesttnuv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.UpperClothe;

public class UpperClothe_RecyclewViewAdapter extends RecyclerView.Adapter<UpperClothe_RecyclewViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<UpperClothe> upperClotheModels;

    public UpperClothe_RecyclewViewAdapter(Context context, ArrayList<UpperClothe> upperClotheModels){
        this.context = context;
        this.upperClotheModels = upperClotheModels;
    }
    @NonNull
    @Override
    public UpperClothe_RecyclewViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.upper_body_recyvlerview_row, parent, false);
        return new UpperClothe_RecyclewViewAdapter.MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull UpperClothe_RecyclewViewAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(upperClotheModels.get(position).getPictureId());

    }

    @Override
    public int getItemCount() {
        return this.upperClotheModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
