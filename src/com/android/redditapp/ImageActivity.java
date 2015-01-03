package com.android.redditapp;

import Extras.Utils;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

public class ImageActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		Bundle im = this.getIntent().getExtras();
		ImageView img = (ImageView) findViewById(R.id.timage);
		Bitmap bitmap = Utils.LoadThumbail(im.getString("image"), this);
		img.setImageBitmap(bitmap);
		 		
	}

	
}
