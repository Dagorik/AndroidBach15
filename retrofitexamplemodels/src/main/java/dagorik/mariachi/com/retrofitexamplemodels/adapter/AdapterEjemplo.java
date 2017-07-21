package dagorik.mariachi.com.retrofitexamplemodels.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dagorik.mariachi.com.retrofitexamplemodels.R;
import dagorik.mariachi.com.retrofitexamplemodels.models.Ejemplo;

/**
 * Created by Dagorik on 20/07/17.
 */

public class AdapterEjemplo extends RecyclerView.Adapter<AdapterEjemplo.EjemploViewHolder> {

    List<Ejemplo> ejemploList = new ArrayList<>();

    public AdapterEjemplo(List<Ejemplo> ejemploList) {
        this.ejemploList = ejemploList;
    }

    @Override
    public AdapterEjemplo.EjemploViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        return new EjemploViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterEjemplo.EjemploViewHolder ejemploViewHolder, int position) {
        Ejemplo ejemplo = ejemploList.get(position);
        ejemploViewHolder.tvTitle.setText(ejemplo.getTitle());
        ejemploViewHolder.tvComents.setText(ejemplo.getComment());
        ejemploViewHolder.pintar(ejemplo.getPicture());

    }

    @Override
    public int getItemCount() {
        return ejemploList.size();
    }

    public class EjemploViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTitle, tvComents;
        public ImageView picasso;
        public  Context context;

        public EjemploViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvComents = (TextView) itemView.findViewById(R.id.tv_coment);
            picasso = (ImageView) itemView.findViewById(R.id.iv_image);
            context = itemView.getContext();
        }

        public void pintar(String url){
            Picasso.with(context).load(url).into(picasso);

        }
    }
}
