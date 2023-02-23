package visitors_log.utility;

import java.sql.SQLException;
import java.util.Scanner;

import visitors_log.dao.UserLoginDAOImpl;

public class UserLoginUtility {
	
		public static void main(String[] args) {
			
					checkLogin();
				}

				public static void checkLogin() {
					Scanner scanner = new Scanner(System.in);
					System.out.println("______________User-Login_____________");
					System.out.println("_____________________________________");
					System.out.println();

					System.out.println("Enter User Name :");
					String userName = scanner.nextLine();
					System.out.println("Enter Password :");
					String password = scanner.nextLine();

					UserLoginDAOImpl userloginDao = new UserLoginDAOImpl();
					boolean isLoginValid;
					try {
						isLoginValid = userloginDao.findByUsernameAndPassword(userName, password);
						if (isLoginValid) {
							DisplayAllClass.finalDisaply();
						} else {
							System.out.println("Incorrect UserName or Password, Try again...");
							System.out.println();
							checkLogin();
						}

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
	
	
