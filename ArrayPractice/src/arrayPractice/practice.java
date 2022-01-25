package arrayPractice;

public class practice {

	public static void main(String[] args) {
		String[]array= {"flower","flow","flock"};
		String ans="";
		if(array.length<=0) {
			System.exit(0);
		}
		String firstElemnet=array[0];
		char[] temp=firstElemnet.toCharArray();
		int size=temp.length;
		for(int i=1;i<array.length;i++) {
			StringBuilder prefix=new StringBuilder();
			if(array[i].length()<size) {
				size=array[i].length();
			}
			for(int j=0;j<size;j++) {
				char []string=array[i].toCharArray();
				if(temp[j]==string[j]) {
					prefix.append(temp[j]);
				}
			}
			ans=prefix.toString();
			
		}
	System.out.println(ans);
				

	}

}
