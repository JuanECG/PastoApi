package apps.udenar.edu.co.pastoapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder>
        implements View.OnClickListener{

    private ArrayList<Hotel> hotels= new ArrayList<>();
    private View.OnClickListener listener;
    private Context context;


    public HotelAdapter(Context context, ArrayList<Hotel> hotels){
        this.hotels=hotels;
        this.context=context;

    }

    @NonNull
    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hotel_list_item
                ,viewGroup,false);
        view.setOnClickListener(this);
        return new HotelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelAdapter.ViewHolder viewHolder, int position) {
        viewHolder.nombre.setText(hotels.get(position).getNombre());
        viewHolder.entidad.setText(hotels.get(position).getEntidadCargo());
        viewHolder.dir.setText(hotels.get(position).getDireccion());
        // viewHolder.correo.setText(hotels.get(position).getCorreo());
        viewHolder.contacto.setText(hotels.get(position).getContacto());

    }

    @Override
    public int getItemCount() {
        return hotels.size();
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
        private TextView nombre,entidad,dir,correo,contacto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hotel_image=(ImageView)itemView.findViewById(R.id.hotel_image);
            nombre=(TextView)itemView.findViewById(R.id.hotel_nombre);
            entidad=(TextView)itemView.findViewById(R.id.hotel_entidad);
            dir=(TextView)itemView.findViewById(R.id.hotel_dir);
            //correo=(TextView)itemView.findViewById(R.id.hotel_correo);
            contacto=(TextView)itemView.findViewById(R.id.hotel_contacto);
        }
    }
}
