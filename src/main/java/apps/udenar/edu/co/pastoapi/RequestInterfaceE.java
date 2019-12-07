package apps.udenar.edu.co.pastoapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface RequestInterfaceE {
    @GET("8wbc-7c6p.json")
    Call<List<Evento>> getEventoJson();
}