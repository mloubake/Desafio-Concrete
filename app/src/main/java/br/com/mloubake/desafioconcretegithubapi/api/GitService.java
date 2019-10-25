package br.com.mloubake.desafioconcretegithubapi.api;

import br.com.mloubake.desafioconcretegithubapi.model.Repositorio;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitService {

    @GET("search/repositories")
    Call<Repositorio> getRepositorio(@Query("q") String query);

//    @GET()
//    Call<PullRequest>
}
