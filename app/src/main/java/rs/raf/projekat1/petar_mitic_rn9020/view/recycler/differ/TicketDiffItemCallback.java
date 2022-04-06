package rs.raf.projekat1.petar_mitic_rn9020.view.recycler.differ;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import rs.raf.projekat1.petar_mitic_rn9020.models.Ticket;

public class TicketDiffItemCallback extends DiffUtil.ItemCallback<Ticket> {
    @Override
    public boolean areItemsTheSame(@NonNull Ticket oldItem, @NonNull Ticket newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Ticket oldItem, @NonNull Ticket newItem) {
        return oldItem.getDays() == (newItem.getDays())
                && oldItem.getTitle().equals(newItem.getTitle())
                && oldItem.getDescription().equals(newItem.getDescription())
                && oldItem.getType().equals(newItem.getType())
                && oldItem.getPriority().equals(newItem.getPriority())
                && oldItem.getState().equals(newItem.getState());
    }
}
