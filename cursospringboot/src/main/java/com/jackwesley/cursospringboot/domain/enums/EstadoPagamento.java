package com.jackwesley.cursospringboot.domain.enums;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int cod;

    private String descicao;

    EstadoPagamento(int cod, String descicao) {
        this.cod = cod;
        this.descicao = descicao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescicao() {
        return descicao;
    }

    public  static EstadoPagamento toEnum(Integer cod){
        if(cod == null){
            return  null;
        }

        for( EstadoPagamento x : EstadoPagamento.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
