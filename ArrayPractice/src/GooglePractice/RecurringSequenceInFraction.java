package GooglePractice;

//Given a fraction, find a recurring sequence of digits if it exists, otherwise, print “No recurring sequence”.
//
//        Examples:
//
//        Input  : Numerator = 8, Denominator = 3
//        Output : Recurring sequence is 6
//        Explanation : 8/3 = 2.66666666.......
//
//        Input : Numerator = 50, Denominator = 22
//        Output : Recurring sequence is 27
//        Explanation : 50/22 = 2.272727272.....
//
//        Input : Numerator = 11, Denominator = 2
//        Output : No recurring sequence
//        Explanation : 11/2 = 5.5


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RecurringSequenceInFraction {
    public static void main(String[] args){
        int numerator=8,denominator=3;
        StringBuilder sb=new StringBuilder();
        double d = (double)numerator/denominator;
        String recurringSequence=findRecurringSequence(numerator,denominator);
        if(Double.toString(d).split("\\.")[1].contains(recurringSequence)){
           // sb.append(quotient).append(".(").append(recurringSequence).append(")");
        }

        System.out.println();
//        StringBuilder sb=new StringBuilder();
//        if(recurringSequence.length()!=0)
//        sb.append(quotient).append(".(").append(recurringSequence).append(")");
//        System.out.println(sb.toString());
    }


    private static String findRecurringSequence(int numerator, int denominator) {
        StringBuilder result=new StringBuilder();
        HashMap<Integer,Integer> mapOfRemSeenWithPos=new HashMap<>();
        int rem=numerator%denominator;
        while(rem!=0 && !mapOfRemSeenWithPos.containsKey(rem)){
            mapOfRemSeenWithPos.put(rem, result.length());
            rem=rem*10;
            int quotient=rem/denominator;
            result.append(Integer.toString(quotient));
            rem=rem%denominator;
        }
        StringBuilder nonRepeating=new StringBuilder();
        return result.substring(mapOfRemSeenWithPos.get(rem));
    }
}
