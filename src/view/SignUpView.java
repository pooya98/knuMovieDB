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

		out.print("ID(필수/ 최소 4자리, 최대 15자리, 공백 불가) :");
		id = scan.nextLine();
		request.put("signUp_id", id);

		out.print("PASSWORD(필수/ 최소 4자리, 최대 20자리, 공백 불가) :");
		pw = scan.nextLine();
		request.put("signUp_pw", pw);

		out.print("NAME(필수/ 최대 20자리) :");
		name = scan.nextLine();
		request.put("signUp_name", name);
		out.print("CONTACT(필수/ xxx-xxxx-xxxx) :");
		contact = scan.nextLine();
		request.put("signUp_contact", contact);
		out.print("ADDRESS(최대 100자리) :");
		address = scan.nextLine();
		request.put("signUp_address", address);
		out.print("SEX(Male - M, Female - F) :");
		sex = scan.nextLine();
		request.put("signUp_sex", sex);
		out.print("BIRTH(yyyy-mm-dd) :");
		birth = scan.nextLine();
		request.put("signUp_birth", birth);
		out.print("JOB(최대 20자리) :");
		job = scan.nextLine();
		request.put("signUp_job", job);

		// out.println(id + pw + name + contact + address + sex + birth + job);

		if (id.length() != id.replaceAll(" ", "").length() || id.length() > 15 || id.length() < 4) {
			out.println("(실패)유효하지 않은 ID입니다.");
			signup_input = false;
		}
		if (pw.length() != pw.replaceAll(" ", "").length() || pw.length() > 20 || pw.length() < 4) {
			out.println("(실패)유효하지 않은 PW입니다.");
			signup_input = false;
		}
		if (name.length() > 20 || name.length() == 0 || name.replaceAll(" ", "").length() == 0) {
			out.println("(실패)유효하지 않은 NAME입니다.");
			signup_input = false;
		}
		if (contact.length() != 13 || (contact.length() > 3 && contact.charAt(3) != '-')
				|| (contact.length() > 8 && contact.charAt(8) != '-')) {
			out.println("(실패)유효하지 않은 CONTACT입니다.");
			signup_input = false;
		}
		if (contact.length() >= 13) {
			for (int i = 0; i <= 12; i++) {
				if (i == 3 | i == 8)
					continue;

				if (contact.charAt(i) <= '9' && contact.charAt(i) >= '0') {
				} else {
					out.println("(실패)유효하지 않은 CONTACT입니다.");
					signup_input = false;
				}
			}
		}
		if (address.length() > 100) {
			out.println("(실패)유효하지 않은 ADDRESS입니다.");
			signup_input = false;
		}
		if (sex.replaceAll(" ", "").length() > 0) {
			if (!(sex.equals("M")) && !(sex.equals("F"))) {
				out.println("(실패)유효하지 않은 SEX입니다.");
				signup_input = false;
			}
		}
		
		if (birth.length() > 0) {
			if (birth.length() != 10 || (birth.length() > 4 && birth.charAt(4) != '-')
					|| (birth.length() > 7 && birth.charAt(7) != '-')) {
				out.println("(실패)유효하지 않은 BIRTH입니다.");
				signup_input = false;
				birth_consistent = false;
			}

			if (birth.length() >= 10) {
				for (int i = 0; i <= 9; i++) {
					if (i == 4 | i == 7)
						continue;

					if (birth.charAt(i) <= '9' && birth.charAt(i) >= '0') {
					} else {
						out.println("(실패)유효하지 않은 BIRTH입니다.");
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
					out.println("(실패)유효하지 않은 BIRTH입니다.");
					signup_input = false;
				}
				if (month < 1 || month > 12) {
					out.println("(실패)유효하지 않은 BIRTH입니다.");
					signup_input = false;
				}
				if (day < 1 || day > 31) {
					out.println("(실패)유효하지 않은 BIRTH입니다.");
					signup_input = false;
				}
				check_birth = Calendar.getInstance();
				cur_date = Calendar.getInstance();

				check_birth.set(Calendar.YEAR, year);
				check_birth.set(Calendar.MONTH, month);
				check_birth.set(Calendar.DATE, day);

				if (check_birth.compareTo(cur_date) > 0) {
					out.println("(실패)유효하지 않은 BIRTH입니다.");
					signup_input = false;
				}
			}
		}
		if (job.length() > 20) {
			out.println("(실패)유효하지 않은 JOB입니다.");
			signup_input = false;
		}

		request.put("signup_input", signup_input);
	}
}
