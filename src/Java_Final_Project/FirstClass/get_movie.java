package Java_Final_Project.FirstClass;

import java.util.List;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbMovies.MovieMethod;
import info.movito.themoviedbapi.model.*;

public class get_movie {
	private static TmdbMovies movies = new TmdbApi("926770d103fd7e9324ececff35eceefa").getMovies();
	private static MovieDb movie =null; 
	
	public String movie_image_url="https://image.tmdb.org/t/p/w342";
	public String movie_title;
	public String movie_path;
	public String movie_overview;
	public String movie_release;
	public MovieImages movie_image;
	public List<Artwork> poster;
	
	public get_movie(int movie_id){
		movie=movies.getMovie(movie_id, "en-US");
		movie_title=movie.getTitle();
		movie_overview=movie.getOverview();
		movie_release=movie.getReleaseDate();
		movie_path=movie.getPosterPath();
	}
}
