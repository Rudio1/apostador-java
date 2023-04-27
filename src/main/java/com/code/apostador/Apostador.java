package com.code.apostador;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Apostador {
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("email")
    private String email;

    public Apostador(){

    }
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

    public ApostadorBD toConvert() {
        ApostadorBD apostadorBD = new ApostadorBD();
        apostadorBD.setNome(this.nome);
        apostadorBD.setEmail(this.email);
        return apostadorBD;
    }
}
