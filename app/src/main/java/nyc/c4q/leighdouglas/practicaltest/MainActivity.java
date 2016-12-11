package nyc.c4q.leighdouglas.practicaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Retrofit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       runRetrofitCall();

    }

    public void runRetrofitCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(VineService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VineService service = retrofit.create(VineService.class);
        Call<ResponseBody> call = service.getJSONString();

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "Success");
                        Log.d(TAG, response.body().string());
                    } else {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

    }
}
