package ud.example.enviardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import Clases.Bebida;
import Clases.Cantidad;
import Clases.Hamburgesa;

public class Actividad2 extends AppCompatActivity {

    private TextView logTextView;
    private ScrollView scrollview;


        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_actividad2);

        logTextView = findViewById(R.id.textView9);
        scrollview =  findViewById(R.id.scrollView);
        Bundle bundle = this.getIntent().getExtras();

        log("Cliente; " + bundle.getString("CLIENTE"));
        log("");
            Cantidad mipedcand = (Cantidad) bundle.get("CANTIDAD");
            log("Cantidad");
            log(mipedcand.getValor());
        Hamburgesa mipedham = (Hamburgesa) bundle.get("HAMBURGUESA");
        Bebida mipedbeb = (Bebida) bundle.get("BEBIDA");
        log("Hamburgesa");
        log(mipedham.getTipo());
        if(mipedham.getCebolla()) {log("con cebolla");
        }else {log("sin cebolla");};
        log("");
        log("Bebida");
        log(mipedbeb.getTipo());
        if(mipedbeb.getHielo()){log("con hielo");
        } else{log("sin hielo");}

        }
    private void log(String s) {
        logTextView.append("\n" + s);

        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(ScrollView.FOCUS_DOWN);
            }

        });
    }


}