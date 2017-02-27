package com.sample.hackdaniels; /**
 * Created by User1 on 2/17/2017.
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.net.Proxy.Type.HTTP;

public class HomeTab extends Fragment{

    TextView tv;
    JSONTask task;
    View rootView;

    public List<TextView> textBoxes = new ArrayList<TextView>();
    public String dayGiven;
    public int amountofenteriesdeleted;
    public int sunint,monint,tueint,wedint,thuint,friint,satint;
    public int daysubtracter;
    //TableRow LL = (TableRow) findViewById(R.id.tryhere);
    public List<TableRow> LL = new ArrayList<TableRow>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.home, container, false);

        setButtons();

        /*homeView = (LinearLayout) rootView.findViewById(R.id.test);
        Button button = (Button) rootView.findViewById(R.id.button);
        tv = (TextView) rootView.findViewById(R.id.textView4);
        task = new JSONTask();
        task.setListener(this);
        task.execute("http://10.30.126.110/~shelby/api/index.php/businesses/type=bar");*/

        return rootView;
    }

    public void create(String RestName, String Specials, String time, int EntryNumber, String day)
    {

        RelativeLayout ll = (RelativeLayout) rootView.findViewById(R.id.Relative);
        System.out.println(dayGiven);
        for( int s = 0; s<100;s++)
        {
            textBoxes.add(s,new TextView(getActivity()));
        }

        if(day.equals("Sun"))
        { // add all the other days together and subtract it from entry number
            EntryNumber -= sunint;

        }
        else{
            sunint++;
        }

        if(day.equals("Mon"))
        {
            EntryNumber -= monint;
        }
        else{
            monint++;
        }

        if(day.equals("Tue"))
        {
            EntryNumber -= tueint;
        }
        else{
            tueint++;
        }

        if(day.equals("Wed"))
        {
            EntryNumber -= wedint;
        }
        else{
            wedint++;
            // subtract from the total in the loop! because you know there that what type of day it is!
        }

        if(day.equals("Thu"))
        {
            EntryNumber -= thuint;
        }
        else{
            thuint++;
        }

        if(day.equals("Fri"))
        {
            EntryNumber -= friint;
        }
        else{
            friint++;
        }

        if(day.equals("Sat"))
        {
            EntryNumber -= satint;
        }
        else{
            satint++;
        }
        // just should be subtracting one from daysubtracter
        // EntryNumber -= daysubtracter;
        textBoxes.get(EntryNumber*3).setHeight(500);
        textBoxes.get(EntryNumber*3).setWidth(500);
        textBoxes.get(EntryNumber*3).setTextSize(20);
        textBoxes.get(EntryNumber*3).setX(0);
        textBoxes.get(EntryNumber*3).setY(30);
        textBoxes.get(EntryNumber*3).setTextColor(Color.WHITE);
        textBoxes.get(EntryNumber*3).setBackgroundColor(Color.BLACK);
        textBoxes.get(EntryNumber*3).setText(RestName);
        // if day type = given type
        if(day.equals(dayGiven)) {
            LL.get(EntryNumber).addView(textBoxes.get(EntryNumber * 3));
        }
        textBoxes.get(EntryNumber*3+1).setHeight(500);
        textBoxes.get(EntryNumber*3+1).setWidth(500);
        textBoxes.get(EntryNumber*3 +1).setTextSize(20);
        textBoxes.get(EntryNumber*3+1).setX(30);
        textBoxes.get(EntryNumber*3+1).setY(30);
        textBoxes.get(EntryNumber*3+1).setBackgroundColor(Color.BLACK);
        textBoxes.get(EntryNumber*3+1).setTextColor(Color.WHITE);
        textBoxes.get(EntryNumber*3+1).setText(Specials);
        if(day.equals(dayGiven)) {
            LL.get(EntryNumber).addView(textBoxes.get(EntryNumber * 3 + 1));
        }
        textBoxes.get(EntryNumber*3+2).setHeight(500);
        textBoxes.get(EntryNumber*3+2).setWidth(500);
        textBoxes.get(EntryNumber*3+2).setTextSize(20);
        textBoxes.get(EntryNumber*3+2).setX(60);
        textBoxes.get(EntryNumber*3+2).setY(30);
        textBoxes.get(EntryNumber*3+2).setBackgroundColor(Color.BLACK);
        textBoxes.get(EntryNumber*3+2).setTextColor(Color.WHITE);
        textBoxes.get(EntryNumber*3+2).setText(time);
        if(day.equals(dayGiven)) {
            LL.get(EntryNumber).addView(textBoxes.get(EntryNumber * 3 + 2));
        }

    }
    void setButtons()
    {
        Button button = (Button) rootView.findViewById(R.id.Sun);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dayGiven = "Sun";
                ButtonCalls();

            }

        });
        Button button1 = (Button) rootView.findViewById(R.id.Mon);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dayGiven = "Mon";
                ButtonCalls();
            }

        });
        Button button2 = (Button) rootView.findViewById(R.id.Tues);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dayGiven = "Tue";
                ButtonCalls();
            }

        });
        Button button3 = (Button) rootView.findViewById(R.id.Wed);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dayGiven = "Wed";
                ButtonCalls();
            }

        });
        Button button4 = (Button) rootView.findViewById(R.id.Thurs);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dayGiven = "Thu";
                ButtonCalls();
            }

        });
        Button button5 = (Button) rootView.findViewById(R.id.Frid);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dayGiven = "Fri";
                ButtonCalls();
            }

        });
        Button button6 = (Button) rootView.findViewById(R.id.Sat);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dayGiven = "Sun";
                ButtonCalls();
            }

        });


    }
    public void ButtonCalls()
    {
        int subtract =0 ;
        if(dayGiven.equals("Sun"))
        {
            subtract = sunint;
        }
        if(dayGiven.equals("Mon"))
        {
            subtract = monint;
        }
        if(dayGiven.equals("Tue"))
        {
            subtract = tueint;
        }
        if(dayGiven.equals("Wed"))
        {
            subtract = wedint;
        }
        if(dayGiven.equals("Thu"))
        {
            subtract = thuint;
        }
        if(dayGiven.equals("Fri"))
        {
            subtract = friint;
        }
        if(dayGiven.equals("Sat"))
        {
            subtract = satint;
        }


        sunint = 0; monint = 0; tueint = 0; wedint = 0; thuint = 0; friint =0; satint=0;
        for(int p = 0; p < subtract; p++)
        {
            LL.get(p).removeAllViews();
            // this needs to be fixed now
        }
        LL.add(0,(TableRow) rootView.findViewById(R.id.tryhere));
        LL.add(1, (TableRow) rootView.findViewById(R.id.TableRow1));
        LL.add(2, (TableRow) rootView.findViewById(R.id.TableRow2));
        LL.add(3, (TableRow) rootView.findViewById(R.id.TableRow3));
        LL.add(4, (TableRow) rootView.findViewById(R.id.TableRow4));
        LL.add(5, (TableRow) rootView.findViewById(R.id.TableRow5));
        LL.add(6, (TableRow) rootView.findViewById(R.id.TableRow6));
        LL.add(7, (TableRow) rootView.findViewById(R.id.TableRow7));
        LL.add(8, (TableRow) rootView.findViewById(R.id.TableRow8));
        LL.add(9, (TableRow) rootView.findViewById(R.id.TableRow9));

        create("Dari Diner", "$2 off BBQ sandwhich", "All Day", 0, "Mon");
        create("DamnGoodPies", "$5 off Large Pizza" , "5:00pm to 7:00pm", 1, "Tue");
        create("Waffle House", "$5 all you can eat", "12:00am to 12:00pm", 2, "Wed");
        create("Hammontree's Grilled Cheese", "$1 off every purchase", "All day", 3, "Thu");
        create("Theo's", "Free cocktail", "9:00pm to 11:00pm", 4, "Mon");
        create("Emelias's kitchen", "$1 coffee", "All day", 5, "Mon");
        create("Tokyo Shushi and Bar", "-$2 on California roll", "5:00pm to close", 6, "Mon");
        create("Flying Burrito", "$3 burrito", "All day", 7, "Mon");
        create("Jimmy Johns", "Buy 2 subs get 1 free", "All day", 8, "Tue");
        create("Chipolte", "No-Shit burrito $3.50", "All Day", 9, "Fri" );

    }
    void Fixnumbers()
    {

    }
    //you can keep adding code to change myTextView
    // setContentView(myTextView);
}

    /*@Override
    public void callback(String result) {
        try {
            System.out.println(result);
            JSONArray jsonarray = new JSONArray(result);
            for (int i = 0; i < jsonarray.length(); i++) {
                TextView Bar = new TextView(getActivity());
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                String description = jsonobject.getString("description");
                String name = jsonobject.getString("name");
                Bar.setText(name + " : " + description);
                Bar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
                homeView.addView(Bar);
            }
        }
        catch(JSONException e){
            e.printStackTrace();
        }
    }*/

