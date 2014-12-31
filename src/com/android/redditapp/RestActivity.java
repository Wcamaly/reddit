package com.android.redditapp;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Extras.VolleyServices;
import Model.Publish;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

public class RestActivity extends ActionBarActivity {
	private VolleyServices volleys;
	protected RequestQueue request;
	private String url = "http://www.reddit.com/";
	private ArrayList<Publish> listpubli;
	
	public void onCreate(Bundle saveinstances){
		super.onCreate(saveinstances);
		volleys = VolleyServices.getInstance(getApplicationContext());
		request = volleys.getRequestQueue();
	}
	public void onStop(){
		super.onStop();
		if(request != null)
			request.cancelAll(this);
	}
	public void onPreStartConnection() {
        this.setProgressBarIndeterminateVisibility(true);
    }
    public void onConnectionFinished() {
        this.setProgressBarIndeterminateVisibility(false);
    }
    public void onConnectionFailed(String error) {
        this.setProgressBarIndeterminateVisibility(false);
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    public void addToQueue (Request req){
    	if( req != null){
    		req.setTag(this);
    		if( request == null){
    			request = volleys.getRequestQueue();
    		}
    		req.setRetryPolicy(new DefaultRetryPolicy(6000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) );
    		onPreStartConnection();
    		request.add(req);
    	}	
    }
    
    public void makeRequest (String pettion,String method){
    	int met;
    	if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT"))
    	{	met = Request.Method.PUT;} 
    	else{
    		met = Request.Method.GET;
    	}
    		JsonObjectRequest jsonrequest = new JsonObjectRequest(met, url+pettion, null, 
    				new Response.Listener<JSONObject>() {

						@Override
						public void onResponse(JSONObject response) {
							try {
								JSONArray jsonarry = response.getJSONObject("data").getJSONArray("children");
								for (int i=0; i<jsonarry.length(); i++){
									
									JSONObject json = jsonarry.getJSONObject(i).getJSONObject("data");
									Publish publ = new Publish(json.getString("title"),json.getString("author"),
											json.getString("num_comments"),json.getString("thumbnail"),json.getString("url"),
											json.getString("created_utc"));
									listpubli.add(publ);									
								}
							
							} catch (JSONException e) {
								e.printStackTrace();
							}
						}
					}, new Response.ErrorListener() {

						@Override
						public void onErrorResponse(VolleyError error) {
							Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
							
						}
					});
    		addToQueue(jsonrequest);
    
	}
    
    public ArrayList<Publish> getListPublish (){
    	return listpubli;
    }

}
