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
		ListView list = (ListView) findViewById(R.id.lredit);
		makeRequest(pettion, method);
		ArrayList<Publish> list1 = getListPublish();
		
		AdapterReddit adapter = new AdapterReddit(getApplicationContext(), R.layout.list_redit, list1);
		
		list.setAdapter(adapter);
	}

	
	
	
}
