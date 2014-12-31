package Extras;

import java.sql.Date;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class Utils {
	private static VolleyServices volleys;
	private static RequestQueue rq;
	private static Bitmap thumbail;

	public static Bitmap LoadThumbail (String url, Context context){
		volleys = VolleyServices.getInstance(context);
		rq = volleys.getRequestQueue();
		
			ImageRequest image = new ImageRequest(url, new Response.Listener<Bitmap>() {

				@Override
				public void onResponse(Bitmap imge) {
					thumbail = imge;
				}
			}, 0, 0, null, new Response.ErrorListener() {

				@Override
				public void onErrorResponse(VolleyError arg0) {
					thumbail = null;
					
				}
			});
		rq.add(image);
		
		return thumbail;
	}
	
	
	static public String ChangeDate (String utc){
		long lutc = Long.parseLong(utc);
		Date date = new Date(lutc);
		return date.toString();
	}
	
	
	
}
