package basics;

public class FizzBuzzChallenge {

    public static void main(String[] args) {
        /*"Write a program that prints the numbers from 1 to 100. 
        But for multiples of three print Fizz instead of the number and for the multiples of five print Buzz. 
        For numbers which are multiples of both three and five print FizzBuzz.*/
        
        Integer[] array = new Integer[100];
        int cont = 1;
        
        for (int i = 0; i < array.length; i++) {
            array[i] = cont;
            cont++;
            if(array[i] % 3 == 0 && array[i] % 5 == 0){
                System.out.println("FIZZBUZZ");
                
            }else if(array[i] % 3 == 0 || array[i] % 5 == 0){
                System.out.println("FIZZ");
            }else{
                System.out.println(array[i]);
                
            }
            
            
        }
                
    }
}
