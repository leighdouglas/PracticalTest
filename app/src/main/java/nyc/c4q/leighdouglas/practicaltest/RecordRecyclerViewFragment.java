package nyc.c4q.leighdouglas.practicaltest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leighdouglas on 12/11/16.
 */

public class RecordRecyclerViewFragment extends Fragment {
    private Adapter adapter;
    private RecyclerView recyclerView;
    private static final String TAG = "Retrofit";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.record_recyclerview_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.record_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);

        runRetrofitCall();

        return view;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void runRetrofitCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(VineService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VineService service = retrofit.create(VineService.class);
        Call<VinePojo> call = service.getCode();

        call.enqueue(new Callback<VinePojo>() {
            @Override
            public void onResponse(Call<VinePojo> call, Response<VinePojo> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "Success");
                        Log.d(TAG, Integer.toString(response.body().getData().getRecords().size()));
                        adapter.setRecordList(response.body().getData().getRecords());
                    } else {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<VinePojo> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        recyclerView.setAdapter(null);
    }
}
