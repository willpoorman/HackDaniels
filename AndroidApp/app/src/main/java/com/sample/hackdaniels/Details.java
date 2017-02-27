package com.sample.hackdaniels;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by User1 on 2/18/2017.
 */

public class Details extends Fragment implements CallBackListener{
    JSONTask task;
    LinearLayout barsView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.details, container, false);

        Bundle b = getArguments();
        String barName = b.getString("name");
        barName = barName.replaceAll(" ","%20");

        barsView = (LinearLayout) rootView.findViewById(R.id.description);

        task = new JSONTask();
        task.setListener(this);
        task.execute("http://10.30.126.110/~shelby/api/index.php/businesses/name=" + barName);

        return rootView;
    }

    @Override
    public void callback(String result) {
        try {
            TextView detail = new TextView(getActivity());
            System.out.println(result);
            JSONArray jsonarray = new JSONArray(result);
            JSONObject jsonobject = jsonarray.getJSONObject(0);
            String desciption = jsonobject.getString("description");
            detail.setText(desciption);
            detail.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            barsView.addView(detail);
        }
        catch(JSONException e){
            e.printStackTrace();
        }
    }
}
