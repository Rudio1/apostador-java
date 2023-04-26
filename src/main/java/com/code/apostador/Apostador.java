package com.code.apostador;

public class Apostador {

    private String nome;
    private String email;

    public String getNome(){
        return this.nome;
    }
    public String getEmail(){
        return this.email;
    }

    @Override
    public String toString() {
        return "Apostador{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public ApostadorBD toConvert(){
        return new ApostadorBD(nome, email);
    }
}
