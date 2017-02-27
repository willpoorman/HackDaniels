package com.sample.hackdaniels;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by User1 on 2/17/2017.
 */

public class RestaurantTab extends Fragment implements CallBackListener{

    LinearLayout restaurantsView;
    JSONTask task;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.restaurants, container, false);

        restaurantsView = (LinearLayout) rootView.findViewById(R.id.restaurants);

        task = new JSONTask();
        task.setListener(this);
        task.execute("http://10.30.126.110/~shelby/api/index.php/businesses/type=restaurant");

        return rootView;
    }

    @Override
    public void callback(String result) {
        try {
            Button Restaurant;
            System.out.println(result);
            JSONArray jsonarray = new JSONArray(result);
            for (int i = 0; i < jsonarray.length(); i++) {
                Restaurant = new Button(getActivity());
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                final String name = jsonobject.getString("name");
                Restaurant.setText(name);
                Restaurant.setId(i);
                Restaurant.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
                Restaurant.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), BarHost.class);
                        intent.putExtra("name", name);
                        startActivity(intent);
                    }
                });
                restaurantsView.addView(Restaurant);
            }

        }
        catch(JSONException e){
            e.printStackTrace();
        }
    }
}
