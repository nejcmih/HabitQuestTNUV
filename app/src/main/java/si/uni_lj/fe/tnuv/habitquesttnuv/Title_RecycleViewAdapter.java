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

import si.uni_lj.fe.tnuv.habitquesttnuv.Profile.Title;

public class Title_RecycleViewAdapter extends RecyclerView.Adapter<Title_RecycleViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<Title> titleModels;
    public Title_RecycleViewAdapter(Context context, ArrayList<Title> titleModels){
        this.context = context;
        this.titleModels = titleModels;
    }

    @NonNull
    @Override
    public Title_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.title_recyclerview_row, parent, false);
        return new Title_RecycleViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Title_RecycleViewAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(titleModels.get(position).getName());
        holder.textView2.setText(titleModels.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return this.titleModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView2;
        TextView textView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView2 = itemView.findViewById(R.id.titleDescView);
            textView = itemView.findViewById(R.id.titleNameView);
        }
    }

}
