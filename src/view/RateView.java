package view;

import model.RatingDAO;

public class RateView implements View {

	public int choice() {
		out.print("(1) ���Է� \n(2) �� ��� \n\nChoice >  ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	@Override
	public void show() {}
	
	public boolean show2() {
		while (true) {
			int rating = -1;
			String comments;
			boolean success_flag = true;

			out.println("----- ���ϱ� -----");
			out.print(" ����(0 ~ 10)   : ");

			try {
				rating = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}

			out.print(" �ı�(�ִ� 100��) : ");
			comments = scan.nextLine();

			if (rating < 0 || rating > 10) {
				success_flag = false;
			}

			if (comments.length() > 100) {
				success_flag = false;
			}

			if (success_flag == true) {
				RatingDAO dao = new RatingDAO();
/*
				if (dao.insertRate(rating, comments) == true) {
					System.out.println("�򰡰� ���������� �Ϸ�Ǿ����ϴ�.");
					return true;
				} else {
					System.out.println("�� ���忡 �����߽��ϴ�.");
					return false;
				}
*/
			} else {
				out.println("�Էµ� ������ ���� ���� ���� �ʰų� �ıⰡ 100�� �̻��Դϴ�.");
				int num = choice();

				while (num < 1 || num > 2) {
					System.out.println("\n�߸��� �Է�!");
					out.println("�Էµ� ������ ���� ���� ���� �ʰų� �ıⰡ 100�� �̻��Դϴ�.");
					num = choice();
				}
				
				if(num == 2) {
					return false;
				}
			}
		}
	}
}
