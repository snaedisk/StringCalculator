package is.ru.stringcalculator;
import java.util.ArrayList;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		if(numbers.contains("\n")){
			numbers = numbers.replace("\n", ",");
		}
	    return numbers.split(",");
	}
      
 private static int sum(String[] numbers){
		int total = 0;
		int n = 0; 
		ArrayList negative = new ArrayList();
		
		for(String number : numbers){
			n = toInt(number);
			
			if(n >= 0){
				total += n;
			}
			if(n < 0){
				negative.add(n);
			}
		}

		if(negative.size() < 0){
			throw new RuntimeException("Negatives not allowed: " + negative.toString());
		}
		
		return total;
	}
}


