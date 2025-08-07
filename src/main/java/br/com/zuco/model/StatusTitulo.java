package br.com.zuco.model;

public enum StatusTitulo {

    CANCELADO("Cancelado"),
    PENDENTE("Pendente"),
    RECEBIDO("Recebido");

    private String descricao;

    StatusTitulo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
