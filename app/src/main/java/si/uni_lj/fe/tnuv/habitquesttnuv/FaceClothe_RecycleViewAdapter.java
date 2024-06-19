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
import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Obleke.UpperClothe;

public class FaceClothe_RecycleViewAdapter extends RecyclerView.Adapter<FaceClothe_RecycleViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<FaceClothe> faceClotheModels;

    public FaceClothe_RecycleViewAdapter(Context context, ArrayList<FaceClothe> faceClotheModels, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.faceClotheModels = faceClotheModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }
    @NonNull
    @Override
    public FaceClothe_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.face_clothe_recyclerview_row, parent, false);
        return new FaceClothe_RecycleViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull FaceClothe_RecycleViewAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(faceClotheModels.get(position).getPictureId());
        holder.textView.setText(faceClotheModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.faceClotheModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;


        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView37);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
