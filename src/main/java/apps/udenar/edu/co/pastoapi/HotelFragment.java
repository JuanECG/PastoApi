package apps.udenar.edu.co.pastoapi;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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
public class HotelFragment extends Fragment {

    ArrayList<Hotel> hotelArrayList = new ArrayList<>();
    private HotelAdapter hotelAdapter;
    private RecyclerView hotel_recycler_view;

    public HotelFragment()  {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hotel,container,false);
        hotel_recycler_view=v.findViewById(R.id.hotel_recycler_view);
        hotel_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
        getHotelResponse();
        return v;
    }

    private void getHotelResponse() {

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface requestInterface=retrofit.create(RequestInterface.class);
        Call<List<Hotel>> call=requestInterface.getHotelJson();

        call.enqueue(new Callback<List<Hotel>>() {
            @Override
            public void onResponse(Call<List<Hotel>> call, Response<List<Hotel>> response) {
                hotelArrayList= new ArrayList<>(response.body());
                hotelAdapter= new HotelAdapter(getContext(),hotelArrayList);
                hotel_recycler_view.setAdapter(hotelAdapter);

                hotelAdapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), HotelView.class);
                        Bundle b = new Bundle();
                        b.putSerializable("hotel",hotelArrayList.get(hotel_recycler_view.getChildAdapterPosition(v)));
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                Toast.makeText(getContext(),"Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Hotel>> call, Throwable t) {
                Toast.makeText(getContext(),"Failed",Toast.LENGTH_SHORT).show();
            }
        });

    }

}


