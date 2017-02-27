package com.sample.hackdaniels;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by User1 on 2/18/2017.
 */

public class Map extends Fragment implements CallBackListener{

    JSONTask task;
    LinearLayout barsView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location, container, false);

        Bundle b = getArguments();
        String barName = b.getString("name");
        barName = barName.replaceAll(" ","%20");

        barsView = (LinearLayout) rootView.findViewById(R.id.location);

        task = new JSONTask();
        task.setListener(this);
        task.execute("http://10.30.126.110/~shelby/api/index.php/businesses/name=" + barName);

        return rootView;
    }

    @Override
    public void callback(String result) {
        try {
            TextView location = new TextView(getActivity());
            System.out.println(result);
            JSONArray jsonarray = new JSONArray(result);
            JSONObject jsonobject = jsonarray.getJSONObject(0);
            String address = jsonobject.getString("address");
            location.setText(address);
            location.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            barsView.addView(location);
        }
        catch(JSONException e){
            e.printStackTrace();
        }
    }
}
