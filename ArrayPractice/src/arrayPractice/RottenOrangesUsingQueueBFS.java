package arrayPractice;


import java.util.LinkedList;


public class RottenOrangesUsingQueueBFS {
	static int m[][] = { { 2, 1, 0, 2, 1 },
            { 1, 0, 1, 2, 1 },
            { 1, 0, 0, 2, 1 } };
	static int col=m[0].length;
	static int row=m.length;
	static int ans=0;
	static RottenOrangesUsingQueueBFS rottenOrangesUsingQueueBFS=new RottenOrangesUsingQueueBFS();
	class Element{
		int timeFrame,x,y;
		
		
		public Element(int timeFrame, int x,int y) {
			super();
			this.timeFrame = timeFrame;
			this.x=x;
			this.y=y;
		}

		@Override
		public String toString() {
			return "Element [timeFrame=" + timeFrame + ", x=" + x +", y=" +y+ "]";
		}

		public Element() {
		}
		
	}
	public static void main(String[] args) {
		
		
		LinkedList<Element> queue=new LinkedList<Element>();
		int timeFrame=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(m[i][j]==2) {
					Element e=rottenOrangesUsingQueueBFS.new Element(timeFrame,i,j);
					queue.addLast(e);
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Element e=queue.removeFirst();
			ans=e.timeFrame;
			if(isSafe(e.x+1,e.y) && m[e.x+1][e.y]==1) {
				m[e.x+1][e.y]=2;
				Element temp=rottenOrangesUsingQueueBFS.new Element(e.timeFrame+1,e.x+1,e.y);
				queue.addLast(temp);
			}
			if(isSafe(e.x-1,e.y) && m[e.x-1][e.y]==1) {
				m[e.x-1][e.y]=2;
				Element temp=rottenOrangesUsingQueueBFS.new Element(e.timeFrame+1,e.x-1,e.y);
				queue.addLast(temp);
			}
			if(isSafe(e.x,e.y+1) && m[e.x][e.y+1]==1) {
				m[e.x][e.y+1]=2;
				Element temp=rottenOrangesUsingQueueBFS.new Element(e.timeFrame+1,e.x,e.y+1);
				queue.addLast(temp);
			}
			if(isSafe(e.x,e.y-1) && m[e.x][e.y-1]==1) {
				m[e.x][e.y-1]=2;
				Element temp=rottenOrangesUsingQueueBFS.new Element(e.timeFrame+1,e.x,e.y-1);
				queue.addLast(temp);
			}
		}
		if(checkAll()) {
			System.out.println("-1");
		}else {
			System.out.println(ans);
		}

	}
	
	private static boolean checkAll() {
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(m[i][j]==1) {
					return true;
				}
			}
		}
		return false;
	}
	private static boolean isSafe(int x, int y) {
		return (x>=0 && x<row && y>=0 && y<col);
	}

}
