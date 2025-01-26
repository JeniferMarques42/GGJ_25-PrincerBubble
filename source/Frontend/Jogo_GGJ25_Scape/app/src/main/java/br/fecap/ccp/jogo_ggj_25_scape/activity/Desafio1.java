package br.fecap.ccp.jogo_ggj_25_scape.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.fecap.ccp.jogo_ggj_25_scape.R;

public class Desafio1 extends AppCompatActivity {

    Button btnMenssagem;
    EditText campoSenha;
    ImageButton campoOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio1);

        // Inicializando as views
        campoSenha = findViewById(R.id.editTextSenha);
        campoOk = findViewById(R.id.btnOk);

        campoSenha.setVisibility(View.GONE);
        campoOk.setVisibility(View.GONE);




        // CardView: Nova Denúncia
        CardView cardMenssagen = findViewById(R.id.card_menssagem);
        cardMenssagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tornando o campo de senha visível
                campoSenha.setVisibility(View.VISIBLE);
                campoOk.setVisibility(View.VISIBLE);

            }
        });

        campoOk.setOnClickListener(v ->{
            // Captura o valor da senha inserida e transforma em maiúsculas
            String senha = campoSenha.getText().toString();
            if(senha.equals("1")){
                Intent intent = new Intent(Desafio1.this, Desafio2.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(Desafio1.this, "Tente novamente.", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
