 package com.example.himsrana.recycller2;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

 public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private int[] images;
    final private ListItemClickListener mOnClickListener;
    private final String TAG = this.getClass().getSimpleName();

    public ImageAdapter(int[] images, ListItemClickListener listener) {
        this.images = images;
        mOnClickListener = listener;
    }

     public String getTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String currentTime = dateFormat.format(calendar.getTime());
        return currentTime;

     }

     public interface ListItemClickListener {
        void onListItemClickListener(int clickedItemIndex);
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.image_item,parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int imageId = images[position];
        holder.bind(imageId,position, getTime());
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView profile;
        TextView sampleName;
        TextView sampleMessage;
        TextView time;

        public ImageViewHolder(View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile);
            sampleName = itemView.findViewById(R.id.name);
            sampleMessage = itemView.findViewById(R.id.message);
            time = itemView.findViewById(R.id.time);
        }

        public void bind(int imageId, int listIndex, String currentTime) {
            profile.setImageResource(imageId);
            sampleName.setText("Name at :" + listIndex);
            sampleMessage.setText("Message at: "+ listIndex);
            time.setText(currentTime);
        }

        @Override
        public void onClick(View view) {
            int clickedItemPosition = getAdapterPosition();
            mOnClickListener.onListItemClickListener(clickedItemPosition);
        }
    }
}

