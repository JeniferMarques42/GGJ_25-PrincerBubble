package br.fecap.ccp.jogo_ggj_25_scape.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.fecap.ccp.jogo_ggj_25_scape.R;
import br.fecap.ccp.jogo_ggj_25_scape.model.Menssagem;

public class Adapter extends RecyclerView.Adapter<Adapter.NewsViewHolder> {

    private Context context;
    private List<Menssagem> listaMenssagem;

    public Adapter(Context context, List<Menssagem> newsList) {
        this.context = context;
        this.listaMenssagem = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_list, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Menssagem menssagem = listaMenssagem.get(position);

        holder.textMenssagem.setText(menssagem.getMenssagem());
        holder.textMenssagem2.setText(menssagem.getMenssagem2());
        holder.textCodigo.setText(menssagem.getCodigo());

    }

    @Override
    public int getItemCount() {
        return listaMenssagem.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView textMenssagem;
        TextView textMenssagem2;
        TextView textCodigo;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            textMenssagem = itemView.findViewById(R.id.textMenssagem);
            textMenssagem2 = itemView.findViewById(R.id. textMenssagem2);
            textCodigo = itemView.findViewById(R.id.textCodigo);
        }
    }
}