package android.pos.unp.br.aula010101;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaTombo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_tombo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DBController db =
                new DBController(this.getApplicationContext(),
                        "", null, 1);

        Button btnCadastar =
                (Button) findViewById(R.id.btnCadastrar);
        btnCadastar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edtTipo = (EditText)
                        findViewById(R.id.txtTipo);
                String tipo = edtTipo.getText().toString();

                EditText edtLocal = (EditText)
                        findViewById(R.id.txtLocal);
                String local = edtLocal.getText().toString();

                EditText edtUnidade = (EditText)
                        findViewById(R.id.txtUnidade);
                String unidade = edtUnidade.getText().toString();

                EditText edtNSerial = (EditText)
                        findViewById(R.id.txtNSerial);
                String nserial = edtNSerial.getText().toString();

                EditText edtTombo = (EditText)
                        findViewById(R.id.txtTombo);
                String tombo = edtTombo.getText().toString();

                EditText edtData = (EditText)
                        findViewById(R.id.Data);
                String data = edtData.getText().toString();


                if (db.inserirEquipamento(tipo, local, unidade, nserial, tombo, data)) {
                    Toast.makeText(getApplicationContext(), "Usuario inserido com sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Erro ao inserir o usuario", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button btnLimpar = (Button) findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                EditText edtTipo = (EditText)
                        findViewById(R.id.txtTipo);
                edtTipo.setText("");

                EditText edtLocal = (EditText)
                        findViewById(R.id.txtLocal);
                edtLocal.setText("");

                EditText edtUnidade = (EditText)
                        findViewById(R.id.txtUnidade);
                edtUnidade.setText("");

                EditText edtNSerial = (EditText)
                        findViewById(R.id.txtNSerial);
                edtNSerial.setText("");

                EditText edtTombo = (EditText)
                        findViewById(R.id.txtTombo);
                edtTombo.setText("");

                EditText edtData = (EditText)
                        findViewById(R.id.Data);
                edtData.setText("");

            }

        });

    }

}
