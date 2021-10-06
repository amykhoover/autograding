import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ErrorCollector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.*;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

import java.io.*;


class JUnitTestSelectionSort {

	@Rule
    public ErrorCollector collector = new ErrorCollector();
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	@Test
	  public void minIndex()
	   {
		 String workingDir = System.getProperty("user.dir");
		 String gradingOutput = "Working Directory = " + workingDir + "\n";
		 gradingOutput+= "\n \n";
		 
		 
		 gradingOutput+= "Tests for minIndex(int[] list, int i) \n";
		 //////////////////////////////////////////////////////
		 gradingOutput+= "------------------------------------------------------------------------\n";
		 gradingOutput+= "First Test of minIndex implementation: \n";
		 
		 int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		 int smallIndex = 4;
		 int answer = 4;
		 
		 String myArr = "";
		 for(int i=0; i < arr.length; i++)
		 {
			 if(i == 0)
				 myArr+="[" + arr[i];
			 else if (i == arr.length-1)
				 myArr+= "," + arr[i] + "]";
				 
			 else
				 myArr+= "," + arr[i];
		 }
		 //assertEquals(answer, MySelectionSort.minIndex(arr,smallIndex));
		 int studentAnswer = SelectionSort.minIndex(arr,smallIndex);
		 
		 
		 gradingOutput+="\n";
		 try 
		 {
			 assertThat(answer, equalTo(studentAnswer));
			 gradingOutput+= "Your answer is correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		 } 
		 catch (Throwable t) 
		 {
		     collector.addError(t);
		     gradingOutput+= "Your answer is not correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		     gradingOutput+= "The error message printed from the JUnit Testing is: \n";
		     gradingOutput+= "\t" + t.toString() + "\n"; 
		        
		 }	 
		 gradingOutput+="\n";
		 //////////////////////////////////////////////////////
		 
		 
		 gradingOutput+="------------------------------------------------------------------------\n";
		 gradingOutput+="Second Test of minIndex implementation: \n";
		 
		 
		 smallIndex = 8;
		 answer = 8;
		 myArr = "";
		 for(int i=0; i < arr.length; i++)
		 {
			 if(i == 0)
				 myArr+="[" + arr[i];
			 else if (i == arr.length-1)
				 myArr+= "," + arr[i] + "]";
				 
			 else
				 myArr+= "," + arr[i];
		 }
		
		 studentAnswer = SelectionSort.minIndex(arr,smallIndex);
		 //assertEquals(answer, MySelectionSort.minIndex(arr,smallIndex));
		 
		 
		 gradingOutput+="\n";
		 try 
		 {
			 assertThat(answer, equalTo(studentAnswer));
			 gradingOutput+= "Your answer is correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		 } 
		 catch (Throwable t) 
		 {
		     collector.addError(t);
		     gradingOutput+= "Your answer is not correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		     gradingOutput+= "The error message printed from the JUnit Testing is: \n";
		     gradingOutput+= "\t" + t.toString() + "\n"; 
		        
		 }	 
		 gradingOutput+="\n";
		 //////////////////////////////////////////////////////

		 gradingOutput+= "------------------------------------------------------------------------\n";
		 gradingOutput+= "Third Test of minIndex implementation: \n";
		 
		 smallIndex = 0;
		 answer=0;
		 myArr = "";
		 for(int i=0; i < arr.length; i++)
		 {
			 if(i == 0)
				 myArr+="[" + arr[i];
			 else if (i == arr.length-1)
				 myArr+= "," + arr[i] + "]";
				 
			 else
				 myArr+= "," + arr[i];
		 }
		 

		 //assertEquals(answer, MySelectionSort.minIndex(arr,smallIndex));
		 studentAnswer = SelectionSort.minIndex(arr,smallIndex);
		 gradingOutput+="\n";
		 try 
		 {
			 assertThat(answer, equalTo(studentAnswer));
			 gradingOutput+= "Your answer is correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		 } 
		 catch (Throwable t) 
		 {
		     collector.addError(t);
		     gradingOutput+= "Your answer is not correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		     gradingOutput+= "The error message printed from the JUnit Testing is: \n";
		     gradingOutput+= "\t" + t.toString() + "\n"; 
		        
		 }	 
		 gradingOutput+="\n";

		 //////////////////////////////////////////////////////

		 gradingOutput+= "------------------------------------------------------------------------\n";
		 gradingOutput+= "Fourth Test of minIndex implementation: \n";
		
		 

		 int [] arr2 = {50, 22, 53, 83, 1, 21, 20, 49, 81, 18};
		 int smallIndex2 = 0;
		 answer = 4;
		 
		 myArr = "";
		 for(int i=0; i < arr2.length; i++)
		 {
			 if(i == 0)
				 myArr+="[" + arr2[i];
			 else if (i == arr2.length-1)
				 myArr+= "," + arr2[i] + "]";
				 
			 else
				 myArr+= "," + arr2[i];
		 }
		 
		 studentAnswer = SelectionSort.minIndex(arr2,smallIndex2);
		 //assertEquals(answer, MySelectionSort.minIndex(arr2,smallIndex2));
		 gradingOutput+="\n";
		 try 
		 {
			 assertThat(answer, equalTo(studentAnswer));
			 gradingOutput+= "Your answer is correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		 } 
		 catch (Throwable t) 
		 {
		     collector.addError(t);
		     gradingOutput+= "Your answer is not correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		     gradingOutput+= "The error message printed from the JUnit Testing is: \n";
		     gradingOutput+= "\t" + t.toString() + "\n"; 
		        
		 }	 
		 gradingOutput+="\n";
		 //////////////////////////////////////////////////////

		 gradingOutput+= "------------------------------------------------------------------------\n";
		 gradingOutput+= "Fifth Test of minIndex implementation: \n";
		 
		 smallIndex2 = 5;
		 answer = 9;
		 myArr = "";
		 for(int i=0; i < arr2.length; i++)
		 {
			 if(i == 0)
				 myArr+="[" + arr2[i];
			 else if (i == arr2.length-1)
				 myArr+= "," + arr2[i] + "]";
				 
			 else
				 myArr+= "," + arr2[i];
		 }

		 studentAnswer = SelectionSort.minIndex(arr2,smallIndex2);
		 //assertEquals(answer, MySelectionSort.minIndex(arr2,smallIndex2));
		
		 
		 gradingOutput+="\n";
		 try 
		 {
			 assertThat(answer, equalTo(studentAnswer));
			 gradingOutput+= "Your answer is correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		 } 
		 catch (Throwable t) 
		 {
		     collector.addError(t);
		     gradingOutput+= "Your answer is not correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		     gradingOutput+= "The error message printed from the JUnit Testing is: \n";
		     gradingOutput+= "\t" + t.toString() + "\n"; 
		        
		 }	 
		 gradingOutput+="\n";
		 
		 gradingOutput+= "------------------------------------------------------------------------\n";
		 gradingOutput+="\n \n \n \n";
		 //////////////////////////////////////////////////////
		 //System.out.println(gradingOutput);
		 
		 String filename = workingDir + "/minIndexTest.txt";
	     try 
	     {
	    	 
	         FileWriter myWriter = new FileWriter(filename);
	         myWriter.write(filename + "\n");
	         myWriter.write(gradingOutput);
	         myWriter.close();

	     } 
	     catch (IOException e) 
	     {
	         System.out.println("An error occurred writing to " + filename);
	         e.printStackTrace();
	     }
	   }
	
	@Test
	   public void test_print()
	   {
	     PrintStream originalOut = System.out;
	     ByteArrayOutputStream bos = new ByteArrayOutputStream();
	     System.setOut(new PrintStream(bos));
	     
		 String workingDir = System.getProperty("user.dir");
		 String gradingOutput = "Working Directory = " + workingDir + "\n";
		 gradingOutput+= "\n \n";
		 gradingOutput+= "Tests for print(int[] arr) \n";
	     
	     
	     /* Test 1 */
	     
	     gradingOutput+= "------------------------------------------------------------------------\n";
	     gradingOutput+= "First Test of print implementation: " + "\n";
		 
		 
		 int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		 bos.reset();
		 SelectionSort.print(arr);
		 String studentAnswer = bos.toString();
		 String answer = "1 2 3 4 5 6 7 8 9 \n";
		 //assertEquals("1 2 3 4 5 6 7 8 9 \n", bos.toString());
		 
		 gradingOutput+="\n";
		 try 
		 {
			 assertThat(answer, equalTo(studentAnswer));
			 gradingOutput+= "Your answer is correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		 } 
		 catch (Throwable t) 
		 {
		     collector.addError(t);
		     gradingOutput+= "Your answer is not correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		     gradingOutput+= "The error message printed from the JUnit Testing is: \n";
		     gradingOutput+= "\t" + t.toString() + "\n"; 
		        
		 }	 
		 gradingOutput+="\n";
		 

			
		 /* Test 2 */
		 gradingOutput+= "------------------------------------------------------------------------\n";
		 gradingOutput+="Second Test of print implementation: \n";
		 
		 int[]  arr2 = {7, 9};
		 
		 answer = "7 9 \n";
		 bos.reset();
		 SelectionSort.print(arr2);
		 studentAnswer = bos.toString();

		 gradingOutput+="\n";
		 try 
		 {
			 assertThat(answer, equalTo(studentAnswer));
			 gradingOutput+= "Your answer is correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		 } 
		 catch (Throwable t) 
		 {
		     collector.addError(t);
		     gradingOutput+= "Your answer is not correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		     gradingOutput+= "The error message printed from the JUnit Testing is: \n";
		     gradingOutput+= "\t" + t.toString() + "\n"; 
		        
		 }	 
		 gradingOutput+="\n";
		 
		
		 //////////////////////////////////////////////////////
		 gradingOutput+= "------------------------------------------------------------------------\n";
		 gradingOutput+= "Third Test of print implementation: \n";
		 
		 int[] arr3 = {};
		 answer = "\n";
		 bos.reset();
		 SelectionSort.print(arr3);
		 studentAnswer = bos.toString();//assertEquals("\n", bos.toString());
		 
		 
		 gradingOutput+="\n";
		 try 
		 {
			 assertThat(answer, equalTo(studentAnswer));
			 gradingOutput+= "Your answer is correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		 } 
		 catch (Throwable t) 
		 {
		     collector.addError(t);
		     gradingOutput+= "Your answer is not correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		     gradingOutput+= "The error message printed from the JUnit Testing is: \n";
		     gradingOutput+= "\t" + t.toString() + "\n"; 
		        
		 }	 
		 gradingOutput+="\n";

			
		 //////////////////////////////////////////////////////
		 gradingOutput+= "------------------------------------------------------------------------\n";
		
		 gradingOutput+= "Fourth Test of print implementation: \n";
		 int[] arr4 = {9, 8, 1, 2, 3, 10};
		 answer="9 8 1 2 3 10 \n";
		 bos.reset();
		 SelectionSort.print(arr4);
		 studentAnswer = bos.toString();
		 //assertEquals("9 8 1 2 3 10 \n", bos.toString());
		 
		 gradingOutput+="\n";
		 try 
		 {
			 assertThat(answer, equalTo(studentAnswer));
			 gradingOutput+= "Your answer is correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		 } 
		 catch (Throwable t) 
		 {
		     collector.addError(t);
		     gradingOutput+= "Your answer is not correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		     gradingOutput+= "The error message printed from the JUnit Testing is: \n";
		     gradingOutput+= "\t" + t.toString() + "\n"; 
		        
		 }	 
		 gradingOutput+="\n";
		 
		 //////////////////////////////////////////////////////
		 gradingOutput+= "------------------------------------------------------------------------\n";
		 gradingOutput+="Fifth Test of print implementation: \n";
		
		 
		 int [] arr5 = new int[100];
		 answer = "";
		 for(int i=0; i< arr5.length; i++)
		 {
			 arr5[i] = i;
			 answer+= arr5[i] + " ";
		 }
		 //answer = "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 4 45 46 47 48 49 50 5140 41 42 43 4 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 \n";
		 bos.reset();
		 SelectionSort.print(arr5);
		 studentAnswer = bos.toString();
		 
		 
		 gradingOutput+="\n";
		 try 
		 {
			 assertThat(answer, equalTo(studentAnswer));
			 gradingOutput+= "Your answer is correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		 } 
		 catch (Throwable t) 
		 {
		     collector.addError(t);
		     gradingOutput+= "Your answer is not correct.\n";
			 gradingOutput+= "The correct answer is: \n";
			 gradingOutput+= "\t" + answer + "\n";
			 gradingOutput+= "Your code output the following: \n"; 
			 gradingOutput+= "\t" + studentAnswer + "\n";
		     gradingOutput+= "The error message printed from the JUnit Testing is: \n";
		     gradingOutput+= "\t" + t.toString() + "\n"; 
		        
		 }	 
		 gradingOutput+="\n";
		 
		 gradingOutput+= "------------------------------------------------------------------------\n";
		 gradingOutput+="\n \n \n \n";
		 bos.reset();
	     // undo the binding in System*/
	     System.setOut(originalOut);
	     
	     //System.out.println(gradingOutput);

	     
	     String filename = workingDir + "/printTest.txt";
	     try 
	     {
	    	 
	         FileWriter myWriter = new FileWriter(filename);
	         myWriter.write(filename + "\n");
	         myWriter.write(gradingOutput);
	         myWriter.close();

	     } 
	     catch (IOException e) 
	     {
	         System.out.println("An error occurred writing to " + filename);
	         e.printStackTrace();
	     }
	   }
}
