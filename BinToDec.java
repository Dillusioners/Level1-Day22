/*
 * Author - blueBoi101
 * Purpose - Converting binary to decimal for our dear friend Xavier
 * Date - 09/05/2023
 */

//Importing I/O package for input output purposes
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class BinToDec
{
	static final int indexBase = 2;
	//Validating if number is binary or not

	public static boolean isBinary(int number)
	{
		int digit;
		//Liberating the digits of the number one by one
		while(number >= 1)
		{
			//If any digit is not 0 and also not 1 then number is obviously not binary
			digit = number % 10;
			if(digit != 0 && digit != 1)
				return false;
			number /= 10;
		}
		//If we do not return false in the above code we return true intuitively.
		return true;
	}
	public static int BinaryToDecimal(int num)
	{
		//Transposing the binary value into its corresponding Decimal value of base 2.
		int exponent = 0, decimalNumber = 0,digit;
		//Traversing through the digits of the number
		while(num >= 1)
		{
			//Using exponent notational value to elaborate on the conversion
			digit = num % 10;
			decimalNumber += Math.pow(indexBase, exponent) * digit;
			//Liberating the digits
			num /= 10;
			//Incrementing notational exponent
			++exponent;
		}
		return decimalNumber;
	}
	public static void main(String[] args)throws IOException {
		int number;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the binary number Xavier : ");
		try{
		
			//Receiving the number we are to be tasked with from user

			number = Integer.parseInt(reader.readLine());
			//Validating the numbers binary existence

			if(isBinary(number))
			{
				System.out.println(number + " in binary is : " + BinaryToDecimal(number));
			}else{
				System.out.println("Xavier! Number is not binary!");
			}
		//Simple try catch
		}catch(Exception NumberFormatException )
		{
			System.out.println("Please check the value again");
		}

	}
}