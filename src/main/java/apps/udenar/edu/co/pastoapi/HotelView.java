package apps.udenar.edu.co.pastoapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class HotelView extends AppCompatActivity {

    private TextView h_nombre,h_entidad,h_dir,h_correo,h_contacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_view);

        h_nombre =(TextView) findViewById(R.id.h_nombre);
        h_entidad =(TextView) findViewById(R.id.h_entidad);
        h_dir =(TextView) findViewById(R.id.h_dir);
        h_correo =(TextView) findViewById(R.id.h_correo);
        h_contacto =(TextView) findViewById(R.id.h_contacto);

        Bundle extras = getIntent().getExtras();

        Hotel hotel = (Hotel) extras.getSerializable("hotel");

        h_nombre.setText(hotel.getNombre());
        h_entidad.setText(hotel.getEntidadCargo());
        h_dir.setText(hotel.getDireccion());
        h_correo.setText(hotel.getCorreo());
        h_contacto.setText(hotel.getContacto());

    }
}
