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

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder>
        implements View.OnClickListener{

    private ArrayList<Restaurante> restaurantes= new ArrayList<>();
    private View.OnClickListener listener;
    private Context context;


    public RestauranteAdapter(Context context, ArrayList<Restaurante> restaurantes){
        this.restaurantes=restaurantes;
        this.context=context;

    }

    @NonNull
    @Override
    public RestauranteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurante_list_item
                ,viewGroup,false);
        view.setOnClickListener(this);
        return new RestauranteAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestauranteAdapter.ViewHolder viewHolder, int position) {
        viewHolder.nombre.setText(restaurantes.get(position).getNombre());
        viewHolder.entidad.setText(restaurantes.get(position).getEntidadCargo());
        viewHolder.dir.setText(restaurantes.get(position).getDireccion());
        //viewHolder.correo.setText(restaurantes.get(position).getCorreo());
        viewHolder.contacto.setText(restaurantes.get(position).getTelefono());

    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
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
           // hotel_image=(ImageView)itemView.findViewById(R.id.hotel_image);
            nombre=(TextView)itemView.findViewById(R.id.restaurante_nombre);
            entidad=(TextView)itemView.findViewById(R.id.restaurante_entidad);
            dir=(TextView)itemView.findViewById(R.id.restaurante_dir);
            //correo=(TextView)itemView.findViewById(R.id.restaurante_correo);
            contacto=(TextView)itemView.findViewById(R.id.restaurante_contacto);
        }
    }
}
