package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OutraActivity extends AppCompatActivity {

    private Button buttonCancelar;
    private Button buttonConfirmar;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);

        buttonConfirmar = (Button)findViewById(R.id.btnConfirmar);
        buttonCancelar = (Button)findViewById(R.id.btnCancelar);
        editText = (EditText)findViewById(R.id.editText);

        Intent intentReceber = getIntent();
        String usuarioAtual = intentReceber.getStringExtra("textoTextView"); // Recebendo o usuário atual para setar no EditText

        // Setando o usuário atual no EditText
        if(usuarioAtual.isEmpty()) {
            editText.setText("");
        } else {
            editText.setText(usuarioAtual);
        }

    }

    // Método do botão de confirmar
    public void clicouConfirmar (View v) {
        Intent intentConfirmar = new Intent(this, MainActivity.class);
        String textoDigitado = editText.getText().toString();
        intentConfirmar.putExtra("textoDigitado",textoDigitado);
        setResult(RESULT_OK,intentConfirmar); // Passando o texto digitado no EditText para o método que captura o resultado na Main Activity
        finish();
    }

    // Método do botão de cancelar
    public void clicouCancelar (View v) {
        finish();
    }

    // Salvando valor do texto digitado
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("meutexto", editText.getText().toString()); // Salvando o texto do EditText
        Log.i("ABCD", "onSaveInstanceState");
    }

    // Restaurando valor do texto digitado
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String meutexto = savedInstanceState.getString("meutexto"); // Restaurando o texto do EditText
        editText.setText(meutexto);

        Log.i("ABCD", "onRestoreInstanceState");
    }
}
