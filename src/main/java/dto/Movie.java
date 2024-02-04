package dto;

public class Movie {
	
	private int movieid;
	private String moivename;
	private double movieprice;
	private double movierating;
	private String moviegenre;
	private String movielanguage;
	private byte[] movieimage;
	private String  moviedescription;
	private String movielink;
	
	public String getMovielink() {
		return movielink;
		
	}
	public void setMovielink(String movielink) {
		this.movielink=movielink;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieiid(int movieiid) {
		this.movieid = movieiid;
	}
	public String getMoivename() {
		return moivename;
	}
	public void setMoivename(String moivename) {
		this.moivename = moivename;
	}
	public double getMovieprice() {
		return movieprice;
	}
	public void setMovieprice(double movieprice) {
		this.movieprice = movieprice;
	}
	public double getMovierating() {
		return movierating;
	}
	public void setMovierating(double movierating) {
		this.movierating = movierating;
	}
	public String getMoviegenre() {
		return moviegenre;
	}
	public void setMoviegenre(String moviegenre) {
		this.moviegenre = moviegenre;
	}
	public String getMovielanguage() {
		return movielanguage;
	}
	public void setMovielanguage(String movielanguage) {
		this.movielanguage = movielanguage;
	}
	public byte[] getMovieimage() {
		return movieimage;
	}
	public void setMovieimage(byte[] movieimage) {
		this.movieimage = movieimage;
	}
	public String getMovieDescription() {
		return moviedescription;
	}
	public void setMovieDescription(String md) {
		this.moviedescription=md;
	}
	
	
	

}
