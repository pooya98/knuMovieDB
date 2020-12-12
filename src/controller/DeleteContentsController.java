package controller;

import resource.R;

public class DeleteContentsController implements R {

	public void process() {
		while (true) {
			deleteContentsMenu.show();

			if ((int) request.get("delete_contents_select_no") == 1) {
				deleteMovieController.process();
			}
			if ((int) request.get("delete_contents_select_no") == 2) {
				deleteEpisodeController.process();
			}
			if ((int) request.get("delete_contents_select_no") == 3) {
				deleteVersionController.process();
			}
			if ((int) request.get("delete_contents_select_no") == 4) {
				return;
			}

		}
	}
}
