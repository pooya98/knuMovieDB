package controller;

import resource.R;

public class RateController implements R{
	public void process() {
		if(rateView.show2() == true) {
			request.put("rate_success", true);
		}else {
			request.put("rate_success", false);
		}
	}
}
