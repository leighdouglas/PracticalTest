package nyc.c4q.leighdouglas.practicaltest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leighdouglas on 12/11/16.
 */

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    List<Records> recordList;
    static String TAG = "TAG";

    public Adapter() {
        recordList = new ArrayList<>();
    }

    public Adapter(List<Records> recordList) {
        this.recordList = recordList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_viewholder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Records record = recordList.get(position);
        //Log.d(TAG, "onBindViewholder was successful");
        holder.bind(record);

    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }

    public void setRecordList(List<Records> mRecordList) {
        recordList.clear();
        recordList.addAll(mRecordList);
        notifyDataSetChanged();

    }


}

