package nyc.c4q.leighdouglas.practicaltest;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by leighdouglas on 12/11/16.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    String TAG = "TAG";
    View mView;
    private TextView likes;
    private TextView username;

    public ViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        likes = (TextView) mView.findViewById(R.id.likes);
        username = (TextView) mView.findViewById(R.id.username);

    }

    public void bind(final Records record) {
        //Log.d(TAG, "this worked");
        //likes.setText(Integer.toString(record.getLiked()));
    }
}
