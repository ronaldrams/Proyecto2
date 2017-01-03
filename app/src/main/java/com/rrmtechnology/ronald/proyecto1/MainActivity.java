package com.rrmtechnology.ronald.proyecto1;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;
import android.view.View;



public class MainActivity extends Activity {

    Button buttonS;
    EditText ed1,ed2,ed3,ed4 , seleccionarfecha;
    private int dia , mes ,año;
    private static final int DATE_DIALOG_ID = 0;
    private static DatePickerDialog.OnDateSetListener oirfecha;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obteniendo una instancia del boton buttosnS
        buttonS = (Button) findViewById(R.id.buttonS);



        Calendar calendario = Calendar.getInstance();
        dia=calendario.get(calendario.DAY_OF_MONTH);
        mes=calendario.get(calendario.MONTH);
        año=calendario.get(calendario.YEAR);



        oirfecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                año=i;
                mes=i1;
                dia=i2;
                mostrarfecha();
            }
        };

        seleccionarfecha = (EditText) findViewById(R.id.seleccionarfecha);
        String Fecha = getIntent().getStringExtra("fecha");
        seleccionarfecha.setText(Fecha);

        ed1 = (EditText) findViewById(R.id.etnombre);
        String Nombre = getIntent().getStringExtra("nombre");
        ed1.setText(Nombre);

        ed2 = (EditText) findViewById(R.id.ettelefono);
        String Telefono = getIntent().getStringExtra("telefono");
        ed2.setText(Telefono);

        ed3 = (EditText) findViewById(R.id.etemail);
        String Email = getIntent().getStringExtra("email");
        ed3.setText(Email);

        ed4 = (EditText) findViewById(R.id.etdescripcion);
        String Descripcion = getIntent().getStringExtra("descripcion");
        ed4.setText(Descripcion);





        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Mostrar_datos.class);
                intent.putExtra("nombre",ed1.getText()+" ");
                intent.putExtra("telefono",ed2.getText()+" ");
                intent.putExtra("email",ed3.getText()+" ");
                intent.putExtra("descripcion",ed4.getText()+"");
                intent.putExtra("fecha",seleccionarfecha.getText()+"");

                startActivity(intent);
            }
        });

    }

    public void mostrarfecha(){
        seleccionarfecha.setText(año + " "+ mes + " " + dia );
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch(id){

            case 0 :

                return new DatePickerDialog(this,oirfecha , año , mes , dia);


        }

        return null;
    }

    public void mostrarcalendario(View control){
        showDialog(DATE_DIALOG_ID);
    }
}



