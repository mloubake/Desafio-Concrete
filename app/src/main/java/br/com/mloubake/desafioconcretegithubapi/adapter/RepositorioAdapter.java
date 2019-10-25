package br.com.mloubake.desafioconcretegithubapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import br.com.mloubake.desafioconcretegithubapi.R;
import br.com.mloubake.desafioconcretegithubapi.model.Owner;
import br.com.mloubake.desafioconcretegithubapi.model.Repositorio;

public class RepositorioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    ArrayList<Owner> mOwner;
    ArrayList<Repositorio> mRepoList;

    private final String BASE_URL = "https://avatars2.githubusercontent.com/u/";

    public RepositorioAdapter() {

    }

    public RepositorioAdapter(Context context, ArrayList<Owner> owner, ArrayList<Repositorio> repoList) {
        mContext = context;
        mOwner = owner;
        mRepoList = repoList;
    }

    public RepositorioAdapter(Context mContext, ArrayList<Repositorio> mRepoList) {
        this.mContext = mContext;
        this.mRepoList = mRepoList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.repositorio_viewholder, viewGroup, false);
        RepositorioViewHolder repoViewHolder = new RepositorioViewHolder(view);

        return repoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Glide.with(mContext)
                .load(BASE_URL +
                                mOwner.get(position).getUrlFoto()
//                                mRepoList.get(position).getOwner().get(3).getUrlFoto()
                        )
                .centerCrop()
                .into(((RepositorioViewHolder) viewHolder).fotoUsuario);

        ((RepositorioViewHolder) viewHolder).nomeUsuario.setText(mRepoList.get(position).getOwner().get(0).getNomeUsuario());
//        ((RepositorioViewHolder) viewHolder).nomeUsuario.setText(mOwner.get(position).getNomeUsuario());
        ((RepositorioViewHolder) viewHolder).tituloRepositorio.setText(mRepoList.get(position).getRepoTitulo());
        ((RepositorioViewHolder) viewHolder).descRepositorio.setText(mRepoList.get(position).getRepoDesc());
        ((RepositorioViewHolder) viewHolder).numeroStar.setText(String.valueOf(mRepoList.get(position).getStars()));
        ((RepositorioViewHolder) viewHolder).numeroFork.setText(String.valueOf(mRepoList.get(position).getForks()));
    }

    @Override
    public int getItemCount() {
        return mRepoList.size();
    }

    public class RepositorioViewHolder extends RecyclerView.ViewHolder {
        ImageView fotoUsuario;
        TextView nomeUsuario;
        TextView tituloRepositorio;
        TextView descRepositorio;
        TextView numeroStar;
        TextView numeroFork;

        public RepositorioViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoUsuario = itemView.findViewById(R.id.fotoUsuario);
            nomeUsuario = itemView.findViewById(R.id.nomeUsuario);
            tituloRepositorio = itemView.findViewById(R.id.tituloRepositorio);
            descRepositorio = itemView.findViewById(R.id.descRepositorio);
            numeroStar = itemView.findViewById(R.id.starNumeroRepositorio);
            numeroFork = itemView.findViewById(R.id.forkNumeroRepositorio);
        }
    }
}
