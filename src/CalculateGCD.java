import java.util.*;

public class CalculateGCD {
	public int gcd(int a, int b) {
	    @SuppressWarnings("unused")
		int minVal = 0, gcd = 1;
	    if (a > 0 && b > 0){
	        if (a < b){
	            minVal = a;
	        }
	        else if (b < a){
	            minVal = b;
	        }
	        else{
	            return a;
	        }
	        Set<Integer> factorsA = calculateFactors(a);
	        Set<Integer> factorsB = calculateFactors(b);
	        System.out.println(factorsA);
	        System.out.println(factorsB);
	        Iterator<Integer> iterator;
	        iterator = factorsB.iterator();
	        while (iterator.hasNext()){
	        	int val = iterator.next();
	        	if (factorsA.contains(val)){
	        		gcd = val;
	        		return gcd;
	        	}
	        }
	        /*for (int i = 2; i <= minVal; i++){
	            if ((a % i == 0) && (b % i == 0)){
	                gcd = i;
	            }
	        }*/
	    }
	    return gcd;
	}
	
	public TreeSet<Integer> calculateFactors(int a){
		TreeSet<Integer> set = new TreeSet<Integer>();
		int div = 1;
		for(int i = 1; i <= div; i++){
			if (a%i == 0){
				div = a / i;
				set.add(i);
				set.add(div);
			}
		}
		return (TreeSet<Integer>) set.descendingSet();
	}
}
