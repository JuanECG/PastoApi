package apps.udenar.edu.co.pastoapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface RequestInterfaceR {
    @GET("sym6-cfhq.json")
    Call<List<Restaurante>> getRestauranteJson();
}