package nyc.c4q.leighdouglas.practicaltest;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by leighdouglas on 12/11/16.
 */

public interface VineService {
    String BASE_URL = "http://www.vine.co/";

    @GET("api/timelines/users/918753190470619136")
    Call<VinePojo> getCode();

}

