package dagorik.mariachi.com.recyclerview.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dagorik.mariachi.com.recyclerview.DescripcionActivity;
import dagorik.mariachi.com.recyclerview.R;
import dagorik.mariachi.com.recyclerview.models.Peso;

/**
 * Created by Dagorik on 17/07/17.
 */

public class PesoAdaptador extends RecyclerView.Adapter<PesoAdaptador.PesoViewHolder> {

    public List<Peso> pesoList = new ArrayList<>();

    public PesoAdaptador(List<Peso> pesoList) {
        this.pesoList = pesoList;
    }

    @Override
    public PesoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new PesoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PesoViewHolder pesoViewholder, int position) {
        Peso peso = pesoList.get(position);
        pesoViewholder.tvfecha.setText(peso.getFecha());
        pesoViewholder.tvPeso.setText(peso.getPeso());
    }

    @Override
    public int getItemCount() {
        return pesoList.size();
    }

    public class PesoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvfecha,tvPeso;

        public PesoViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvfecha = (TextView) itemView.findViewById(R.id.tvFecha);
            tvPeso = (TextView) itemView.findViewById(R.id.tvPeso);

        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            int position = getAdapterPosition();
            Peso peso = pesoList.get(position);
            Intent intent = new Intent(v.getContext(), DescripcionActivity.class);
            intent.putExtra("PESO", peso.getPeso());
            context.startActivity(intent);
        }
    }
}

