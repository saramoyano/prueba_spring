package java.com.openwebinars.movieadvisor.service;

import java.com.openwebinars.movieadvisor.model.Film;
import java.util.Collection;

public interface FilmQueryService {
	public Collection<Film> exec();
	public FilmQueryService anyGenre(String... genres);
	public FilmQueryService allGenres(String... genres);
	public FilmQueryService year(String year);
	public FilmQueryService betweenYears(String from, String to);
	public FilmQueryService titleContains(String title); 
}
