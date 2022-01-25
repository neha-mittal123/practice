package arrayPractice;

//Problem Statement: You are driving a vehicle that has capacity empty seats initially available for passengers. The vehicle only drives east (ie. it cannot turn around and drive west.)
//Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off. The locations are given as the number of kilometers due east from your vehicle's initial location.
//Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
//Input: trips = [[2,1,5],[3,3,7]], capacity = 4
//Output: false
//Input: trips = [[2,1,5],[3,3,7]], capacity = 5
//Output: true

public class CarPoolingLeetCode {

	public static void main(String[] args) {
		int [][] trips = {{2,1,5},{3,3,7}}; 
				int capacity = 4;
				boolean output=carPooling(trips,capacity);
				System.out.println(output);
	}
	public static boolean carPooling(int[][] trips, int capacity) {
        /*
        trips[i][0] = amount of people
        trips[i][1] = get on
        trips[i][2] = get off
        */
        
        int[] stops = new int[1001];
        
        for (int[] t : trips) {
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }
        
        for (int i=0; capacity>=0 && i<1001; i++)
            capacity -= stops[i];
        
        return capacity >= 0;
        
    }

}
