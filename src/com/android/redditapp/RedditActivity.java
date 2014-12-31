package com.android.redditapp;

import java.util.ArrayList;

import Adapters.AdapterReddit;
import Model.Publish;
import android.os.Bundle;
import android.widget.ListView;

public class RedditActivity extends RestActivity {

	String pettion = "top.json";
	String method ="GET";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reddit);
		ListView listview = (ListView) findViewById(R.id.lredit);
		AdapterReddit adapter = new AdapterReddit(this , R.layout.list_redit, listpubli);
		listview.setAdapter(adapter);
		
		makeRequest(pettion, method,adapter);
	
	
		
	}

	
	
	
}
