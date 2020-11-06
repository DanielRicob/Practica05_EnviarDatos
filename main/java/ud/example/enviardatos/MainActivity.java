package ud.example.enviardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Clases.Bebida;
import Clases.Cantidad;
import Clases.Hamburgesa;

public class MainActivity extends AppCompatActivity {

    private EditText cliente;
    private Spinner lista00;
    private Spinner lista01;
    private Spinner lista02;
    private Spinner lista03;
    private CheckBox hielo;
    private Button enviab;
    // private List<String> tipoh, tipob, sino;;


    public void datosinicio() {
        List<String> tipoh = new ArrayList<String>();
        List<String> tipoc =new ArrayList<String>();
        List<String> sino = new ArrayList<String>();

        tipoc.add("1");
        tipoc.add("2");
        tipoc.add("3");
        tipoc.add("4");
        tipoc.add("5");
        ArrayAdapter<String> adaptador00 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, tipoc);
        adaptador00.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista00.setAdapter(adaptador00);


        tipoh.add("Carne");
        tipoh.add("Pollo");
        tipoh.add("Pescado");
        ArrayAdapter<String> adaptador01 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, tipoh);
        adaptador01.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista01.setAdapter(adaptador01);

        sino.add("SI");
        sino.add("NO");
        ArrayAdapter<String> adaptador02 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adaptador02.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista02.setAdapter(adaptador02);



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cliente = (EditText) findViewById(R.id.editTextTextPersonName2);
        lista00=  (Spinner) findViewById(R.id.spinner4);
        lista01 = (Spinner) findViewById(R.id.spinner);
        lista02 = (Spinner) findViewById(R.id.spinner2);
        lista03 = (Spinner) findViewById(R.id.spinner3);
        hielo = (CheckBox) findViewById(R.id.checkBox);
        enviab = (Button) findViewById(R.id.button);
        datosinicio();
        enviab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                String nombre = cliente.getText().toString();
                        if (nombre.equals("")) {
                            cliente.setError("Escribir Nombre !!!");
                        } else {llamaractividad();}
            }
        });


    }

    public void llamaractividad() {

        int Numero = 0 ;
        Cantidad micand = new Cantidad(lista00.getSelectedItem().toString(), Numero);

        boolean cebolla = false;
        if (lista02.getSelectedItem().toString().equals("SI")) cebolla = true;
        Hamburgesa miham = new Hamburgesa(lista01.getSelectedItem().toString(), cebolla);

        boolean hielo = this.hielo.isChecked();
        Bebida mibeb = new Bebida(lista03.getSelectedItem().toString(), hielo);


            Intent int01 = new Intent(this, Actividad2.class);
            int01.putExtra("CANTIDAD",micand);
            int01.putExtra("CLIENTE", cliente.getText().toString());
            int01.putExtra("HAMBURGUESA", miham);
            int01.putExtra("BEBIDA", mibeb);
            startActivity(int01);
    }
}

