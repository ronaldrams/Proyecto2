package com.rrmtechnology.ronald.proyecto1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mostrar_datos extends AppCompatActivity {


    TextView tv1 , tv2telefono , tv3email, tv4descripcion , recibirfecha ;
    Button beditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        beditar = (Button) findViewById(R.id.botoneditar);

        recibirfecha = (TextView) findViewById(R.id.tvfecha);
        String Fecha = getIntent().getStringExtra("fecha");
        recibirfecha.setText("Fecha: "+Fecha);

        tv1 = (TextView) findViewById(R.id.tvnombre);
        String Nombre = getIntent().getStringExtra("nombre");
        tv1.setText("Nombre: "+Nombre);

        tv2telefono = (TextView) findViewById(R.id.tvtelefono);
        String Telefono = getIntent().getStringExtra("telefono");
        tv2telefono.setText("Telefono :"+Telefono);

        tv3email = (TextView) findViewById(R.id.tvemail);
        String Email = getIntent().getStringExtra("email");
        tv3email.setText("Email: "+Email);

        tv4descripcion = (TextView) findViewById(R.id.tvdescripcion);
        String Descripcion = getIntent().getStringExtra("descripcion");
        tv4descripcion.setText("Descripcion: "+Descripcion);

        beditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mostrar_datos.this , MainActivity.class);
                intent.putExtra("nombre",tv1.getText()+" ");
                intent.putExtra("telefono",tv2telefono.getText()+" ");
                intent.putExtra("email",tv3email.getText()+" ");
                intent.putExtra("descripcion",tv4descripcion.getText()+"");
                startActivity(intent);
            }
        });


    }
}
