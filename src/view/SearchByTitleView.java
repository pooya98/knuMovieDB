package view;

public class SearchByTitleView implements View {

	String title;

	@Override
	public void show() {
		out.print("\n---- �������� �˻� ----\n");

		out.print("�˻� : ");

		title = scan.nextLine();

		while (true) {
			if (title.replaceAll(" ", "").equals("")) {
				out.println("�˻�� �Է����ּ���.");
			}
			else
				break;
		}
		request.put("title_to_search", title);
	}
}
