package revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    /*
    Create a function that takes a number as an argument and returns true if the number is a valid credit card number, false otherwise.

    Credit card numbers must be between 14-19 digits in length, and pass the Luhn test, described below:

    Remove the last digit (this is the "check digit").
    Reverse the number.
    Double the value of each digit in odd-numbered positions. If the doubled value has more than 1 digit, add the digits together (e.g. 8 x 2 = 16 --> 1 + 6 = 7).
    Add all digits.
    Subtract the last digit of the sum (from step 4) from 10. The result should be equal to the check digit from step 1.

    Examples
    validateCard(1234567890123456) ➞ false

    // Step 1: check digit = 6, num = 123456789012345
    // Step 2: num reversed = 543210987654321
    // Step 3: digit array after selective doubling: [1, 4, 6, 2, 2, 0, 9, 8, 5, 6, 1, 4, 6, 2, 2]
    // Step 4: sum = 58
    // Step 5: 10 - 8 = 2 (not equal to 6) --> false

    validateCard(1234567890123452) --> true
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Credit Card Number ");
        String creditCardNum = input.next();
        Boolean isCreditCardNumber = isCreditCardNum(creditCardNum);
        System.out.println(isCreditCardNumber);
    }

    public static Boolean isCreditCardNum(String ccnumber){
        ArrayList<Integer> card = splitList(ccnumber);

        // Credit card numbers must be between 14-19 digits in length
        if(card.size() >13 && card.size()<20){
            // Remove the last digit (this is the "check digit").
            int checkDigit = card.remove(card.size()-1);
            // Reverse the number.
            Collections.reverse(card);
            // Double the value of each digit in odd-numbered positions.
            // If the doubled value has more than 1 digit,
            // add the digits together (e.g. 8 x 2 = 16 --> 1 + 6 = 7).
            card = doubleOddPosition(card);
            // Add all digits.
            int sum = sumOfDigits(card);
            // Subtract the last digit of the sum (from step 4) from 10.

            int result = subLastDigitFrom10(sum);
            // The result should be equal to the check digit from step 1.
            if(result == checkDigit) {
                return true;
            }
        }
        return  false;
    }

    public static ArrayList<Integer> splitList(String s){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++)	{
            list.add(Character.getNumericValue(s.charAt(i)));
        }return list;
    }

    public static int subLastDigitFrom10(int number){
        int sub = number % 10;
        sub = 10 - sub;
        return sub;
    }

    public static int sumOfDigits(ArrayList<Integer> number){
        int sum =0 ;
        for(int add : number){
            sum += add;
        }return sum;
    }

    public static ArrayList<Integer> doubleOddPosition(ArrayList<Integer> arrayList){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0; i< arrayList.size();i++){
            if(i%2 == 0 ){
                int digit = (arrayList.get(i))*2;
                if(digit>9){
                    digit += 1;
                    digit = digit % 10;
                }
                list.add(digit);
            }else{
                list.add(arrayList.get(i));
            }
        }return list;
    }


}
