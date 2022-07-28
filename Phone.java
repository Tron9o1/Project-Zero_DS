
public class Phone {

		public static void main(String[] args) {
			
			System.out.println("Enter password...");
			
			Phone1 myPhone = new Phone1();
			try {
				myPhone.enterPassMafia();
				myPhone.launch1();
			} catch (WrongPasswordException e) {
				System.out.println("Problem : "+e);
			}
			
			System.out.println("locked...");

			System.out.println("--------------------------------------------------");

			try {
				myPhone.enterPass();
				myPhone.launch();
			} catch (WrongPasswordException e) {
				System.out.println("Problem : "+e);
			}
			
			System.out.println("locked...");
			
			System.out.println("--------------------------------------------------");
			
			try {
				myPhone.enterPassMafia();
				myPhone.launch1();
			} catch (WrongPasswordException e) {
				System.out.println("Problem : "+e);
			}
			
			System.out.println("locked...");
			
			System.out.println("--------------------------------------------------");
			
			try {
				myPhone.enterPassMafia();
				myPhone.launch1();
			} catch (WrongPasswordException e) {
				System.out.println("Problem : "+e);
			}
			
			System.out.println("locked...");
			
			System.out.println("--------------------------------------------------");
			
			try {
				myPhone.enterPassMafia();
				myPhone.launch1();
			} catch (WrongPasswordException e) {
				System.out.println("Problem : "+e);
			}
			
			System.out.println("locked...");
			
			System.out.println("--------------------------------------------------");
			
			try {
				myPhone.enterPass();
				myPhone.launch();
			} catch (WrongPasswordException e) {
				System.out.println("Problem : "+e);
			}
			
			System.out.println("locked...");
			
			System.out.println("--------------------------------------------------");
			
			try {
				myPhone.enterPass();
				myPhone.launch();
			} catch (WrongPasswordException e) {
				System.out.println("Problem : "+e);
			}
			
			System.out.println("locked...");
			
			System.out.println("--------------------------------------------------");
			

		}
	}

	class WrongPasswordException extends Exception
	{
		WrongPasswordException(String msg) {
			super(msg);
		}
	}
	class Phone1
	{
		int password;
		
		Phone1() {
			System.out.println("Enter login password....");
		}

		
		void enterPass() {
			if(password==9999) {
				password = 1234;
				System.out.println("Changing to User1:");
				System.out.println("launching");
			}
			if(password==0000) {
				password = 1234;
				System.out.println("launching user1");
			}
			
		}
		
		void enterPassMafia() {
			if(password==0000) {
				password = 9999;
				System.out.println("launching mafia version");
			}
			if(password==1234) {
				password = 9999;
				System.out.println("Changing to Mafia:");
				System.out.println("launching mafia version");
			}
			
		}
		
		void launch() throws WrongPasswordException
		{
			if(password == 0000 ) {
				WrongPasswordException dontlaunchEx = new WrongPasswordException("Wrong credentials");
				throw dontlaunchEx;
			}

			System.out.println("Programs loading....");
			
			
		}
		void launch1() throws WrongPasswordException
		{
			if(password == 0000 ) {
				WrongPasswordException dontlaunchEx = new WrongPasswordException("Wrong credentials");
				throw dontlaunchEx;
			}

			System.out.println("Loading hidden programs....");
			
			
		}
		
		void lock() {
			if(password==1234||password==9999) {
				password = 0000;
			}
			System.out.println("locked...");
		}
	}