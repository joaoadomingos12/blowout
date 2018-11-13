package pt.whatever.blowout;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {



    private HashMap<Integer,Event> events;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCardView;
        public TextView date;
        public ImageView img;
        public TextView place;
        public TextView distance;
        public MyViewHolder(CardView v) {
            super(v);
            this.img=v.findViewById(R.id.imageView);
            this.place=v.findViewById(R.id.place);
            this.distance=v.findViewById(R.id.distance);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerAdapter(HashMap<Integer,Event> events) {
        this.events=events;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Event event = events.get(position);
        holder.date.setText(event.getDate());
        holder.distance.setText(event.getDistance());
        holder.img.setImageDrawable(event.getImgDrawable());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return events.size();
    }
}
