package apps.udenar.edu.co.pastoapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class EventoView extends AppCompatActivity {

    private TextView e_actividad,e_fecha,e_exp,e_ambito,e_org,e_equip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evento_view);

        e_actividad=findViewById(R.id.e_actividad);
        e_fecha= findViewById(R.id.e_fecha);
        e_exp = findViewById(R.id.e_exp);
        e_ambito = findViewById(R.id.e_ambito);
        e_org =findViewById(R.id.e_org);
        e_equip= findViewById(R.id.e_equip);

        Bundle extras = getIntent().getExtras();

        Evento evento = (Evento) extras.getSerializable("evento");

        e_actividad.setText(evento.getActividad());
        e_fecha.setText(evento.getFecha());
        e_exp.setText(evento.getExpresiN());
        e_ambito.setText(evento.getMbito());
        e_org.setText(evento.getOrganizador());
        e_equip.setText(evento.getEquipamiento());
    }
}