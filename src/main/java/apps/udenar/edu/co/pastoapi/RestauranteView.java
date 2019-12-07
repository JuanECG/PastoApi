package apps.udenar.edu.co.pastoapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class RestauranteView extends AppCompatActivity {

    private TextView r_nombre,r_entidad,r_dir,r_correo,r_tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurante_view);

        r_nombre =findViewById(R.id.r_nombre);
        r_entidad = findViewById(R.id.r_entidad);
        r_dir = findViewById(R.id.r_dir);
        r_correo = findViewById(R.id.r_correo);
        r_tel =findViewById(R.id.r_tel);

        Bundle extras = getIntent().getExtras();

        Restaurante restaurante = (Restaurante) extras.getSerializable("restaurante");

        r_nombre.setText(restaurante.getNombre());
        r_entidad.setText(restaurante.getEntidadCargo());
        r_dir.setText(restaurante.getDireccion());
        r_correo.setText(restaurante.getCorreo());
        r_tel.setText(restaurante.getTelefono());

    }
}