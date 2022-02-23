package Practice;

import java.util.ArrayList;

public class Test<E> extends ArrayList<E>{

    @Override
    public boolean add(E e) {
        String temp = (String)e;
        if(temp==null || temp.isEmpty()){
            return false;
        }

        return super.add(e);
    }

	public static void main(String[] args) {
		ArrayList<String> lst = new ArrayList<String>();
        lst.add("aaaa");
        lst.add(null);
        lst.add("");
        System.out.println(lst.size());

	}

}
