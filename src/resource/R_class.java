package resource;

public class R_class implements R {

	public void put(String a, String b) {
		req.put(a,b);
	}
	
	public Object get(String a) {
		return req.get(a);
	}
}
