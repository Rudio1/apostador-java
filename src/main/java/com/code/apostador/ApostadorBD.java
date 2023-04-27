package com.code.apostador;

import jakarta.persistence.*;

@Entity
@Table(name = "apostador_bd")
public class ApostadorBD{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String email;

    public ApostadorBD(){

    }
    public ApostadorBD(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }


    public Long getId(){return Id;}

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
