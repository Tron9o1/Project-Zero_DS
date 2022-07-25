
public class Drop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Ball ballObj1= new Ball();
		ballObj1.fall();
		ballObj1.fall(1);
		ballObj1.fall(1.3f);
		ballObj1.fall(1,1);
		ballObj1.fall(1,12.2f);
		ballObj1.fall(1.3f,1.3f);
		ballObj1.fall(1.3f,1);
		
	}

}

class Ball{
	

	 void fall() {
		 System.out.println("fall():ball is dropped from top of the building");
		 
	 }
	 
	 void fall(int x) {
		 System.out.println("fall():ball is dropped from "+ x+" meters height");
		 
	 }
	 
	 void fall(float x) {
		 System.out.println("fall():ball is dropped from "+ x+" meters height");
		 
	 }
	 
	 void fall(int x, int y) {
		 System.out.println("fall():ball is dropped from "+ x+" meters height and it landed "+y+"meters from entrance");
		 
	 }
	 
	 void fall(int x, float y) {
		 System.out.println("fall():ball is dropped from "+ x+" meters height and it landed "+y+"meters from entrance");
		 
	 }
	 
	 void fall(float x, int y) {
		 System.out.println("fall():ball is dropped from "+ x+" meters height and it landed "+y+"meters from entrance");
		 
	 }
	 
	 void fall(float x, float y) {
		 System.out.println("fall():ball is dropped from  "+ x+" meters height and it landed "+y+"meters from entrance");
		 
	 }
	
}
