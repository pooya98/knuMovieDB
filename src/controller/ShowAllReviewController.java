package controller;

import java.util.List;

import model.RatingDAO;
import model.RatingDTO;
import resource.R;

public class ShowAllReviewController implements R {
	public void process() {
		
		RatingDAO dao = new RatingDAO();
		List<RatingDTO> list = dao.AllList();
		
		showAllReviewView.show2(list);
	}

}
