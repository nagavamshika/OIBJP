import java.util.Scanner;

class Account{
	String name;
	String registered_username;
	String registered_pwd;
	String acc_no;
	Float bal=0f;
	float trans=0;
	String history="";
	
	//user registration
	public void userRegistration() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name: ");
		this.name=sc.nextLine();
		System.out.println("Enter username: ");
		this.registered_username=sc.nextLine();
		System.out.println("Enter password: ");
		this.registered_pwd=sc.nextLine();
		System.out.println("Enter account number: ");
		this.acc_no=sc.nextLine();
		System.out.println("Registration completed successfully..Please login to your account");
	}	
	//user login
	public boolean login() {
		boolean res=false;
		Scanner sc=new Scanner(System.in);
		while(res==false) {
			System.out.println("Enter your username:");
			String login_username=sc.nextLine();
			if(login_username.equals(registered_username)) {
				while(res==false) {
					System.out.println("Enter password:");
					String login_pwd=sc.nextLine();
					if(login_pwd.equals(registered_pwd)) {
					System.out.println("Logged in successfully");
					res=true;
				}
				else {
					System.out.println("Incorrect password");
				}
			}
		}
		else {
			System.out.println("Incorrect username");
		}
		}
	return res;
	
	}
	//function user can perform
	//withdraw
	public void withdraw() {
		System.out.println("Enter amount to withdraw :");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try {
			if(bal>=amount) {
				trans++;
				bal=bal-amount;
				System.out.println("Withdrawal completed successfully");
				String str="\n"+amount+"Rs withdraw completed\n";
				history=history.concat(str);
			}
			else {
				System.out.println("Insufficient funds");
			}
		}
		catch(Exception e) {
			
		}
	}
	
	//deposit
	public void deposit() {
		System.out.println("Enter amount to deposit: ");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		
		try {
			if(amount<=100000f) {
				trans++;
				bal+=amount;
				System.out.println("Deposited completed successfully");
				String str="\n"+amount+"Rs deposited\n";
				history=history.concat(str);
			}
			else {
				System.out.println("Sorry...maximum limit is 100000");
			}
		}
		catch(Exception e) {
			
		}
	}
	//transfer
	public void transfer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter receipients name: ");
		String rec=sc.nextLine();
		System.out.println("Enter amount to transfer: ");
		float amount=sc.nextFloat();
		try {
			if(bal>=amount) {
				if(amount<=50000f) {
					trans++;
					bal-=amount;
					System.out.println("Successfully transfered to : "+rec);
					String str="\n"+amount+"Rs transfered to "+rec+"\n";
					history=history.concat(str);
				}
				else {
					System.out.println("Transfer failed...maximim limit is 50000");
				}
			}
			else {
				System.out.println("Insufficient balance");
			}
		}
		catch(Exception e) {
			
		}

	}
	//check balance
	public void checkBalance() {
		System.out.println("\nCurrent balance : "+bal+" Rs");
	}
	//transaction history
	public void transHistory() {
		if(trans==0) {
			System.out.println("No transaction");
		}
		else {
			System.out.println("\n"+history);
		}
	}
}
	//Atm interface
	public class AtmInterface{
		public static int userInput(int max_limit) {
			int inp=0;
			boolean flag=false;
			while(flag==false) {
				try {
					Scanner sc=new Scanner(System.in);
					inp=sc.nextInt();
					flag=true;
					if(flag && inp > max_limit || inp < 1) {
						System.out.println("Choose a number from 1 to "+max_limit);
						flag=false;
					}
				}
				catch(Exception e) {
					System.out.println("Enter integer values only");
					flag=false;
				}
			};
			flag=false;
			return inp;
		}
	

	//main method
	public static void main(String[] args) {
		System.out.println("_______WELCOME TO ATM MANAGEMENT SYSTEM_________");
		System.out.println("1.Register\n2.Exit");
		System.out.println("Enter your choice: ");
		int choice=userInput(2);
		if(choice==1) {
			Account b=new Account();
			b.userRegistration();
			while(true) {
			//	System.out.println("\n1.Login\n2.Exit");
			//	b.userRegistration();
				while(true) {
					System.out.println("\n1.Login\n2.Exit");
					System.out.println("Enter your choice: ");
					int ch=userInput(2);
					if(ch==1) {
						if(b.login()) {
							System.out.println("\n\n_________WELCOME BACK "+b.name+"________\n");
							boolean res1=false;
							while(res1==false) {
								System.out.println("\n1.Deposit\n2.Withdraw\n3.Transfer\n4.Transfer history\n5.Check balance\n6.Exit");
								System.out.println("Enter your choice: ");
								int c=userInput(6);
								switch(c) {
								case 1:
									b.deposit();
									break;
								case 2:
									b.withdraw();
									break;
								case 3:
									b.transfer();
									break;
								case 4:
									b.transHistory();
									break;
								case 5:
									b.checkBalance();
									break;
								case 6:
									res1=true;
									break;
								}
							}
						}
					}
					else {
						System.exit(0);
					}
				}
			}
			
			//	System.exit(0);
			
		
	}
}
	}