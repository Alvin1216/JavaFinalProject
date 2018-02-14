package Java_Final_Project.FirstClass;

import java.io.*;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
public class read_test {
  public static void main(String[] args) {
	  TmdbMovies movies = new TmdbApi("926770d103fd7e9324ececff35eceefa").getMovies();
	  MovieDb movie = movies.getMovie(166426, "en");
	  System.out.println(movie.getTitle());
  }
    /*File f=new File("Posters");
    File [] f1=f.listFiles();
    for(int i=0;i<f.listFiles().length;i++){
    		System.out.println(f1[i]);
    		System.out.println(f1[i].getName());
    	}
  	}*/
  }