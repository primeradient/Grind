package interviewBit.arrays;

public class MinLightsActivate {
    /*

        There is a corridor in a Jail which is N units long. Given an array A of size N.
        The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.
        All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].

        Initially all lights are off.
        Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.

        Problem Constraints
        1 <= N <= 100000
        1 <= B <= 10000

        Input Format
        - First argument is an integer array A where A[i] is either 0 or 1.
        - Second argument is an integer B.

        Output Format
        - Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.
     */

    /** Algo
     *   This question is not about solving if given 1s in list can light up all the 0s ranges but finding minimum 1s (among all 1s) that can light up all the 0s ranges
     *   Initially i thought it to be about 1st and wasted lot of time. Good to read and clarify the question, again and again before solving

       At every position with 0, compute positions left and right Range.
       If within left-right range a 1 exists then light from 1s will also take care of light for this range.
           This now counts towards minimum lights to be turned on.
           We can then skip to (position + Power) slot and back to 1st step
       else exit as 0s range cannot be lighted.



       mintLightCount = 0;
       for i in ( 0 to N -1 ) {
           if arr[i] value is 1 ; continue ; //we dont care for working lights

           leftRange   =  min(0,   i - Power + 1)
           rightRange  =  min(N-1, i + Power - 1)
           atLeastOneFound = false;
           while ( rightRange >= leftRange )
              if arr[rightRange] is 1
                  minLightCount++
                  i = i + Power
                  atLeastOneFound = true;
                  break;

          if ( ! atLeastOneFound ) return -1
      }
      return minLightCount;

     */


    public int minNoLight(int lightArr[], int lightPow) {
        int n = lightArr.length;
        int count = 0;
        for (int i = 0; i < lightArr.length; ) {
            if ( lightArr[i] == 1) {
                i++;
                continue;
            }

            boolean atLeastOneFound = false;
            int leftRange = Math.max(0, i - lightPow + 1);             //find this failed bulb's left range
            int rightRange = Math.min(n - 1, i + lightPow - 1);         //find this failed bulb's right range

            for(int l = rightRange; l >= leftRange; l--) {                    //starting from right range to left range.. check if we have a working build (with 1)
                if(lightArr[l] == 1) {
                    count = count + 1;

                    i = l + lightPow;

                    atLeastOneFound = true;
                    break;
                }
            }

            if(!atLeastOneFound) {
                return -1;
            }
        }

        return count;

    }

    public static void main(String args[]) {
        int [] arr = new int[]{  1,0,0,0,0,0,0,0,0,0,1};
        int B = 3;
        System.out.println(new MinLightsActivate().minNoLight(arr,B));
    }

}
