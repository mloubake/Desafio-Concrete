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
import br.com.mloubake.desafioconcretegithubapi.model.Repositorio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Client.request {

    private static final String TAG = "TAG";
    int screenOrientation;

    ArrayList<Repositorio> mRepoList;
    RepositorioAdapter mAdapter;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRepoList = new ArrayList<>();

        startRequest();
    }

    @Override
    public void startRequest() {
        request.enqueue(new Callback<Repositorio>() {
            @Override
            public void onResponse(Call<Repositorio> call, Response<Repositorio> response) {
                if(!response.isSuccessful()) {
                    Log.d(TAG, "Response Error Code: " + response.code());
                }
                Log.d(TAG, "Response Success Code: " + response.code());

                List<Repositorio> repositorios = response.body().getItems();

                for (int i = 0; i < repositorios.size(); i++) {
                    Repositorio repos = new Repositorio(
                            repositorios.get(i).getUsuario().getUrlFoto(),
                            repositorios.get(i).getUsuario().getNomeUsuario(),
                            repositorios.get(i).getRepoTitulo(),
                            repositorios.get(i).getRepoDesc(),
                            repositorios.get(i).getStars(),
                            repositorios.get(i).getForks());

                    mRepoList.add(repos);
                }

                recyclerView = findViewById(R.id.recyclerView);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                mAdapter = new RepositorioAdapter(MainActivity.this, mRepoList);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<Repositorio> call, Throwable t) {

            }
        });

    }

}

