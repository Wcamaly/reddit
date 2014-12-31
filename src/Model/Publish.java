package Model;

import Extras.Utils;

public class Publish {
	
	private String title;
	private String autor;
	private String comments;
	private String thumbail;
	private String bigImage;
	private String date;
	public Publish (){
		this.title = null;
		this.autor = null;
		this.comments = null;
		this.thumbail = null;
		this.bigImage = null;
		this.date = null;
	}
	public Publish (String title, String autor, String comments, String thumbail, String bigImage, Long date){
		this.title = title;
		this.autor = autor;
		this.comments = comments;
		this.thumbail = thumbail;
		this.bigImage = bigImage; 
		this.date = Utils.ChangeDate(date);
	}
	
	public String getTitle(){
		return this.title;
	}
	public String getAutor(){
		return this.autor;
	}
	public String getCommnets(){
		return this.comments;
	}
	public String getThumbail(){
		return this.thumbail;
	}
	public String getBigImage(){
		return this.bigImage;
	}
	public String getDate(){
		return this.date;
	}
}
