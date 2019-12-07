package apps.udenar.edu.co.pastoapi;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestauranteFragment extends Fragment {

    ArrayList<Restaurante> restauranteArrayList = new ArrayList<>();
    private RestauranteAdapter restauranteAdapter;
    private RecyclerView restaurante_recycler_view;

    public RestauranteFragment()  {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_restaurante,container,false);
        restaurante_recycler_view=v.findViewById(R.id.restaurante_recycler_view);
        restaurante_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
        getHotelResponse();
        return v;
    }

    private void getHotelResponse() {

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterfaceR requestInterfaceR=retrofit.create(RequestInterfaceR.class);
        Call<List<Restaurante>> call= requestInterfaceR.getRestauranteJson();

        call.enqueue(new Callback<List<Restaurante>>() {
            @Override
            public void onResponse(Call<List<Restaurante>> call, Response<List<Restaurante>> response) {
                restauranteArrayList= new ArrayList<>(response.body());
                restauranteAdapter= new RestauranteAdapter(getContext(),restauranteArrayList);
                restaurante_recycler_view.setAdapter(restauranteAdapter);

                restauranteAdapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), RestauranteView.class);
                        Bundle b = new Bundle();
                        b.putSerializable("restaurante",restauranteArrayList.get(restaurante_recycler_view.getChildAdapterPosition(v)));
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                Toast.makeText(getContext(),"Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Restaurante>> call, Throwable t) {
                Toast.makeText(getContext(),"Failed",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
