package br.com.fiap.carroapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import br.com.fiap.carroapp.R;
import br.com.fiap.carroapp.model.CarroBean;

/**
 * Created by jeff on 11/19/15.
 */
public class CarroAdapter extends RecyclerView.Adapter<CarroAdapter.CarroViewHolder> {

    private Context contexto;
    private List<CarroBean> carros;

    public CarroAdapter (Context contexto, List<CarroBean> carros) {
        this.contexto = contexto;
        this.carros = carros;
    }

    @Override
    public CarroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Realiza a mudanca de layout, fazendo com que o mesmo seja atribuido para a view
        View view = LayoutInflater.from(contexto).inflate(R.layout.carro_row, parent, false);

        return new CarroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarroViewHolder holder, int position) {

        try {
            holder.tvNomeCarro.setText(carros.get(position).getNome());
            holder.tvDescricaoCarro.setText(carros.get(position).getDescricao());

            InputStream is = contexto.getAssets().open(carros.get(position).getFoto());
            Drawable fotoCarro = Drawable.createFromStream(is, null);

            holder.ivCarro.setImageDrawable(fotoCarro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarroViewHolder extends RecyclerView.ViewHolder {

        TextView tvNomeCarro;
        TextView tvDescricaoCarro;
        ImageView ivCarro;
        ImageView ivMais;
        ProgressBar pbCarro;

        public CarroViewHolder(View itemView) {

            super(itemView);

            this.tvNomeCarro = (TextView) itemView.findViewById(R.id.tvNomeCarroID);
            this.tvDescricaoCarro = (TextView) itemView.findViewById(R.id.tvDescricaoCarroID);
            this.ivCarro = (ImageView) itemView.findViewById(R.id.ivCarroID);
            this.ivMais = (ImageView) itemView.findViewById(R.id.ivMaisID);
            this.pbCarro = (ProgressBar) itemView.findViewById(R.id.pbCarroID);

        }
    }
}
