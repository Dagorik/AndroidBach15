package dagorik.mariachi.com.mvprecycler.interfaces;

import android.view.View;

/**
 * Created by Dagorik on 11/08/17.
 */

public interface OnRecyclerViewItemClickListener<Person> {

        void onItemClick(View view, Person model);


}
