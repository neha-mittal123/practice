package arrayPractice;

public class Test {

	public static void main(String[] args) {
		int[] array= {1,0,6,0,2,0,0,4};
		int size=array.length,temp=0,j=0;
		boolean flag=false;
		for(int i=0;i<size;) {
			if(array[i]==0 && flag==false) {
				j=i;
				flag=true;
				i=j+1;
			}
			if(array[i]!=0 && flag==true) {
				temp=array[i];
				array[i]=array[j];
				array[j]=temp;
				flag=false;
				i=j+1;
			}else {
				i++;
			}
			
			
		}
		for(int i:array) {
			System.out.println(i);
		}
		

	}

}
