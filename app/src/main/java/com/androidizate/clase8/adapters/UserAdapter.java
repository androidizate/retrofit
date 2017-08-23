package com.androidizate.clase8.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidizate.clase8.R;
import com.androidizate.clase8.dao.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andres.oller on 18/08/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> userList = new ArrayList<>();

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_user, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = userList.get(position);

        holder.setInfo(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView id;
        TextView name;
        TextView username;
        TextView email;
        TextView street;
        TextView suite;
        TextView city;
        TextView zipcode;
        TextView lat;
        TextView lng;
        TextView phone;
        TextView website;
        TextView companyName;
        TextView catchPhrase;
        TextView bs;

        public ViewHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            username = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);
            street = itemView.findViewById(R.id.street);
            suite = itemView.findViewById(R.id.suite);
            city = itemView.findViewById(R.id.city);
            zipcode = itemView.findViewById(R.id.zipcode);
            lat = itemView.findViewById(R.id.lat);
            lng = itemView.findViewById(R.id.lng);
            phone = itemView.findViewById(R.id.phone);
            website = itemView.findViewById(R.id.website);
            companyName = itemView.findViewById(R.id.companyName);
            catchPhrase = itemView.findViewById(R.id.catchPhrase);
            bs = itemView.findViewById(R.id.bs);
        }

        public void setInfo(User user) {
            id.setText(String.valueOf(user.getId()));
            name.setText(user.getName());
            username.setText(user.getUsername());
            email.setText(user.getEmail());
            street.setText(user.getAddress().getStreet());
            suite.setText(user.getAddress().getSuite());
            city.setText(user.getAddress().getCity());
            zipcode.setText(user.getAddress().getZipcode());
            lat.setText(user.getAddress().getGeo().getLat());
            lng.setText(user.getAddress().getGeo().getLng());
            phone.setText(user.getPhone());
            website.setText(user.getWebsite());
            companyName.setText(user.getCompany().getName());
            catchPhrase.setText(user.getCompany().getCatchPhrase());
            bs.setText(user.getCompany().getBs());
        }
    }
}
