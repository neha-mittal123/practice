package arrayPractice;

import java.util.Scanner;

public class CartesianPlaneTanksAndBoats {

	public static void main(String[] args) {
		int tanks = 2;
		int objects = 3;
		Coordinate[][] array = new Coordinate[16][16];
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				Coordinate c = new Coordinate();
				c.value = 0;
				array[i][j] = c;
			}
		}
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int iMax = 0;
		int jMax = 0;
		for (int k = 0; k < tanks; k++) {
			System.out.println("input :" + k + "tank position");
			int i = sc.nextInt();
			int j = sc.nextInt();
			String direction = checkDirection(i, j);
			Coordinate c = new Coordinate();
			c.value = 1;
			if (direction == "C") {
				c.C = true;
			}
			if (direction == "E") {
				c.E = true;
			}
			if (direction == "N") {
				c.N = true;
			}
			if (direction == "W") {
				c.W = true;
			}
			if (direction == "S") {
				c.S = true;
			}
			array[Math.abs(i)][Math.abs(j)] = c;
			iMax = checkXBoundary(i, iMax);
			jMax = checkXBoundary(j, jMax);
		}
		for (int k = 0; k < objects; k++) {
			System.out.println("input :" + k + "object position");
			int i = sc.nextInt();
			int j = sc.nextInt();
			String direction = checkDirection(i, j);
			Coordinate c = new Coordinate();
			c.value = -1;
			if (direction == "C") {
				c.C = true;
			}
			if (direction == "E") {
				c.E = true;
			}
			if (direction == "N") {
				c.N = true;
			}
			if (direction == "W") {
				c.W = true;
			}
			if (direction == "S") {
				c.S = true;
			}
			array[Math.abs(i)][Math.abs(j)] = c;
			iMax = checkXBoundary(i, iMax);
			jMax = checkXBoundary(j, jMax);
		}
		calculateFiringDirection(array, iMax, jMax);
	}

	private static void calculateFiringDirection(Coordinate[][] array, int iMax, int jMax) {
		for (int i = 0; i < iMax; i++) {
			for (int j = 0; j < jMax; j++) {
				if(array[i][j].value == 1) {
					String n = calculateFiring(array,iMax,jMax,i,j,"N");
					String s = calculateFiring(array,iMax,jMax,i,j,"S");
					String w = calculateFiring(array,iMax,jMax,i,j,"W");
					String e = calculateFiring(array,iMax,jMax,i,j,"E");
					if(e != "NA") {
						array[i][j].E = true;
						System.out.println("Tank firing position:" + "east");
					}else if(n != "NA") {
						array[i][j].N = true;
						System.out.println("Tank firing position:" + "north");
					}else if(s != "NA") {
						array[i][j].S = true;
						System.out.println("Tank firing position:" + "south");
					}if(w != "NA") {
						array[i][j].W = true;
						System.out.println("Tank firing position:" + "west");
					}
				}
			}
		}
	}

	private static String calculateFiring(Coordinate[][] array, int iMax, int jMax, int iCurr, int jCurr, String direction) {
		if(direction == "N") {
			while(jCurr>=0) {
				if(array[iCurr][jCurr].value == 1 || array[iCurr][jCurr].value == -1) {
					return "NA";
				}else {
					jCurr--;
				}
			}
			return "N";
		}else if(direction == "S") {
			while(jCurr<=jMax) {
				if(array[iCurr][jCurr].value == 1 || array[iCurr][jCurr].value == -1) {
					return "NA";
				}else {
					jCurr++;
				}
			}
			return "S";
		}else if(direction == "E") {
			while(iCurr<=iMax) {
				if(array[iCurr][jCurr].value == 1 || array[iCurr][jCurr].value == -1) {
					return "NA";
				}else {
					iCurr++;
				}
			}
			return "E";
		}else{
			while(iCurr>=0) {
				if(array[iCurr][jCurr].value == 1 || array[iCurr][jCurr].value == -1) {
					return "NA";
				}else {
					iCurr--;
				}
			}
			return "W";
		}
	}
	public static String checkDirection(int i, int j) {
		if (i == 0 && j == 0) {
			return "C";
		} else if (i <= 0 && j <= 0) {
			return "W";
		} else if (i <= 0 && j >= 0) {
			return "N";
		} else if (i >= 0 && j >= 0) {
			return "E";
		} else {
			return "S";
		}
	}

	public static int checkXBoundary(int i, int max) {
		i = Math.abs(i);
		if (i > max) {
			max = i;
		}
		return max;
	}

	public static int checkYBoundary(int j, int max) {
		j = Math.abs(j);
		if (j > max) {
			max = j;
		}
		return max;
	}

	private static class Coordinate {
		int value;
		Boolean N;
		Boolean S;
		Boolean W;
		Boolean E;
		Boolean C;
		String firingDirection;
	}
}
