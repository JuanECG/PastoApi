package apps.udenar.edu.co.pastoapi;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.ViewHolder>
        implements View.OnClickListener{

    private ArrayList<Evento> eventos= new ArrayList<>();
    private View.OnClickListener listener;
    private Context context;


    public EventoAdapter(Context context, ArrayList<Evento> eventos){
        this.eventos=eventos;
        this.context=context;

    }

    @NonNull
    @Override
    public EventoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.evento_list_item
                ,viewGroup,false);
        view.setOnClickListener(this);
        return new EventoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventoAdapter.ViewHolder viewHolder, int position) {
        viewHolder.actividad.setText(eventos.get(position).getActividad());
        viewHolder.expresion.setText(eventos.get(position).getExpresiN());
        viewHolder.fecha.setText(eventos.get(position).getFecha());
        viewHolder.org.setText(eventos.get(position).getOrganizador());
        //viewHolder.contacto.setText(hotels.get(position).getContacto());

    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener !=null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView hotel_image;
        private TextView actividad,expresion,fecha,org;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //hotel_image=(ImageView)itemView.findViewById(R.id.hotel_image);
            actividad=(TextView)itemView.findViewById(R.id.evento_actividad);
            expresion=(TextView)itemView.findViewById(R.id.evento_expresion);
            fecha=(TextView)itemView.findViewById(R.id.evento_fecha);
            org=(TextView)itemView.findViewById(R.id.evento_org);
           // contacto=(TextView)itemView.findViewById(R.id.hotel_contacto);
        }
    }
}
