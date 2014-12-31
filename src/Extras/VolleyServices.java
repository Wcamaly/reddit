package Extras;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyServices {
	private static VolleyServices volleys = null;
	// This is the thread. 
	private RequestQueue mrequest;
	private VolleyServices (Context context){
		mrequest  = Volley.newRequestQueue(context);
	}
	public static VolleyServices getInstance (Context context){
		if (volleys == null){
			volleys = new VolleyServices(context);
		}
		return volleys;
	}
	 public RequestQueue getRequestQueue() {
	        return mrequest;
	    }
}



