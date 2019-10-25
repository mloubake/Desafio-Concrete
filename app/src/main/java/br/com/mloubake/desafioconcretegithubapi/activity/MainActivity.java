package br.com.mloubake.desafioconcretegithubapi.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.mloubake.desafioconcretegithubapi.R;
import br.com.mloubake.desafioconcretegithubapi.adapter.RepositorioAdapter;
import br.com.mloubake.desafioconcretegithubapi.api.Client;
import br.com.mloubake.desafioconcretegithubapi.api.GitService;
import br.com.mloubake.desafioconcretegithubapi.model.Owner;
import br.com.mloubake.desafioconcretegithubapi.model.Repositorio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";
    int screenOrientation;

    ArrayList<Owner> mAutorList;
    ArrayList<Repositorio> mRepoList;

    RepositorioAdapter mAdapter;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new RepositorioAdapter();

        fetchRepositorioData();
    }

    private void fetchRepositorioData() {
        Retrofit retrofit = Client.getRetrofitClient();
        GitService mGitService = retrofit.create(GitService.class);
        final Call<Repositorio> request = mGitService.getRepositorio("java");

        request.enqueue(new Callback<Repositorio>() {
            @Override
            public void onResponse(Call<Repositorio> call, Response<Repositorio> response) {
                if(!response.isSuccessful()) {
                    Log.d(TAG, "Response Error Code: " + response.code());
                }
                Log.d(TAG, "Response Error Code: " + response.code());
                List<Repositorio> repositorios = response.body().getItems();

//                mAutorList = new ArrayList<>();
                mRepoList = new ArrayList<>();

                for(int i = 0; i < repositorios.size(); i++) {

                    Owner autor = new Owner(
//                            repositorios.get(i).getOwner().get(3).getUrlFoto(),
//                            repositorios.get(i).getOwner().get(0).getNomeUsuario()
                    );


                    Repositorio repos = new Repositorio(
                            response.body().getItems().get(i).getOwner().get(3).getUrlFoto(),
                            response.body().getItems().get(i).getOwner().get(0).getNomeUsuario(),
                            repositorios.get(i).getRepoTitulo(),
                            repositorios.get(i).getRepoDesc(),
                            repositorios.get(i).getStars(),
                            repositorios.get(i).getForks()
                    );

                    mAutorList.add(autor);
                    mRepoList.add(repos);
                }

                mRecyclerView = findViewById(R.id.recyclerView);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
                mAdapter = new RepositorioAdapter(MainActivity.this, mRepoList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<Repositorio> call, Throwable t) {
            }
        });
    }
}
