package com.sample.hackdaniels;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import static java.net.Proxy.Type.HTTP;

/**
 * Created by User1 on 2/17/2017.
 */

public class BarTab extends Fragment implements CallBackListener{

    JSONTask task;
    LinearLayout barsView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bars, container, false);

        barsView = (LinearLayout) rootView.findViewById(R.id.bars);

        task = new JSONTask();
        task.setListener(this);
        task.execute("http://10.30.126.110/~shelby/api/index.php/businesses/type=bar");

        return rootView;
    }

    @Override
    public void callback(String result) {
        try {
            Button Bar;
            System.out.println(result);
            JSONArray jsonarray = new JSONArray(result);
            for (int i = 0; i < jsonarray.length(); i++) {
                Bar = new Button(getActivity());
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                final String name = jsonobject.getString("name");
                Bar.setText(name);
                Bar.setId(i);
                Bar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
                Bar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), BarHost.class);
                        intent.putExtra("name", name);
                        startActivity(intent);
                    }
                });
                barsView.addView(Bar);
            }

        }
        catch(JSONException e){
            e.printStackTrace();
        }
    }
}
