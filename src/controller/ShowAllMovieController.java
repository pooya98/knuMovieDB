package controller;

import java.util.List;

import model.MovieDAO;
import model.MovieDTO;
import resource.R;

public class ShowAllMovieController implements R {

	public void process() {

		MovieDAO dao = new MovieDAO();
		List<MovieDTO> list = dao.list_for_all();
		
		showAllMovieView.list(list);
		
		out.println("\n È®ÀÎ (Enter) >");
		scan.nextLine();	
	}
}
