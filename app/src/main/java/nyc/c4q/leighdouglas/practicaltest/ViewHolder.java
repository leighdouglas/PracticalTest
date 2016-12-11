package nyc.c4q.leighdouglas.practicaltest;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by leighdouglas on 12/11/16.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    String TAG = "TAG";
    View mView;
    private TextView likes;
    private TextView username;
    private CardView recordBackground;

    public ViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        likes = (TextView) mView.findViewById(R.id.likes);
        username = (TextView) mView.findViewById(R.id.username);
        recordBackground = (CardView) mView.findViewById(R.id.record_view);

    }

    public void bind(final Records record) {
        Log.d(TAG, "this worked");
        if (record.checkRespost()) {
            username.setText("username: " + record.getRepost().getUser().getUsername());
        }
        likes.setText("liked: " + Integer.toString(record.getLiked()));

        if(record.checkForProfileBackground()){
            String color = record.getProfileBackground().substring(2);
            recordBackground.setBackgroundColor(Color.parseColor("#" + color));
        } else {
            String color = record.getRepost().getProfileBackgroundColor().substring(2);
            recordBackground.setCardBackgroundColor(Color.parseColor("#"+color));
        }

    }
}
