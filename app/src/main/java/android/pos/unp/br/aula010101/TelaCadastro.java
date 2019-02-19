package android.pos.unp.br.aula010101;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;

public class TelaCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DBController db =
                new DBController(this.getApplicationContext(),
                        "",null,1);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btnSalvar);
        fab.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){

            EditText edtNome = (EditText)
                    findViewById(R.id.txtNome);
            String nome = edtNome.getText().toString();

            EditText edtEmail = (EditText)
                    findViewById(R.id.txtEmail);
            String email = edtEmail.getText().toString();

            EditText edtSenha = (EditText)
                    findViewById(R.id.txtSenha);
            String senha = edtSenha.getText().toString();

            EditText edtConfirma = (EditText)
                    findViewById(R.id.txtConfirmar);
            String confirma = edtConfirma.getText().toString();


                if(db.inserirUsuarios(nome,email,senha,confirma)){
                Toast.makeText(getApplicationContext(), "Usuario cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();

            }else{
                Toast.makeText(getApplicationContext(), "Erro ao cadastrar  usuario!", Toast.LENGTH_SHORT).show();
            }


        }


        });
    }

}
