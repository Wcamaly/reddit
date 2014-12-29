package Adapters;

import java.util.List;

import Model.ViewHolderReddit;
import Model.publish;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.redditapp.R;
//import android.R;

public class AdapterReddit extends ArrayAdapter<publish> {

	Activity ctx;
	int lis;
	List<publish> obj;
	public AdapterReddit(Context context, int resource, List<publish> objects) {
		super(context, resource, objects);
		this.ctx = (Activity) context;
		this.lis = resource;
		this.obj = objects;
	}
	
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolderReddit holder = null;
		
		if(convertView == null){
			LayoutInflater inflate = ctx.getLayoutInflater();
			convertView = inflate.inflate(this.lis, null);			
			holder = new ViewHolderReddit();
			
			holder.autor = (TextView) convertView.findViewById(R.id.author);
			holder.comments= (TextView) convertView.findViewById(R.id.comment);
			holder.date = (TextView) convertView.findViewById(R.id.date);
			holder.thumbail = (ImageView) convertView.findViewById(R.id.thumbail);
			holder.title = (TextView) convertView.findViewById(R.id.titlepublish);
			
			convertView.setTag(holder);
	
		}else {
			holder = (ViewHolderReddit) convertView.getTag();
		}
		
		publish publ = obj.get(position);
		
		if (publ != null ){
			holder.autor.setText(publ.getAutor());
			holder.comments.setText(publ.getCommnets());
			holder.date.setText(publ.getDate());
			holder.thumbail.setImageBitmap(bm);
			
		}
		return convertView;
	}
	
	

}
