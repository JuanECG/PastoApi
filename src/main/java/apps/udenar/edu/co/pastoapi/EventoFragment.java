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
public class EventoFragment extends Fragment {

    ArrayList<Evento> eventoArrayList = new ArrayList<>();
    private EventoAdapter eventoAdapter;
    private RecyclerView evento_recycler_view;

    public EventoFragment()  {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_evento,container,false);
        evento_recycler_view=v.findViewById(R.id.evento_recycler_view);
        evento_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
        getEventoResponse();
        return v;
    }

    private void getEventoResponse() {

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterfaceE requestInterfaceE =retrofit.create(RequestInterfaceE.class);
        Call<List<Evento>> call=requestInterfaceE.getEventoJson();

        call.enqueue(new Callback<List<Evento>>() {
            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
                eventoArrayList= new ArrayList<>(response.body());
                eventoAdapter= new EventoAdapter(getContext(),eventoArrayList);
                evento_recycler_view.setAdapter(eventoAdapter);

                eventoAdapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), EventoView.class);
                        Bundle b = new Bundle();
                        b.putSerializable("evento",eventoArrayList.get(evento_recycler_view.getChildAdapterPosition(v)));
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                Toast.makeText(getContext(),"Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {
                Toast.makeText(getContext(),"Failed",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
