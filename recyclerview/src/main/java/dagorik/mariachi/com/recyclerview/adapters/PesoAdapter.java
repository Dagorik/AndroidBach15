package dagorik.mariachi.com.recyclerview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dagorik.mariachi.com.recyclerview.R;
import dagorik.mariachi.com.recyclerview.models.Peso;

/**
 * Created by Dagorik on 03/10/17.
 */

public class PesoAdapter extends RecyclerView.Adapter<PesoAdapter.PesoViewHolders> {

    List<Peso> pesoList = new ArrayList<>();

    public PesoAdapter(List<Peso> pesoList) {
        this.pesoList = pesoList;
    }

    //Infla la vista, el xml(list_item.xml) y retorna un nuevo objeto de la clase PesoViewHolder
    @Override
    public PesoViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new PesoViewHolders(view);
    }

    //Crea el objeto de acuerdo a su posicion y setea los textos.
    @Override
    public void onBindViewHolder(PesoViewHolders pesoHolder, int position) {
        Peso peso = pesoList.get(position);
        pesoHolder.tvfecha.setText(peso.getFecha());
        pesoHolder.tvPeso.setText(peso.getPeso());
    }

    //Devuelve el numero de elementos a pintar
    @Override
    public int getItemCount() {
        return pesoList.size();
    }

    //Individual por view
    public class PesoViewHolders extends RecyclerView.ViewHolder {
        private TextView tvfecha, tvPeso;

        public PesoViewHolders(View itemView) {
            super(itemView);
            tvfecha = (TextView) itemView.findViewById(R.id.tvFecha);
            tvPeso = (TextView) itemView.findViewById(R.id.tvPeso);
        }
    }
}
