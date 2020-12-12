package controller;

import resource.R;

public class InsertContentsController implements R {

	public void process() {
		while (true) {
			insertContentsMenu.show();

			if ((int) request.get("insert_contents_select_no") == 1) {
				insertMovieController.process();
			}
			if ((int) request.get("insert_contents_select_no") == 2) {
				insertEpisodeController.process();
			}
			if ((int) request.get("insert_contents_select_no") == 3) {
				insertVersionController.process();
			}
			if ((int) request.get("insert_contents_select_no") == 4) {
				return;
			}

		}
	}
}
