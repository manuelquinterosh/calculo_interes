package sv.com.manuelqh.calculo_interes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText cap, intereses, NumerPeriod;
    TextView result, intersApagar;
    Button calcu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cap = (EditText) findViewById(R.id.capital);
        intereses = (EditText) findViewById(R.id.interes);
        NumerPeriod = (EditText) findViewById(R.id.Nperiodo);
        result = (TextView) findViewById(R.id.resultadoFinal);
        intersApagar = (TextView) findViewById(R.id.interes_A_pagar);
        calcu = (Button) findViewById(R.id.btnCalculo);

        calcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculo_interes();
            }
        });
    }

    public void calculo_interes() {
        String capital_inicial = cap.getText().toString();
        String tasa_interes = intereses.getText().toString();
        String numero_periodo = NumerPeriod.getText().toString();

        double C = Double.parseDouble(capital_inicial);
        double TI = Double.parseDouble(tasa_interes);
        double NP = Double.parseDouble(numero_periodo);

        double Monto = 0, valor_interes = 0;

        Monto = C * Math.pow((1 + TI / 100), NP);

        valor_interes = Monto - C;

        DecimalFormat formato = new DecimalFormat("#.00");

        result.setText("El Monto total es: " + formato.format(Monto));

        intersApagar.setText("La tasa de Interes: " + formato.format(valor_interes));


    }

}
