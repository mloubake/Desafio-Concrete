package br.com.mloubake.desafioconcretegithubapi.model;

import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("avatar_url")
    String urlFoto;

    @SerializedName("login")
    String nomeUsuario;

    public Owner(String urlFoto, String nomeUsuario) {
        this.urlFoto = urlFoto;
        this.nomeUsuario = nomeUsuario;
    }

    public Owner() {

    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
}
