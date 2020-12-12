package view;

import java.util.Calendar;

public class SignUpView implements View {

	@Override
	public void show() {

		String id;
		String pw;
		String name;
		String contact;
		String address;
		String sex;
		String birth;
		String job;
		Calendar check_birth;
		Calendar cur_date;
		int year = 0;
		int month = 0;
		int day = 0;
		boolean signup_input = true;
		boolean birth_consistent = true;

		out.println("\n--- Sign up ---");

		out.print("ID(�ʼ�/ �ּ� 4�ڸ�, �ִ� 15�ڸ�, ���� �Ұ�) :");
		id = scan.nextLine();
		request.put("signUp_id", id);

		out.print("PASSWORD(�ʼ�/ �ּ� 4�ڸ�, �ִ� 20�ڸ�, ���� �Ұ�) :");
		pw = scan.nextLine();
		request.put("signUp_pw", pw);

		out.print("NAME(�ʼ�/ �ִ� 20�ڸ�) :");
		name = scan.nextLine();
		request.put("signUp_name", name);
		out.print("CONTACT(�ʼ�/ xxx-xxxx-xxxx) :");
		contact = scan.nextLine();
		request.put("signUp_contact", contact);
		out.print("ADDRESS(�ִ� 100�ڸ�) :");
		address = scan.nextLine();
		request.put("signUp_address", address);
		out.print("SEX(Male - M, Female - F) :");
		sex = scan.nextLine();
		request.put("signUp_sex", sex);
		out.print("BIRTH(yyyy-mm-dd) :");
		birth = scan.nextLine();
		request.put("signUp_birth", birth);
		out.print("JOB(�ִ� 20�ڸ�) :");
		job = scan.nextLine();
		request.put("signUp_job", job);

		// out.println(id + pw + name + contact + address + sex + birth + job);

		if (id.length() != id.replaceAll(" ", "").length() || id.length() > 15 || id.length() < 4) {
			out.println("(����)��ȿ���� ���� ID�Դϴ�.");
			signup_input = false;
		}
		if (pw.length() != pw.replaceAll(" ", "").length() || pw.length() > 20 || pw.length() < 4) {
			out.println("(����)��ȿ���� ���� PW�Դϴ�.");
			signup_input = false;
		}
		if (name.length() > 20 || name.length() == 0 || name.replaceAll(" ", "").length() == 0) {
			out.println("(����)��ȿ���� ���� NAME�Դϴ�.");
			signup_input = false;
		}
		if (contact.length() != 13 || (contact.length() > 3 && contact.charAt(3) != '-')
				|| (contact.length() > 8 && contact.charAt(8) != '-')) {
			out.println("(����)��ȿ���� ���� CONTACT�Դϴ�.");
			signup_input = false;
		}
		if (contact.length() >= 13) {
			for (int i = 0; i <= 12; i++) {
				if (i == 3 | i == 8)
					continue;

				if (contact.charAt(i) <= '9' && contact.charAt(i) >= '0') {
				} else {
					out.println("(����)��ȿ���� ���� CONTACT�Դϴ�.");
					signup_input = false;
				}
			}
		}
		if (address.length() > 100) {
			out.println("(����)��ȿ���� ���� ADDRESS�Դϴ�.");
			signup_input = false;
		}
		if (sex.replaceAll(" ", "").length() > 0) {
			if (!(sex.equals("M")) && !(sex.equals("F"))) {
				out.println("(����)��ȿ���� ���� SEX�Դϴ�.");
				signup_input = false;
			}
		}
		
		if (birth.length() > 0) {
			if (birth.length() != 10 || (birth.length() > 4 && birth.charAt(4) != '-')
					|| (birth.length() > 7 && birth.charAt(7) != '-')) {
				out.println("(����)��ȿ���� ���� BIRTH�Դϴ�.");
				signup_input = false;
				birth_consistent = false;
			}

			if (birth.length() >= 10) {
				for (int i = 0; i <= 9; i++) {
					if (i == 4 | i == 7)
						continue;

					if (birth.charAt(i) <= '9' && birth.charAt(i) >= '0') {
					} else {
						out.println("(����)��ȿ���� ���� BIRTH�Դϴ�.");
						birth_consistent = false;
						signup_input = false;
					}
					if (i == 9) {
						if (birth_consistent == true) {
							year = Integer.valueOf(birth.substring(0, 4));
							month = Integer.valueOf(birth.substring(5, 7));
							day = Integer.valueOf(birth.substring(8));
						}
					}
				}
			}

			if (birth.length() >= 10 && birth_consistent == true) {


				if (year < 1900) {
					out.println("(����)��ȿ���� ���� BIRTH�Դϴ�.");
					signup_input = false;
				}
				if (month < 1 || month > 12) {
					out.println("(����)��ȿ���� ���� BIRTH�Դϴ�.");
					signup_input = false;
				}
				if (day < 1 || day > 31) {
					out.println("(����)��ȿ���� ���� BIRTH�Դϴ�.");
					signup_input = false;
				}
				check_birth = Calendar.getInstance();
				cur_date = Calendar.getInstance();

				check_birth.set(Calendar.YEAR, year);
				check_birth.set(Calendar.MONTH, month);
				check_birth.set(Calendar.DATE, day);

				if (check_birth.compareTo(cur_date) > 0) {
					out.println("(����)��ȿ���� ���� BIRTH�Դϴ�.");
					signup_input = false;
				}
			}
		}
		if (job.length() > 20) {
			out.println("(����)��ȿ���� ���� JOB�Դϴ�.");
			signup_input = false;
		}

		request.put("signup_input", signup_input);
	}
}
