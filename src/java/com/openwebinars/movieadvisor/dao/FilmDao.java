package java.com.openwebinars.movieadvisor.dao;

import java.com.openwebinars.movieadvisor.model.Film;
import java.util.Collection;

public interface FilmDao {
	public Film findById(long id);
	public Collection<Film> findAll();
	public void insert(Film film);
	public void delete(long id);
}
