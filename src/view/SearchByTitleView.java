package view;

public class SearchByTitleView implements View {

	String title;

	@Override
	public void show() {
		out.print("\n---- 제목으로 검색 ----\n");

		out.print("검색 : ");

		title = scan.nextLine();

		while (true) {
			if (title.replaceAll(" ", "").equals("")) {
				out.println("검색어를 입력해주세요.");
			}
			else
				break;
		}
		request.put("title_to_search", title);
	}
}
