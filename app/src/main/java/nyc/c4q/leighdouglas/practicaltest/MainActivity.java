package nyc.c4q.leighdouglas.practicaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Adapter adapter;
    private RecyclerView recyclerView;
    private static final String TAG = "Retrofit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.record_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);

        runRetrofitCall();

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
}
