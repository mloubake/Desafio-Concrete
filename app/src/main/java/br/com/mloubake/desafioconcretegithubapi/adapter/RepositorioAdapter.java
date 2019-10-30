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
import br.com.mloubake.desafioconcretegithubapi.model.Repositorio;

public class RepositorioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    ArrayList<Repositorio> mRepoList;
    private final String BASE_URL = "https://avatars2.githubusercontent.com/u/";

    public RepositorioAdapter(Context context, ArrayList<Repositorio> repoList) {
        mContext = context;
        mRepoList = repoList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.pull_request_viewholder, viewGroup, false);
        RepositorioViewHolder repoViewHolder = new RepositorioViewHolder(view);

        return repoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Glide.with(mContext)
                .load(mRepoList.get(position).getFotoUser())
                .centerCrop()
                .into(((RepositorioViewHolder) viewHolder).fotoUsuario);

        ((RepositorioViewHolder) viewHolder).nomeUsuario.setText(mRepoList.get(position).getNomeUser());
        ((RepositorioViewHolder) viewHolder).tituloRepositorio.setText(mRepoList.get(position).getRepoTitulo());
        ((RepositorioViewHolder) viewHolder).descRepositorio.setText(mRepoList.get(position).getRepoDesc());
        ((RepositorioViewHolder) viewHolder).star.setText(String.valueOf(mRepoList.get(position).getStars()));
        ((RepositorioViewHolder) viewHolder).fork.setText(String.valueOf(mRepoList.get(position).getForks()));
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
        TextView star;
        TextView fork;

        public RepositorioViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoUsuario = itemView.findViewById(R.id.PRFotoUser);
            nomeUsuario = itemView.findViewById(R.id.PRNomeUser);
            tituloRepositorio = itemView.findViewById(R.id.PRTitulo);
            descRepositorio = itemView.findViewById(R.id.PRDesc);
            star = itemView.findViewById(R.id.PRStar);
            fork = itemView.findViewById(R.id.PRFork);
        }
    }
}
