package interviewBit.inception;

/*

A hotel manager has to process N advance bookings of rooms for the next season.

His hotel has C rooms. Bookings contain an arrival date and a departure date.

He wants to find out whether there are enough rooms in the hotel to satisfy the demand.

Write a program that solves this problem in time O(N log N) .

Input Format
First argument is an integer array A containing arrival time of booking.

Second argument is an integer array B containing departure time of booking.

Third argument is an integer C denoting the count of rooms.

Output Format
Return True if there are enough rooms for N bookings else return False.


Input:
 A = [1, 2, 3]
 B = [2, 3, 4]
 C = 2

 At day = 1, there is 1 guest in the hotel.
 At day = 2, there are 2 guests in the hotel.
 At day = 3, there are 2 guests in the hotel.
 At day = 4, there is 1 guest in the hotel.

 We have two rooms available, which satisfy the demand.
 */


import java.util.ArrayList;
import java.util.Collections;

public class HotelBookings {

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int ar=0, de=0, nos=0,satisfy=0 , roomoccupancy=0;

        while(ar<arrive.size() && de<depart.size()){
            if(arrive.get(ar)<=depart.get(de)){
                ar++;
                nos++;
                roomoccupancy++;
                satisfy= Math.max(nos,satisfy);
            }else{
                de++;
                nos--;
            }
        }
        return (satisfy<=K)?true:false;
    }
}
