package br.com.mloubake.desafioconcretegithubapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Repositorio {

    @SerializedName("name")
    String repoTitulo;

    @SerializedName("description")
    String repoDesc;

    @SerializedName("stargazers_count")
    int stars;

    @SerializedName("forks_count")
    int forks;

    @SerializedName("items")
    List<Repositorio> items;

//    Problema de layout sumindo aqui
    @SerializedName("owner")
    Usuario usuario;

    String fotoUser;
    String nomeUser;

    public Repositorio(String fotoUser, String nomeUser, String repoTitulo, String repoDesc, int stars, int forks) {
        this.fotoUser = fotoUser;
        this.nomeUser = nomeUser;
        this.repoTitulo = repoTitulo;
        this.repoDesc = repoDesc;
        this.stars = stars;
        this.forks = forks;
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

    public Usuario getUsuario() {
        return usuario;
    }


    public String getFotoUser() {
        return fotoUser;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public class Usuario {

        @SerializedName("avatar_url")
        String urlFoto;

        @SerializedName("login")
        String nomeUsuario;

        public Usuario() {
        }

        public String getUrlFoto() {
            return urlFoto;
        }

        public String getNomeUsuario() {
            return nomeUsuario;
        }
    }
}
