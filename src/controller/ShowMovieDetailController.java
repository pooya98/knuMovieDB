package controller;

import java.util.List;

import model.MovieDAO;
import model.MovieDTO;

import resource.R;

public class ShowMovieDetailController implements R {

	public void process(String title) {
		
		MovieDAO dao = new MovieDAO();
		List<MovieDTO> list = dao.list_for_title_search(title);
		
		showMovieDetailView.show2(list, title);

		if ((boolean) request.get("iwillrate") == true) {
			rateController.process();
			
			if((boolean)request.get("rate_success")  == true) {
				return;
			}
		}
	}
}
