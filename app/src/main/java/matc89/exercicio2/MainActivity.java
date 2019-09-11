package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView mensagem;
    private Button button;
    String strEditText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensagem = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.btnTrocar);

    }

    // Função do botão Trocar Usuário
    public void clicouTrocar (View v) {
        Intent intentTrocar = new Intent(this, OutraActivity.class);
        intentTrocar.putExtra("textoTextView",strEditText);
        startActivityForResult(intentTrocar,1); // Chamando a Activity esperando o resultado da digitação do usuário atual
    }

    // Método para receber o resultado da chamada da Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 1) {
            if (resultCode == RESULT_OK) {
                strEditText = data.getStringExtra("textoDigitado"); // recebendo o texto digitado
                if(strEditText.isEmpty()) {
                    mensagem.setText("Oi!");
                } else {
                    mensagem.setText(("Oi, " + strEditText + "!"));
                }
                Log.i("ABCD", strEditText);
            }
        }
    }

    // Salvando valor do texto digitado
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("meutexto", mensagem.getText().toString()); // Salvando o texto do TextView
        outState.putString("textoEditText",strEditText); // Salvando o texto para passar para o EditText
        Log.i("ABCD", "onSaveInstanceState");
    }

    // Restaurando valor do texto digitado
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String meutexto = savedInstanceState.getString("meutexto"); // Recuperando o texto do textView
        mensagem.setText(meutexto);
        strEditText = savedInstanceState.getString("textoEditText"); // Recuperando o texto para passar para o EditText

        Log.i("ABCD", "onRestoreInstanceState");
    }

}
