import java.util.*;

public class two_sum
{
	//maybe have user enter the sum each time?
	
	//***********************************************
	//GO BACK AND SORT THOSE ARRAYS JUST TO BE SAFE
	//***********************************************

	//Random randInt = new Random();
	//move this random code down, and it should fix that non
	//static variable error
	public static int[] twoSum(int[] num, int sum)
	{
		//Takes in a target number from the user and an array of numbers. 
		int[] result = new int[2];
		//based off of what prof. brizan said today I think this is the brute force method
		for (int b=0;b<num.length;b++)
		{
			for (int c=1;c<num.length;c++)
				//no initializing c to 0 wouldn't work
				//hmm...
				//maybe set it to 1 or something that way it's at least 1 ahead of b each time. 
			{
				//System.out.println("B is: "+num[b]+" C is: "+num[c]);

				if (b!=c && num[b]==num[c])
				{
					result[0]=-1;
					result[1]=-1;
					//adds -1 to array to return 
					System.out.println("The output should be "+"["+result[0]+", "+result[1]+"].");
					System.out.println("Because the number in array is not allowed to be used twice.");
					//this doesn't actually work since b and c will eventually be the same
					//maybe add something to check if they're the same index number but not the same number in the array
					//okay now it works
					return result;
				}

				else if (num[c]+num[b]==sum && num[b]!=num[c])
				{
					result[0]=b;
					result[1]=c;
					System.out.println("The output should be "+"["+result[0]+", "+result[1]+"]. ");
					System.out.println("Because num["+b+"]"+" + "+"num["+c+"]"+" = "+num[b]+" + "+num[c]+" = "+sum);
					return result;
				}

				else  
				{
					result[0]=-1;
					result[1]=-1;
					System.out.println("The output should be "+"["+result[0]+", "+result[1]+"].  ");
					System.out.println("Because a solution could not be found. ");
					System.out.println();
					//return result;
					//I did not return the result here since when I did it would end the program as soon as it couldn't find a solution and it wouldn't go through the whole loop
				}
			}
		}
	  return result;
	}

	public static int[] createArray()
	{
		Random randInt = new Random();
		int [] someArray = new int[5];
		for (int i=0;i<someArray.length;i++)
		{
			someArray[i]=randInt.nextInt(30+1);
			//I think this should make a random number 
			//between 0/1 and 30 if I remember correctly
			System.out.println(someArray[i]+" added to array.");
			//this print isn't really necessary but it helps me to see that the correct values are being added
		}
	 return someArray;

	}

	/*public static int createTarget()
	{
		Random randTarget = new Random();
		int target;
		target = randTarget.nextInt(60+1);
		//should hopefully create a target between 1 and 60
		System.out.println("Target is: " + target);
		//Again, this print is just to double check

		return target;
	}*/
	//DON'T NEED THIS FUNCTION SINCE THE USER ENTERS THE TARGET NOW

	//Apparenty I'm supposed to set a target then pass it into the two_sum function along with an array


	public static String toString(int[] someArray)
	{
		String someOutput;
		someOutput = "[";
		for (int i=0;i<someArray.length;i++)
		{
			someOutput+=someArray[i];
			if (i<someArray.length-1)
			{
				someOutput+=", ";
			}

			/*else if (i>=someArray.length)
			{
				someOutput+="]";
			}*/ 
			//think the last bracket has to be outside the loop to work
		}
		someOutput+="]";
		//okay so moving the last bracket worked
		return someOutput;
		//returns a 5 number long array of random integers below 30
	}

	public static int[] sortArray(int[] someArray)
	{
		//return int[]
		/*int aMin;
		int aMax;

		aMin = someArray[0];
		aMax = someArray[0];

		for (int i=0; i<someArray.length;i++)
		{
			//System.out.println("Min is: "+aMin);

			if (someArray[i]<aMin)
			{
				aMin=someArray[i];

				if (someArray[i]>aMax)
				{
					aMax=someArray[i];
				}
			}

			else if (someArray[i]>aMax)
			{
				aMax=someArray[i];

				if (someArray[i]<aMin)
				{
					aMin=someArray[i];
				}
			}
		}
	  System.out.println();
	  System.out.println("Min: "+aMin+ " Max: "+aMax);
	  */

	 //don't necessarily need to set min and max to sort the array, think that would take too long
	 //fix this

	  //follow same ideas that I had to go through the array to search for duplicates
	  
	  int temporaryNum;
	  for (int i=0;i<someArray.length;i++)
	  {
	  	for (int j=i+1;j<someArray.length;j++)
	  	{
	  		temporaryNum=0;
	  		if (someArray[i]>someArray[j])
	  		{
	  			//can I just use array.sort()??? Not sure if built in functions are allowed 
	  			temporaryNum=someArray[i];
	  			//sets temp num to the item at index i so we don't lose the value
	  			someArray[i]=someArray[j];
	  			//sets item at index i to item at index j since based off of the conditional
	  			//in the if statement, the item at j should be less than the item at i.
	  			someArray[j]=temporaryNum;


	  		}
	  	}
	  }
	  return someArray;
	}

	public static void main(String[] args)
	{
		int[] anArray = createArray();
		//makes an array of 5 random integers and anArray saves this array basically

		String result = toString(anArray);
		//properly prints the array with commas and brackets since I forgot you can't just print 
		//an array using the array name and the print function

		//int targetResult = createTarget();
		//no longer need that function^^

		Scanner uInput = new Scanner(System.in);
		System.out.println();
		System.out.println("Please enter the target sum as an integer. ");
		int target;
		target=uInput.nextInt();

		System.out.println();
		System.out.println("Given nums = " + result + ", " + " Target = " + target);
		System.out.println();
		//prints all of the stuff needed

		int[] sort_the_array = sortArray(anArray);
		String sortedArray = toString(sort_the_array);
		System.out.println();
		System.out.println("Sorted the array: "+sortedArray);
		System.out.println();

		int[] arrayResult = twoSum(sort_the_array,target);
		//checks to see if any duplicates exist, if any numbers add to the target, and if the target can be reached by the numbers

		String array_return_result = toString(arrayResult);
		//prints the array that is returned after checking for certain conditons in twoSum  (ex:// [-1,-1] or the indexes of the 2 numbers that add to the target)

		System.out.println();
		System.out.println("Returned: "+array_return_result);

		//sortArray(anArray);
	}
}