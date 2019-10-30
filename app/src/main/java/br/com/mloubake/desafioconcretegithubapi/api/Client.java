package br.com.mloubake.desafioconcretegithubapi.api;

import androidx.annotation.NonNull;

import br.com.mloubake.desafioconcretegithubapi.model.Repositorio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient() {
        if(retrofit == null) {
            String BASE_URL = "https://api.github.com/";
            retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
        return retrofit;
    }

    public interface request {
        Retrofit retrofit = Client.getRetrofitClient();
        GitService mGitService = retrofit.create(GitService.class);
        Call<Repositorio> request = mGitService.getRepositorio("java");

        void startRequest();
    }
}
