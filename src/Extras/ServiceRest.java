package Extras;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;

public class ServiceRest extends AsyncTask<Void, Void, String> {

	String Urlrest;
	
	ServiceRest(String url){
		super();
		this.Urlrest = url;
	}
	
	public String requestServer (ArrayList<NameValuePair> params, String petion, String method){
			HttpClient httpclient = new DefaultHttpClient();
			
			StringBuilder sb = new StringBuilder();
			for (NameValuePair param:params){
				if(sb.length()>0){
					sb.append("&");
				}
			sb.append(param.getName() + "=" + param.getValue());
			}
			HttpResponse response = null;
			try {
				
				if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT")){
					HttpPost result = new HttpPost(this.Urlrest+petion+"?"+sb.toString());
					result.setHeader("content-type", "application/json");
					response  = httpclient.execute(result);
		
				}else {
					HttpGet result = new HttpGet(this.Urlrest+petion+"?"+sb.toString());
					result.setHeader("content-type", "application/json");
					response  = httpclient.execute(result);
				}
				
				return EntityUtils.toString(response.getEntity());
			     
			 }
			 catch(Exception ex)
			   {
			      Log.e("ServicioRest","Error!", ex);
			      return "";
			   }	
	}

	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
