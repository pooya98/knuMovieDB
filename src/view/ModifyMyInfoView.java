package view;

import java.util.Calendar;

public class ModifyMyInfoView implements View {

	public int choice() {
		System.out.print("(1) ���Է� \n(2) �ʱ�ȭ������ ���ư��� \n\nChoice > ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	
	public int choice2() {
		System.out.print(
				"(1) �̸� ���� \n(2) ����ó ���� \n(3) �ּ� ���� \n(4) ���� ���� \n(5) ������� ���� \n(6) ���� ����\n(7) ȸ������ ���� ��� \n\nChoice > ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	
	public int choice3() {
		System.out.print("(1) ���� �ϱ� \n(2) ���� ��� \n\nChoice > ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	
	@Override
	public void show() {

		out.print("\n--- ȸ������ ���� ---\n");
		int no = choice2();
		while (no < 1 || no > 7) {
			System.out.println("\n�߸��� �Է�!");
			out.print("\n--- ȸ������ ���� ---\n");
			no = choice2();
		}

		request.put("ModifyMyInfoView_selectNo", no);
	}

	
	public boolean name() {
		while (true) {
			String new_name = "";
			out.print("\n---  NAME ���� ---\n");
			out.println("[���� �̸� : " + request.get("client_name") + "]");
			out.println("���ο� �̸� : ");

			new_name = scan.nextLine();

			if (new_name.length() > 20 || new_name.length() == 0 || new_name.replaceAll(" ", "").length() == 0) {
				while (true) {
					out.println("(����)��ȿ���� ���� NAME�Դϴ�.");

					int no = choice();
					while (no < 1 || no > 2) {
						System.out.println("\n�߸��� �Է�!");
						no = choice();
					}
					if (no == 2) {
						scan.nextLine();
						return false;
					}
					if (no == 1) {
						scan.nextLine();
						break;
					}
				}
			} else {
				out.println("[���ο� �̸� : "+request.get("new_name")+"]");
				int num = choice3();
				while (num < 1 || num > 2) {
					out.println("[���ο� �̸� : "+request.get("new_name")+"]");
					System.out.println("\n�߸��� �Է�!");
					num = choice3();
				}
				
				if(num == 1) {
					request.put("new_name", new_name);
					scan.nextLine();
					return true;
				}
				if(num == 2) {
					scan.nextLine();
					return false;
				}
			}
		}
	}

	
	public boolean contact() {
		while (true) {
			boolean success_flag = true;
			String new_contact = "";
			out.print("\n---  CONTACT ���� ---\n");
			out.println("[���� ����ó : " + request.get("client_contact") + "]");
			out.println("���ο� contact(xxx-xxxx-xxxx) : ");

			new_contact = scan.nextLine();

			if (new_contact.length() != 13 || (new_contact.length() > 3 && new_contact.charAt(3) != '-')
					|| (new_contact.length() > 8 && new_contact.charAt(8) != '-')) {
				success_flag = false;
			}
			if (new_contact.length() >= 13) {
				for (int i = 0; i <= 12; i++) {
					if (i == 3 || i == 8)
						continue;

					if (new_contact.charAt(i) <= '9' && new_contact.charAt(i) >= '0') {
					} else {
						success_flag = false;
					}
				}
			}

			if (success_flag == true) {
				out.println("[���ο� ����ó : "+request.get("new_contact")+"]");
				int num = choice3();
				while (num < 1 || num > 2) {
					System.out.println("\n�߸��� �Է�!");
					out.println("[���ο� ����ó : "+request.get("new_contact")+"]");
					num = choice3();
				}
				
				if(num == 1) {
					scan.nextLine();
					request.put("new_contact", new_contact);
					return true;
				}
				if(num == 2) {
					scan.nextLine();
					return false;
				}
			} else {
				while (true) {
					out.println("(����)��ȿ���� ���� CONTACT�Դϴ�.");

					int no = choice();
					while (no < 1 || no > 2) {
						System.out.println("\n�߸��� �Է�!");
						no = choice();
					}
					if (no == 2) {
						scan.nextLine();
						return false;
					}
					if (no == 1) {
						scan.nextLine();
						break;
					}
				}
			}

		}
	}

	public boolean address() {
		while (true) {
			String new_address = "";
			out.print("\n---  ADDRESS ���� ---\n");
			out.println("[���� �ּ� : " + request.get("client_address") + "]");
			out.println("���ο� �ּ� : ");

			new_address = scan.nextLine();

			if (new_address.length() > 100) {
				while (true) {
					out.println("(����)��ȿ���� ���� ADDRESS�Դϴ�.");

					int no = choice();
					while (no < 1 || no > 2) {
						System.out.println("\n�߸��� �Է�!");
						no = choice();
					}
					if (no == 2) {
						scan.nextLine();
						return false;
					}
					if (no == 1) {
						scan.nextLine();
						break;
					}
				}
			} else {
				if(new_address.length() == 0 || new_address.replaceAll(" ", "").length() == 0) {
					
					request.put("new_address", "(�Է¾���)");
				}
				else {
					request.put("new_address", new_address);
				}
				
				out.println("[���ο� �ּ� : "+request.get("new_address")+"]");
				int num = choice3();
				
				while (num < 1 || num > 2) {
					System.out.println("\n�߸��� �Է�!");
					out.println("[���ο� �ּ� : "+request.get("new_address")+"]");
					num = choice3();
				}
				
				if(num == 1) {
					if(new_address.length() == 0 || new_address.replaceAll(" ", "").length() == 0) {
						
						request.put("new_address", "(�Է¾���)");
					}
					else {
						request.put("new_address", new_address);
					}
					scan.nextLine();
					return true;
				}
				if(num == 2) {
					scan.nextLine();
					return false;
				}
			}
		}
	}

	public boolean sex() {
		while (true) {
			boolean success_flag = true;
			
			String new_sex = "";
			out.print("\n---  SEX ���� ---\n");
			out.println("[���� ���� : " + request.get("client_sex") + "]");
			out.println("���ο� ����(Male - M, Female - F): ");

			new_sex = scan.nextLine();

			if (new_sex.replaceAll(" ", "").length() > 0) {
				if (!(new_sex.equals("M")) && !(new_sex.equals("F"))) {
					out.println("(����)��ȿ���� ���� SEX�Դϴ�.");
					success_flag = false;
				}
			}
			
			
			if (success_flag == true) {
				
				if(new_sex.length() == 0 || new_sex.replaceAll(" ", "").length() == 0) {
					request.put("new_sex", "(�Է¾���)");
				}
				else {
					request.put("new_sex", new_sex);
				}
				
				out.println("[���ο� ���� : "+request.get("new_sex")+"]");
				int num = choice3();
				
				while (num < 1 || num > 2) {
					System.out.println("\n�߸��� �Է�!");
					out.println("[���ο� ���� : "+request.get("new_sex")+"]");
					num = choice3();
				}
				
				if(num == 1) {
					if(new_sex.length() == 0 || new_sex.replaceAll(" ", "").length() == 0) {
						request.put("new_sex", "(�Է¾���)");
					}
					else {
						request.put("new_sex", new_sex);
					}
					scan.nextLine();
					return true;
				}
				if(num == 2) {
					scan.nextLine();
					return false;
				}
			} 
			else {
				while (true) {
					out.println("(����)��ȿ���� ���� SEX�Դϴ�.");

					int no = choice();
					while (no < 1 || no > 2) {
						System.out.println("\n�߸��� �Է�!");
						no = choice();
					}
					if (no == 2) {
						scan.nextLine();
						return false;
					}
					if (no == 1) {
						scan.nextLine();
						break;
					}
				}
			}
		}
	}
	
	public boolean birth() {
		while (true) {
			boolean success_flag = true;
			boolean birth_consistent = true;
			
			Calendar check_birth;
			Calendar cur_date;
			
			int year=0;
			int month=0;
			int day=0;
			
			String new_birth = "";
			out.print("\n---  BIRTH ���� ---\n");
			out.println("[���� ������� : " + request.get("client_birth").toString().substring(0,10) + "]");
			out.println("���ο� �������(yyyy-mm-dd) : ");

			new_birth = scan.nextLine();
			
			//
			if (new_birth.length() > 0) {
				if (new_birth.length() != 10 || (new_birth.length() > 4 && new_birth.charAt(4) != '-')
						|| (new_birth.length() > 7 && new_birth.charAt(7) != '-')) {
					out.println("(����)��ȿ���� ���� BIRTH�Դϴ�.");
					success_flag = false;
					birth_consistent = false;
				}

				if (new_birth.length() >= 10) {
					for (int i = 0; i <= 9; i++) {
						if (i == 4 | i == 7)
							continue;

						if (new_birth.charAt(i) <= '9' && new_birth.charAt(i) >= '0') {
						} else {
							out.println("(����)��ȿ���� ���� BIRTH�Դϴ�.");
							success_flag = false;
							birth_consistent = false;
						}
						if (i == 9) {
							if (birth_consistent == true) {
								year = Integer.valueOf(new_birth.substring(0, 4));
								month = Integer.valueOf(new_birth.substring(5, 7));
								day = Integer.valueOf(new_birth.substring(8));
							}
						}
					}
				}

				if (new_birth.length() >= 10 && birth_consistent == true) {

					if (year < 1900) {
						success_flag = false;
					}
					if (month < 1 || month > 12) {
						success_flag = false;
					}
					if (day < 1 || day > 31) {
						success_flag = false;
					}
					
					check_birth = Calendar.getInstance();
					cur_date = Calendar.getInstance();

					check_birth.set(Calendar.YEAR, year);
					check_birth.set(Calendar.MONTH, month);
					check_birth.set(Calendar.DATE, day);

					if (check_birth.compareTo(cur_date) > 0) {
						out.println(check_birth.getTime() + " " + cur_date.getTime());
						out.println("(����)��ȿ���� ���� BIRTH�Դϴ�.");
						success_flag = false;
					}
				}
			}
			//

			if (success_flag == true) {
				if(new_birth.length() == 0 || new_birth.replaceAll(" ", "").length() == 0) {
					request.put("new_birth", "(�Է¾���)");
				}
				else {
					request.put("new_birth", new_birth);
				}
				
				out.println("[���ο� ������� : "+request.get("new_birth").toString().substring(0,10)+"]");
				int num = choice3();
				while (num < 1 || num > 2) {
					System.out.println("\n�߸��� �Է�!");
					out.println("[���ο� ������� : "+request.get("new_birth").toString().substring(0,10)+"]");
					num = choice3();
				}
				
				if(num == 1) {
					scan.nextLine();
					if(new_birth.length() == 0 || new_birth.replaceAll(" ", "").length() == 0) {
						request.put("new_birth", "(�Է¾���)");
					}
					else {
						request.put("new_birth", new_birth);
					}
					return true;
				}
				if(num == 2) {
					scan.nextLine();
					return false;
				}
			} else {
				while (true) {
					out.println("(����)��ȿ���� ���� BIRTH�Դϴ�.");

					int no = choice();
					while (no < 1 || no > 2) {
						System.out.println("\n�߸��� �Է�!");
						no = choice();
					}
					if (no == 2) {
						scan.nextLine();
						return false;
					}
					if (no == 1) {
						scan.nextLine();
						break;
					}
				}
			}

		}
	}

	public boolean job() {
		while (true) {
			String new_job = "";
			out.print("\n---  JOB ���� ---\n");
			out.println("[���� ���� : " + request.get("client_job") + "]");
			out.println("���ο� ���� : ");

			new_job = scan.nextLine();

			if (new_job.length() > 100) {
				while (true) {
					out.println("(����)��ȿ���� ���� JOB�Դϴ�.");

					int no = choice();
					while (no < 1 || no > 2) {
						System.out.println("\n�߸��� �Է�!");
						no = choice();
					}
					if (no == 2) {
						scan.nextLine();
						return false;
					}
					if (no == 1) {
						scan.nextLine();
						break;
					}
				}
			} else {
				
				if(new_job.length() == 0 || new_job.replaceAll(" ", "").length() == 0) {
					
					request.put("new_job", "(�Է¾���)");
				}
				else {
					request.put("new_job", new_job);
				}
				
				out.println("[���ο� ���� : "+request.get("new_job")+"]");
				int num = choice3();
				
				while (num < 1 || num > 2) {
					System.out.println("\n�߸��� �Է�!");
					out.println("[���ο� ���� : "+request.get("new_job")+"]");
					num = choice3();
				}
				
				if(num == 1) {
					if(new_job.length() == 0 || new_job.replaceAll(" ", "").length() == 0) {
						
						request.put("new_job", "(�Է¾���)");
					}
					else {
						request.put("new_job", new_job);
					}
					scan.nextLine();
					return true;
				}
				if(num == 2) {
					scan.nextLine();
					return false;
				}
			}
		}

	}

}
