import java.util.HashMap;

public class Fibonacci{
	private HashMap<Integer, Integer> map;
	public Fibonacci(){
		map = new HashMap<Integer, Integer>();
	}
	
	public int findFibonacciValue(int number){
		if (number == 0 || number == 1){
			return number;
		}
		else if (map.containsKey(number)){
			return map.get(number);
		}
		else{
			int fibonacciValue = findFibonacciValue(number - 2) + findFibonacciValue(number - 1);
			map.put(number, fibonacciValue);
			return fibonacciValue;
}
}
}