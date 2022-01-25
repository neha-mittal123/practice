package arrayPractice;

public class MinNoOfSquaresSumIsEqualToGivenNumberUsingLegendresTheorem {

	public static void main(String[] args) {
		int num=25,res=0;
		if(Math.ceil(Math.sqrt(num))==Math.floor(Math.sqrt(num))) {
			res=1;
		}
		while(num%4==0) {
			num=num/4;
		}
		if(num%8==7) {
			res=4;
		}
		for(int i=1;(i*i)<num;i++) {
			int base=num-(i*i);
			if((base*base)==(num-(i*i))) {
				res=2;
			}
		}
		if(res!=1 && res!=2 && res!=4) {
			System.out.println("3");
		}else {
			System.out.println(res);
		}
		
	}

}
