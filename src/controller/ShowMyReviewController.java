package controller;

import java.util.List;

import model.RatingDAO;
import model.RatingDTO;
import resource.R;

public class ShowMyReviewController implements R {
	
	public void process() {
		
		RatingDAO dao = new RatingDAO();
		List<RatingDTO> list = dao.myList();
		
		showMyReviewView.show2(list);
	}
	
	
}
