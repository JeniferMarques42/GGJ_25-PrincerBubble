package br.fecap.ccp.jogo_ggj_25_scape.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.fecap.ccp.jogo_ggj_25_scape.R;
import br.fecap.ccp.jogo_ggj_25_scape.adapter.Adapter;
import br.fecap.ccp.jogo_ggj_25_scape.model.Menssagem;

public class Desafio2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Menssagem> listaMenssagem = new ArrayList<>();
    private Adapter adapter;
    private Handler handler;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_desafio2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.newsRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Configurar Adapter
        adapter = new Adapter(this, listaMenssagem);
        recyclerView.setAdapter(adapter);

        // Inicializar Handler para atrasos
        handler = new Handler(Looper.getMainLooper());

        // Inicializar MediaPlayer com som (som localizado em res/raw/sound.mp3)
        mediaPlayer = MediaPlayer.create(this, R.raw.msn);

        // Criar mensagens com intervalo de 2 segundos
        criarMenssagem();
    }

    private void criarMenssagem() {
        String[] titulos = {
                "Você sabia que o governo está cada vez mais controlando a informação que chega até nós? É como se estivessem construindo uma cortina de silêncio.",
                "Exatamente! E é difícil saber o que é verdade e o que é mentira. O governo está usando as mídias sociais e a imprensa para espalhar informações falsas e manipular a opinião pública.",
                "Você acha que podemos fazer algo para mudar essa situação?",
                "(olhando em volta) Você acha que estamos sendo vigiados?",
                "(nervosa) Eu também tenho recebido mensagens estranhas. E eu notei que há sempre alguém seguindo-me quando eu saio de casa.",
                "(assustada) O que podemos fazer?",
                "(determinada) Vamos fazer isso. Vamos encontrar uma maneira de lutar contra essa cortina de silêncio e defender nossa liberdade."
        };

        String[] conteudos = {
                "Sim, eu sei. É assustador. Eles estão usando a desinformação como uma ferramenta para controlar a população. É como se estivessem aprisionando as pessoas em uma bolha de desinformação.",
                "É um cenário muito perigoso. A liberdade de expressão e a liberdade de informação são fundamentais para uma democracia saudável. Se o governo continuar a controlar a informação, podemos perder esses direitos.",
                "Sim, acho que sim. Podemos começar a questionar as informações que recebemos e procurar fontes confiáveis. Além disso, podemos usar as nossas vozes para denunciar a desinformação e defender a liberdade de expressão.",
                "(baixando a voz) Eu não sei, mas eu sinto que sim. Eu tenho recebido mensagens estranhas no meu celular e eu acho que alguém está monitorando minhas atividades online.",
                "(serio) Nós precisamos ser cuidadosos. Se o governo está realmente nos vigiando, nós não podemos saber o que eles podem fazer.",
                "(pensativo) Nós precisamos encontrar uma maneira de nos comunicar sem sermos detectados. Talvez possamos usar criptografia ou encontrar um canal de comunicação seguro.",
                "(confiante) Está decidido. Não vamos deixar que nos silenciem. Vamos lutar."
        };

        String[] codigo = {
                "Sim, eu sei. É assustador. Eles estão usando a desinformação como uma ferramenta para controlar a população. É como se estivessem aprisionando as pessoas em uma bolha de desinformação.",
                "É um cenário muito perigoso. A liberdade de expressão e a liberdade de informação são fundamentais para uma democracia saudável. Se o governo continuar a controlar a informação, podemos perder esses direitos.",
                "Sim, acho que sim. Podemos começar a questionar as informações que recebemos e procurar fontes confiáveis. Além disso, podemos usar as nossas vozes para denunciar a desinformação e defender a liberdade de expressão.",
                "(baixando a voz) Eu não sei, mas eu sinto que sim. Eu tenho recebido mensagens estranhas no meu celular e eu acho que alguém está monitorando minhas atividades online.",
                "(serio) Nós precisamos ser cuidadosos. Se o governo está realmente nos vigiando, nós não podemos saber o que eles podem fazer.",
                "(pensativo) Nós precisamos encontrar uma maneira de nos comunicar sem sermos detectados. Talvez possamos usar criptografia ou encontrar um canal de comunicação seguro.",
                "(confiante) Está decidido. Não vamos deixar que nos silenciem. Vamos lutar."
        };

        String[] autores = {
                "Sou algo que todos almejam, mas poucos conseguem realmente ter.",
                "No início, sou retirada de você por uma força que se apresenta como protetora, alegando que é para o seu bem-estar, para a segurança de todos.",
                "Sou abafada, silenciada e até distorcida, com aqueles que tentam me buscar sendo punidos ou calados.",
                "Aqueles que governam com mãos de ferro temem minha presença, pois sabem que quando sou plenamente exercida, a verdadeira força de um povo é revelada.",
                "Mesmo sendo cerceada e comprimida, sou constantemente buscada, com muitos dispostos a lutar por mim, mesmo quando o custo é a dor, o sofrimento e a perda.",
                "Sou aquilo que, quando me ausento, a vida perde seu brilho, mas, quando sou conquistada, os corações se tornam invencíveis.",
                "O que sou?"
        };

        for (int i = 0; i < titulos.length; i++) {
            final int index = i;
            handler.postDelayed(() -> {
                // Adicionar mensagem à lista
                Menssagem mensagem = new Menssagem(titulos[index], conteudos[index], autores[index]);
                listaMenssagem.add(mensagem);
                adapter.notifyItemInserted(listaMenssagem.size() - 1);
                recyclerView.scrollToPosition(listaMenssagem.size() - 1);

                // Reproduzir o som
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                }
            }, index * 2000); // Atraso de 2 segundos entre mensagens
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

