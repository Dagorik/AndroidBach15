package dagorik.mariachi.com.mvprecycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dagorik.mariachi.com.mvprecycler.R;
import dagorik.mariachi.com.mvprecycler.interfaces.OnRecyclerViewItemClickListener;
import dagorik.mariachi.com.mvprecycler.models.Person;

/**
 * Created by Dagorik on 11/08/17.
 */

public class AdaptadorPerson extends RecyclerView.Adapter<AdaptadorPerson.ViewHolder> {

    List<Person> personList = new ArrayList<>();
    private OnRecyclerViewItemClickListener<Person> itemClickListener;


    public AdaptadorPerson(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.user.setText(person.getName() + " " + person.getLastName());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView user;


        public ViewHolder(View itemView) {
            super(itemView);
            user = (TextView) itemView.findViewById(R.id.tv_nombre);
            user.setOnClickListener(view -> Toast.makeText(view.getContext(), "Tocaste a: " + user.getText(), Toast.LENGTH_SHORT).show());

        }


    }


}
