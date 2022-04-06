package rs.raf.projekat1.petar_mitic_rn9020.view.recycler.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import rs.raf.projekat1.petar_mitic_rn9020.R;
import rs.raf.projekat1.petar_mitic_rn9020.models.Ticket;

public class DoneAdapter extends ListAdapter<Ticket, DoneAdapter.ViewHolder> {

    public DoneAdapter(@NonNull DiffUtil.ItemCallback<Ticket> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.done_list_item, parent, false);
        return new ViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ticket ticket = getItem(position);
        holder.bind(ticket);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private Context context;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
        }

        public void bind(Ticket ticket){
            ImageView imageView = itemView.findViewById(R.id.doneIv1);
            imageView.setBackgroundColor(Color.GRAY);
//            if(ticket.getType().equalsIgnoreCase("bug")) {
//                Glide
//                        .with(context)
//                        .load( "https://previews.123rf.com/images/eljanstock/eljanstock1811/eljanstock181108567/111612385-.jpg")
//                        .into(imageView);
//            }else{
//                Glide
//                        .with(context)
//                        .load("https://i.pinimg.com/originals/be/89/8c/be898cd1192d1f0847a0f4c1bb087fb9.png")
//                        .into(imageView);
//            }
            Glide
                    .with(context)
                    .load( "https://previews.123rf.com/images/eljanstock/eljanstock1811/eljanstock181108567/111612385-.jpg")
                    .into(imageView);
            ((TextView)itemView.findViewById(R.id.done_title)).setText(ticket.getTitle());
            ((TextView)itemView.findViewById(R.id.done_description)).setText(ticket.getDescription());
        }
    }

}
