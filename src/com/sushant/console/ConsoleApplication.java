package com.sushant.console;

import java.util.List;
import java.util.Scanner;

import com.sushant.login.dao.IdentityDAO;
import com.sushant.login.dto.UserDetailsdto;
import com.sushant.login.services.UserDetailsDAO;

public class ConsoleApplication {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------------------Welcome to IDMS------------------");
		System.out.println("---------------Login Page-------------------");
		System.out.print("Username : ");
		String uname = sc.next();
		System.out.print("Password : ");
		String password = sc.next();
		
		if ((uname != null && !uname.isEmpty()) && (password != null && !password.isEmpty())) {


			UserDetailsDAO dao = new UserDetailsDAO();
			System.out.println(dao.validateUser(uname, password));


			if (!dao.validateUser(uname, password)) {
				
				System.out.println("-----------------Welcome "+uname.toUpperCase()+"-------------------");
				
				int choice =0;
				while(choice!=3) {
					System.out.println();
					System.out.println("-------------------Menu----------------------");
				System.out.println("1.Create Identity");
				System.out.println("2.Search, Update or Delete Identity");
				System.out.println("3.Logout and Exit");
				System.out.print("Please enter your choice : ");
				choice=sc.nextInt();
				System.out.println();
				switch(choice)
				{
				case 1 :
					System.out.println();
					System.out.println("----------------Identity Creation---------------");
					System.out.println();
					System.out.println("Please enter Identity ");
					System.out.println("User Name : ");
					String name = sc.next();
					System.out.println("Display Name : ");
					String dname = sc.next();
					System.out.println("Password : ");
					String pwd = sc.next();
					System.out.println("UID : ");
					String uid = sc.next();
					
					UserDetailsdto id = new UserDetailsdto();
					id.setName(dname);
					id.setPassword(pwd);
					id.setUserName(name);
					id.setUserId(Integer.valueOf(uid));
					IdentityDAO.create(id);
					System.out.println("Identity Created successfully.");
					System.out.println();
					break;
				case 2 :
					System.out.println();
					System.out.println("----------Search Identity-------------");
					List<UserDetailsdto> ud = IdentityDAO.getAllRecords();
					System.out.println("UID | \t UserName | \t Password | \t Display Name");
					for(UserDetailsdto iden : ud)
					{
						System.out.println(iden.getUserId()+" | \t"+iden.getUserName()+" | \t"+iden.getPassword()+" | \t"+iden.getName());
						System.out.println("------------------------------------------------------------------------------------------------------");
					}
					System.out.println();
					System.out.println("1. DELETE Identity by UID ");
					System.out.println("2. UPDATE Identity by UID ");
					System.out.println("3. back <-| ");
					System.out.print("please enter your choice : ");
					int ch =sc.nextInt();
					switch(ch)
					{
					case 1:
						System.out.println();
						System.out.println("--------------Delete Identity---------------");
						System.out.print("Please enter the UID of the Identity : ");
						int ids = sc.nextInt();
						UserDetailsdto user= new UserDetailsdto();
						user.setUserId(ids);
						System.out.println("Are you sure want to delete the identity "+ids+" : press 'Y' if yes.");
						if(sc.next().equalsIgnoreCase("y"))
						{
							IdentityDAO.delete(user);
							System.out.println("User Delete Successfully.");
						}
						else
						{
							ch=3;
						}
						
						break;
					case 2:
						System.out.println();
						System.out.println("-----------------UPDATE Identity--------------------");
						System.out.print("Please Enter the Identity for the Updating User : ");
						int ids1 = sc.nextInt();
						System.out.println("Please enter Identity ");
						System.out.println("New User Name : ");
						String name1 = sc.next();
						System.out.println("New Display Name : ");
						String dname1 = sc.next();
						System.out.println("New Password : ");
						String pwd1 = sc.next();
						
						UserDetailsdto id2 = new UserDetailsdto();
						id2.setName(dname1);
						id2.setPassword(pwd1);
						id2.setUserName(name1);
						id2.setUserId(ids1);
						IdentityDAO.update(id2);
						System.out.println("Identity Successfully Updated.");
						
						break;
					case 3:
						break;
						
					}
					break;
				}
				
				
				}
				System.out.println("Successfully Logged out. Thank you.");
				
			}
		
		
		
		
	}
	
	}
	

}
