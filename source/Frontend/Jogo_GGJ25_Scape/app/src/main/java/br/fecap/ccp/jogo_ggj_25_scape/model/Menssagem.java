package br.fecap.ccp.jogo_ggj_25_scape.model;


public class Menssagem {

    private String menssagem;
    private String menssagem2;
    private String codigo;


    public Menssagem(String menssagem, String menssagem2, String codigo) {
        this.menssagem = menssagem;
        this.menssagem2 = menssagem2;
        this.codigo = codigo;
    }

    // Getters
    public String getMenssagem() {return menssagem;}

    public String getMenssagem2() {
        return menssagem2;
    }

    public String getCodigo() {return codigo;}

}

