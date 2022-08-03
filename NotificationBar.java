

public class NotificationBar {
	public static void main(String[] args) {
		//1. extend from java.lang.Thread class
		//2. override public void run()  method
		//3. create the object of your sub class
		//4. invoke the start() method of it, which would 
		// execute the run() method of it
		
		Notification n1 = new Notification("Whatsapp ",30); //3
		Notification n2 = new Notification("\tSnapchat",14); //3
		Notification n3 = new Notification("\t\tfacebook",5); //3
		Notification n4 = new Notification("\t\t\ttwitter",28); //3
		Notification n8 = new Notification("\t\t\t\t\t\tNews",40); //3
		Notification n5 = new Notification("\t\t\t\tZomato",40); //3
		Notification n6 = new Notification("\t\t\t\t\tSwiggy",20); //3
		Notification n7 = new Notification("\t\t\t\t\t\tGmail",10); //3
		Notification n9 = new Notification("\t\t\t\t\t\t\tMissed calls",5); //3

		n1.start();
		n2.start();
		n3.start();
		n4.start();
		n8.start();
		n5.start();
		n6.start();
		n7.start();
		n9.start();
		
	}
}

class Notification extends Thread //1
{
	String msg;
	int f=25;
	
	Notification(String m) {
		msg = m;
	}
	Notification(String m, int t) {
		msg = m;
		f=t;
	}
	
	public void run() { //2. overriridng is always optional
		for (int i = 1; i < f; i++) {
			System.out.println(msg+ " "+i);
		}
	}
}

/*
 		Bank Cash Deposit Counter
  
A/c Book  
 101  Dinesh 55000
 102  Ramesh 60000
 103  Naresh 70000
 104  Rajesh 80000
 ..
 ..
  
  		Teller1				Teller2			Teller3
  		 |					|				|
 1 		getBalance			getBalance		getBalance
  		|					|				|
 2 		calcAmt				calcAmt			calcAmt
  		|					|				|
 3 		setBalance			setBalance		setBalance
  		|					|				|
 who?	Customer1 / 3mnts	Customer2		Customer3
 a/c	101					102				103
 cash?	5000				7000			8000
 deno?	100/-				500/-			2000/-
 time	10.30am 			10.30am			10.30am
 notes? 50					14				4
 

 		Customer5
 		
 		
 						Eatable [i] <- interface
 						|eat();
 				--------------------+
 				|				    |isA
 			FoodItem [c]			|	
 			| serve() {			   	|	Stone [c]
 			|   ...				   	|	|
 			|   eat();			   	|	|
 			| }					   	|	|isA
 			| eat() { }				|	|
 		-----------					Chalk [c]
 		|							|
 	  Pizza	[c]						eat() { } mandate
 		
 		
  						Runnable
  						| run();
  			--------------------+
  			|					|
  			Thread				|isA
  			| start() {			|
			|  ...				|		Frame
 			|  run();			|		|
 			| }					|		| isA
 			| run() { }			|		|
 	--------------				MyMessageFrame
 	|							| run() {
 	MyMessage					|  ...
 								| }
 */ 