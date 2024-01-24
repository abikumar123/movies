package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.mysql.cj.protocol.Resultset;

import dto.Admin;
import dto.Movie;
import dto.User;

public class Dao {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/movies ? user=root & password=root");
		
	}
	public int saveAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("insert into admin values(?,?,?,?,?)");
		pst.setInt(1, admin.getAdminid());
		pst.setString(2, admin.getAdminname());
		pst.setLong(3, admin.getAdmincontact());
		pst.setString(4, admin.getAdminmail());
		pst.setString(5, admin.getAdminpassword());
		
		return pst.executeUpdate();
	}
	public int saveUser(User user) throws ClassNotFoundException, SQLException {
		
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("insert into user values(?,?,?,?,?)");
		pst.setInt(1, user.getUserid());
		pst.setString(2, user.getUsername());
		pst.setLong(3, user.getUsercontact());
		pst.setString(4, user.getUsermail());
		pst.setString(5, user.getUserpassword());
		
		return pst.executeUpdate();
	}
	public Admin findByEmailAdmin(String email) throws ClassNotFoundException, SQLException  {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("select * from admin where adminmail=?");
		pst.setString(1, email);
		ResultSet rs=pst.executeQuery();
		Admin admin=new Admin();
		if(rs.next()) {
		admin.setAdminid(rs.getInt(1));
		admin.setAdminname(rs.getString(2));
		admin.setAdmincontact(rs.getLong(3));
		admin.setAdminmail(rs.getString(4));
		admin.setAdminpassword(rs.getString(5));
		
		return admin;
		}else {
			return null;
		}
			
	}
	public User findByEmailUser(String email) throws ClassNotFoundException, SQLException {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("select * from user where usermail=?");
		pst.setString(1, email);
		ResultSet rs=pst.executeQuery();
		
		User user=new User();
		if(rs.next()) {
		user.setUserid(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setUsercontact(rs.getLong(3));
		user.setUsermail(rs.getString(4));
		user.setUserpassword(rs.getString(5));
		
		return user;
		}else {
			return null;
		}
		
		
	}
	public int saveMovie(Movie movie) throws ClassNotFoundException, SQLException {
		
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("insert into movie values(?,?,?,?,?,?,?,?)");
		pst.setInt(1, movie.getMovieid());
		pst.setString(2, movie.getMoivename());
		pst.setDouble(3, movie.getMovieprice());
		pst.setDouble(4, movie.getMovierating());
		pst.setString(5, movie.getMoviegenre());
		pst.setString(6, movie.getMovielanguage());
		
		
		Blob iamgeBlob =new SerialBlob(movie.getMovieimage());
		pst.setBlob(7, iamgeBlob);
		
		pst.setString(8, movie.getMovieDescription());
		
		return pst.executeUpdate();
		
		
	}
	public List<Movie> getallmovies() throws ClassNotFoundException, SQLException {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("select * from movie");
		ResultSet rs=pst.executeQuery();
		
		List<Movie>  movies=new ArrayList<Movie>();
		
		while(rs.next()) {
			Movie movie=new Movie();
			movie.setMovieiid(rs.getInt(1));
			movie.setMoivename(rs.getString(2));
			movie.setMovieprice(rs.getDouble(3));
			movie.setMovierating(rs.getDouble(4));
			movie.setMoviegenre(rs.getString(5));
			movie.setMovielanguage(rs.getString(6));
			
			Blob b=rs.getBlob(7);
			byte[] img=b.getBytes(1, (int)b.length());
			movie.setMovieimage(img);
			movie.setMovieDescription(rs.getString(8));
			movies.add(movie);
			
			
		}
		return movies;
		
	}
	
	public int deleteMovie(int id) throws ClassNotFoundException, SQLException {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("delete from movie where movieid=?");
		pst.setInt(1, id);
		return pst.executeUpdate();
	}
	public Movie findByMovieId(int movieId) throws ClassNotFoundException, SQLException {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("select * from movie where movieid=?");
		pst.setInt(1, movieId);
		ResultSet rs=pst.executeQuery();
		rs.next();
		
		Movie movie=new Movie();
		movie.setMovieiid(rs.getInt(1));
		movie.setMoivename(rs.getString(2));
		movie.setMovieprice(rs.getDouble(3));
		movie.setMovierating(rs.getDouble(4));
		movie.setMoviegenre(rs.getString(5));
		movie.setMovielanguage(rs.getString(6));
		
		Blob b=rs.getBlob(7);
		byte[] img=b.getBytes(1, (int)b.length());
		movie.setMovieimage(img);
		movie.setMovieDescription(rs.getString(8));
		
		return movie;
		
		
	}
	public int updateMovie(Movie movie) throws ClassNotFoundException, SQLException {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("update movie set moviename=?,movieprice=?,movierating=?,moviegenre=?,movielanguage=?,movieimage=? where movieid=?");
		pst.setString(1, movie.getMoivename());
		pst.setDouble(2, movie.getMovieprice());
		pst.setDouble(3, movie.getMovierating());
		pst.setString(4, movie.getMoviegenre());
		pst.setString(5, movie.getMovielanguage());
		

		Blob iamgeBlob =new SerialBlob(movie.getMovieimage());
		pst.setBlob(6, iamgeBlob);
		pst.setInt(7, movie.getMovieid());
		
		
		return pst.executeUpdate();
		
	}
	public List<Movie> getUserMovies(int id) throws SQLException, ClassNotFoundException {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("select * from movie inner join buymovie where buymovie.userid=? and movie.movieid=buymovie.movieid ");
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		
        List<Movie>  movies=new ArrayList<Movie>();
		
		while(rs.next()) {
			Movie movie=new Movie();
			movie.setMovieiid(rs.getInt(1));
			movie.setMoivename(rs.getString(2));
			movie.setMovieprice(rs.getDouble(3));
			movie.setMovierating(rs.getDouble(4));
			movie.setMoviegenre(rs.getString(5));
			movie.setMovielanguage(rs.getString(6));
			
			Blob b=rs.getBlob(7);
			byte[] img=b.getBytes(1, (int)b.length());
			movie.setMovieimage(img);
			movie.setMovieDescription(rs.getString(8));
			movies.add(movie);
			
		}
		return movies;
		
	}
	

}
