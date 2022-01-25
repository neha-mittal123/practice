package practice;

public class Pegasus extends Horse implements Flyer, Mythical {
	
	 public String identifyMyself() {
        return "in pagasus";
    }
    public static void main(String... args) {
        Horse myApp =  new Pegasus();
        System.out.println(myApp.identifyMyself());
    }
}