package arrayPractice;

import java.util.*;


public class WordLadderProblemUsingGraphShortestPathBFS {

	static Set<String> D = new HashSet<String>();
    static String start = "hit";
    static String target = "cog";
	public static void main(String[] args) {
		D.add("hot");
	    D.add("dot");
	    D.add("dog");
	    D.add("lot");
	    D.add("log");
	    D.add("cog");
	    if(!D.contains(target)) {
	    	System.out.println("-1");
	    }
	    LinkedList<String> queue=new LinkedList<String>();
	    queue.addFirst(start);
	    int depth=0;
	    while(!queue.isEmpty()) {
	    	depth=depth+1;
	    	int levelElementsSize=queue.size();
	    	while(levelElementsSize-->0) {
	    		String curr=queue.removeLast();
	    		for(int i=0;i<curr.length();i++) {
	    			StringBuilder temp=new StringBuilder(curr);
	    			for(char c='a';c<='z';c++) {
	    				temp.setCharAt(i, c);
	    				if(curr.matches(temp.toString())) {
	    					continue;
	    				}else if(target.matches(temp.toString())) {
	    					depth=depth+1;
	    					break;
	    				}else if(D.contains(temp.toString())) {
	    					queue.push(temp.toString());
	    					D.remove(temp.toString());
	    				}
	    			}
	    		}
	    	}
	    }
	    System.out.println(depth);

	}

}
