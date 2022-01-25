package arrayPractice;

//given : [126,125,67,28, 658] expected: [9, 8, 13, 10, 19] without using a 2 loops
public class SumOfArrayElementsDigits {

	public static void main(String[] args) {
		int sum=0;
		String array []= {"126","125","67","28","658"};
		for(int i=0;i<array.length;i++) {
			String num=array[i];
			String[] numm=num.split("");
			for(int j=0;j<numm.length;j++) {
				sum=sum+Integer.parseInt(numm[j]);
			}
			array[i]=String.valueOf(sum);
			sum=0;
		}
		for(String s:array) {
			System.out.println(s);
		}
		
		

	}

}
