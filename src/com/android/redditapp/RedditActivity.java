package com.android.redditapp;

import Adapters.AdapterReddit;
import Extras.Utils;
import Model.Publish;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class RedditActivity extends RestActivity {

	String pettion = "top.json?limit=50";
	String method ="GET";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reddit);
		ListView listview = (ListView) findViewById(R.id.lredit);
		AdapterReddit adapter = new AdapterReddit(this , R.layout.list_redit, listpubli);
		listview.setAdapter(adapter);
		
		makeRequest(pettion, method,adapter);
		
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Publish item = (Publish) parent.getItemAtPosition(position);
				
				if (Utils.hasImage(item.getBigImage())){
					Intent intent= new Intent(RedditActivity.this, ImageActivity.class);
					Bundle im = new Bundle();
					im.putString("image",item.getBigImage() );
					intent.putExtras(im);
					startActivity(intent);
				}else
				{
					Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(item.getBigImage()));
					startActivity(intent);
				}
				
				
				
				
				
				
				
			}
		});
	
	}
	
	

	
	
	
}
