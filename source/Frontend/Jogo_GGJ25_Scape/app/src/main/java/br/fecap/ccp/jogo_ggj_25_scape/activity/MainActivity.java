package br.fecap.ccp.jogo_ggj_25_scape.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

import br.fecap.ccp.jogo_ggj_25_scape.R;

public class MainActivity extends AppCompatActivity {

    Button btnEmail;
    TextInputEditText campoEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnEmail = findViewById(R.id.btnEmail);
        campoEmail = findViewById(R.id.textInputEditEmail);

        // Criação do Pop-up (Dialog)
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("⚠️Alerta de sistema: vulnerabilidade detectada⚠️")
                .setMessage("Não se preocupe, não sou um inimigo. Sou o Pincer Bubble. Você já sabe que nosso governo está construindo uma cortina de silêncio, escondendo a verdade dos cidadãos e aprisionando-os em uma bolha de desinformação. Mas hoje, você tem a chance de ver além da cortina. Estou aqui para te guiar para a verdade, para te mostrar o que realmente está acontecendo. Você está pronto para abrir os olhos e ver a realidade?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Fecha o diálogo ao clicar em OK
                    }
                });

        // Exibir o pop-up
        builder.show();

        btnEmail.setOnClickListener(v -> {
                    sendEmail();
                }
        );

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void sendEmail() {
        String email = campoEmail.getText().toString();

        if (email.isEmpty()) {
            Toast.makeText(this, "Por favor, digite seu e-mail.", Toast.LENGTH_SHORT).show();
            return;
        }

        RequestQueue queue = Volley.newRequestQueue(this);
        String urlPostEmail = "https://nh9hcg-3000.csb.app/sendemail";

        StringRequest postRequest = new StringRequest(Request.Method.POST, urlPostEmail,
                response -> {
                    Toast.makeText(MainActivity.this, "Email sent successfully", Toast.LENGTH_SHORT).show();
                    // Aqui, move para a tela Desafio1 após o envio bem-sucedido
                    startActivity(new Intent(MainActivity.this, Desafio1.class));
                },
                error -> Toast.makeText(MainActivity.this, "Error sending email" + error, Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                return params;
            }
        };
        queue.add(postRequest);
    }


}

