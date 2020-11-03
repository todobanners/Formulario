package com.todobanners.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button botonFecha;
    EditText textoFecha;
    Button btnSiguiente;
    Contacto contacto;
    EditText etNombre;
    EditText etTelefono;
    EditText etEmail;
    EditText etDescripcion;
    EditText etFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonFecha = findViewById(R.id.botonFecha);
        textoFecha = findViewById(R.id.etFecha);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        etNombre = findViewById(R.id.etNombre);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDescripcion = findViewById(R.id.etDescripcion);
        etFecha = findViewById(R.id.etFecha);

        //Creando un nuevo objeto de clase Contacto
        contacto = new Contacto("Nombre",0,0,0,"Telefono","Email","Descripcion");


        botonFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        btnSiguiente.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setearDatos();
                if(contacto.emptySpace() == false){
                    Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                    intent.putExtra(getResources().getString(R.string.pnombre),contacto.getNombre());
                    intent.putExtra(getResources().getString(R.string.pfechad),contacto.getFechad());
                    intent.putExtra(getResources().getString(R.string.pfecham),contacto.getFecham());
                    intent.putExtra(getResources().getString(R.string.pfechaa),contacto.getFechaa());
                    intent.putExtra(getResources().getString(R.string.ptelefono),contacto.getTelefono());
                    intent.putExtra(getResources().getString(R.string.pemail),contacto.getEmail());
                    intent.putExtra(getResources().getString(R.string.pdescripcion),contacto.getDescripcion());
                    intent.putExtra(getResources().getString(R.string.pfecha),contacto.getFecha());
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Rellena todos los espacios", Toast.LENGTH_SHORT).show();
                }

            }
        }));
    }
    //Creando un date picker dialog
    public void showDatePickerDialog (){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month++;
        String date = dayOfMonth + "/" + month + "/" + year;
        textoFecha.setText(date);
        contacto.setFechad(dayOfMonth);
        contacto.setFecham(month);
        contacto.setFechaa(year);
    }

    public void setearDatos(){
        contacto.setNombre(etNombre.getText().toString());
        contacto.setTelefono(etTelefono.getText().toString());
        contacto.setEmail(etEmail.getText().toString());
        contacto.setDescripcion(etDescripcion.getText().toString());
        contacto.setFecha(etFecha.getText().toString());
    }
}