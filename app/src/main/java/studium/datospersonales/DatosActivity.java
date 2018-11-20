package studium.datospersonales;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;



public class DatosActivity extends AppCompatActivity {
    TextView txNombre;
    TextView txApellidos;
    TextView txEdad;
    RadioGroup grupoSexo;
    RadioButton radioMujer;
    RadioButton radioHombre;
    Spinner eligeEstado;
    Switch swHijos;
    Button btnGenerar;
    Button btnBorrar;
    TextView txInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);



        txNombre = findViewById(R.id.txNombre);
        txApellidos = findViewById(R.id.txApellidos);
        txEdad = findViewById(R.id.txEdad);
        grupoSexo = findViewById(R.id.grupoSexo);
        radioHombre = findViewById(R.id.radioHombre);
        radioMujer = findViewById(R.id.radioMujer);
        eligeEstado = findViewById(R.id.eligeEstado);
        swHijos = findViewById(R.id.swHijos);
        btnGenerar = findViewById(R.id.btnGenerar);
        btnBorrar = findViewById(R.id.btnBorrar);
        txInfo = findViewById(R.id.txInfo);

        Button btnBorrar = findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txNombre.setText("");
                txApellidos.setText("");
                txEdad.setText("");
                radioMujer.setChecked(true);
                radioHombre.setChecked(false);
                eligeEstado.setSelection(0);
                swHijos.setChecked(false);
                txInfo.setText("");

            }
        });

        Button btnGenerar = findViewById(R.id.btnGenerar);
        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txInfo.setText(generaInfo());
            }



            public String generaInfo() {

                RadioButton sexo = findViewById(grupoSexo.getCheckedRadioButtonId());
                String Resultado = txApellidos.getText().toString() + " , " + txNombre.getText().toString() +
                        " , " + mayoriaEdad() + " , " + sexo.getText().toString() +
                        " , " + eligeEstado.getSelectedItem().toString() + " , " + tieneHijos();
                return Resultado;
            }

            public String mayoriaEdad() {
                int edad = Integer.parseInt(txEdad.getText().toString());
                String edadResultante;
                if (edad >= 18) {
                    edadResultante = "mayor de edad";}
                else {
                    edadResultante = "menor de edad";
                }
                return edadResultante;
            }
            public String tieneHijos() {
                swHijos.getText().toString();
                String hijosResultado;
                if (swHijos.isChecked()) {
                    hijosResultado = " con hijos ";
                }
                else{
                    hijosResultado = " sin hijos ";
                }
                return hijosResultado;
            }

        });
    }}
