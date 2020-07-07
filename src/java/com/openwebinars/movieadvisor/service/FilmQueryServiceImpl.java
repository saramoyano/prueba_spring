package java.com.openwebinars.movieadvisor.service;

import java.com.openwebinars.movieadvisor.dao.FilmDao;
import java.com.openwebinars.movieadvisor.model.Film;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmQueryServiceImpl implements FilmQueryService {

	@Autowired
	private FilmDao dao;
	
	private Predicate<Film> predicate;
	
	@PostConstruct
	public void init() {
		predicate = null;
	}
	
	@Override
	public Collection<Film> exec() {
		
		return dao.findAll().stream().filter(predicate).collect(Collectors.toList());
	}

	@Override
	public FilmQueryService anyGenre(String... genres) {
		Predicate<Film> pAnyGenre = (film -> Arrays.stream(genres).anyMatch(film.getGenres()::contains));
		predicate = (predicate == null)? pAnyGenre : predicate.and(pAnyGenre);
		return this;
	}

	@Override
	public FilmQueryService allGenres(String... genres) {
		Predicate<Film> pAllGenres = (film -> Arrays.stream(genres).allMatch(film.getGenres()::contains));
		predicate = (predicate == null)? pAllGenres : predicate.and(pAllGenres);
		return this;
	}

	@Override
	public FilmQueryService year(String year) {
		Predicate<Film> pYear = (film ->film.getYear().equalsIgnoreCase(year));
		predicate = (predicate == null)? pYear : predicate.and(pYear);
		return this;
	}

	@Override
	public FilmQueryService betweenYears(String from, String to) {
		Predicate<Film> pBetweenYears = (film -> {
			LocalDate fromYear = LocalDate.of(Integer.parseInt(from), 1, 1);
			LocalDate toYear = LocalDate.of(Integer.parseInt(to), 1, 3);
			LocalDate filmYear = LocalDate.of(Integer.parseInt(film.getYear()), 1, 2);
					
			return filmYear.isAfter(fromYear) && filmYear.isBefore(toYear);
			});
		predicate = (predicate == null)? pBetweenYears : predicate.and(pBetweenYears);
		return this;
	}

	@Override
	public FilmQueryService titleContains(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}

