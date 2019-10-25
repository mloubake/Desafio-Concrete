package br.com.mloubake.desafioconcretegithubapi.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    @SerializedName("owner")
    List<Owner> ownerAtributos;

    @SerializedName("avatar_url")
    String urlFoto;

    @SerializedName("login")
    String nomeUsuario;

    @SerializedName("full_name")
    String repoTitulo;

    @SerializedName("description")
    String repoDesc;

    @SerializedName("stargazers_count")
    int stars;

    @SerializedName("forks_count")
    int forks;

    @SerializedName("items")
    List<Repositorio> items;

    public Repositorio(String urlFoto, String nomeUsuario, String repoTitulo, String repoDesc, int stars, int forks) {
        this.urlFoto = urlFoto;
        this.nomeUsuario = nomeUsuario;
        this.repoTitulo = repoTitulo;
        this.repoDesc = repoDesc;
        this.stars = stars;
        this.forks = forks;
    }

    public Repositorio(List<Owner> ownerAtributos, String repoTitulo, String repoDesc, int stars, int forks) {
        this.ownerAtributos = ownerAtributos;
        this.repoTitulo = repoTitulo;
        this.repoDesc = repoDesc;
        this.stars = stars;
        this.forks = forks;
    }

    public Repositorio(String repoTitulo, String repoDesc, int stars, int forks) {
        this.repoTitulo = repoTitulo;
        this.repoDesc = repoDesc;
        this.stars = stars;
        this.forks = forks;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getRepoTitulo() {
        return repoTitulo;
    }

    public String getRepoDesc() {
        return repoDesc;
    }

    public int getStars() {
        return stars;
    }

    public int getForks() {
        return forks;
    }

    public List<Repositorio> getItems() {
        return items;
    }

    public List<Owner> getOwner() {
        return ownerAtributos;
    }
}
