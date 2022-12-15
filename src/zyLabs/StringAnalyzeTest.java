/**
 * Author: Christopher Martin
 * Date:   Oct 10, 2022
 * Description: 
 *
 *
 *
 */

package zyLabs;
import java.util.Scanner;
import java.util.Random;

public class StringAnalyzeTest {
	public static void main(String[] args) {
		
		int points = 0;
		
		System.out.println("---TESTING STARTED---");
		//commonLetters bench
		//1
		if(StringAnalyze.commonLetters("java", "python").equals("<none>")) {
			System.out.println("Test passed for java and python.");
			points += 5;
		}
		
		else {
			System.out.println("Test failed. For java and python expected <none>.");
		}
		
		//2
		if(StringAnalyze.commonLetters("apple", "popcorn").equals("p")) {
			System.out.println("Test passed for apple and popcorn.");
			points += 5;
		}
		
		else {
			System.out.println("Test failed. For apple and popcorn expected 'p'");
		}
	
		//3
		if(StringAnalyze.commonLetters("amber", "amulet").equals("ame")){
			
			System.out.println("Test passed for amber and amulet.");
			points += 5;
		}
		
		else {
			System.out.println("Test failed. For amber and amulet");
		}
		
		//4
		if(StringAnalyze.commonLetters("", "science").equals("<none>")){
			System.out.println("Test passed for \"\" and science");
			points += 5;
		}
		
		
		else {
			System.out.println("Test failed for \"\" and science. Expected <none>");
		}
		
		//5
		if(StringAnalyze.commonLetters("", "").equals("<none>")){
			System.out.println("Test passed for \"\" and \"\"");
			points += 5;
		}
		
		else {
			System.out.println("Test failed. For \"\" and \"\", expected <none>");
		}
		
		//check swapHere
		
		//6
		if(StringAnalyze.swapHere("123456789", 5).equals("567891234")){
			System.out.println("swapHere(1234546789, 5) passed.");
			points += 5;
		}
		
		else {
			System.out.println("swapHere(123456789,5) failed. Expected 567891234.");
		}
		
		//7
		if(StringAnalyze.swapHere("123456789", 3).equals("345678912")){
			System.out.println("swapHere(123456789,3) passed");
			points += 5;
		}
		
		else {
			System.out.println("swapHere(123456789, 3) failed. Expected 345678912.");
		}
		
		//8
		if(StringAnalyze.swapHere("123456789", 9).equals("912345678")){
			System.out.println("swapHere(123456789, 9) passed.");
			points += 5;
		}
		
		else {
			System.out.println("swapHere(123456789, 9) failed. Expected 123456789.");
		}
		
		//9
		if(StringAnalyze.swapHere("123456789", 0).equals("123456789")){
			System.out.println("swapHere(123456789, 0) passed.");
			points += 5;
		}
		
		else {
			System.out.println("swapHere(123456789, 0) failed. Expected 123456789.");
		}
		
		//10
		if(StringAnalyze.swapHere("123456789", -8).equals("123456789")){
			System.out.println("swapHere(123456789, -8) passed.");
			points += 5;
		}
		
		else {
			System.out.println("swapHere(123456789, -8) failed. Expected 123456789.");
		}
		
		//11
		if(StringAnalyze.swapHere("123456789", 30).equals("123456789")){
			System.out.println("swapHere(123456789, -8) passed.");
			points += 5;
		}
		
		else {
			System.out.println("Test failed. Expected 123456789.");
		}
		
		
		//check letterSum
		
		//12
		if(StringAnalyze.letterSum("abcdefghijklmnopqrstuvwxyz") == 351){
			System.out.println("letterSum(abcdefghijklmnopqrstuvwxyz) passed.");
			points += 5;
		}
		
		else {
			System.out.println("letterSum(abcdefghijklmnopqrstuvwxyz)failed. Expected 351.");
		}
		
		//13
		if(StringAnalyze.letterSum("dog)(*&^%$#@") == 26){
			System.out.println("letterSum(dog)(*&^%$#@) passed.");
			points += 5;
		}
		
		else {
			System.out.println("letterSum(dog)(*&^%$#@) failed. Expected 26.");
		}
		
		
		//14
		if(StringAnalyze.letterSum("abcdefghijklmnopqrstuvwxyz".toUpperCase()) == 351){
			System.out.printf("letterSum(%s) passed.\n", "abcdefghijklmnopqrstuvwxyz".toUpperCase());
			points += 5;
		}
		
		else {
			System.out.printf("letterSum(%s) failed. Expected 351.", "abcdefghijklmnopqrstuvwxyz".toUpperCase());
		}
		
		
		//15
		if(StringAnalyze.letterSum("*&^%$#@!") == 0){
			System.out.println("letterSum(*&^%$#@!) passed");
			points += 5;
		}
		
		else {
			System.out.println("letterSum(*&^%$#@!)failed. Expected 0.");
		}
		
		
		//16
		if(StringAnalyze.letterSum("1234098756") == 0){
			System.out.println("letterSum(1234098756) passed.");
			points += 5;
		}
		
		else {
			System.out.println("letterSum(1234098756). Expected 0.");
		}
		
		//17
		if(!StringAnalyze.isValidPassword("89woWO")){
			System.out.println("isValidPassword(\"89woWO\") passed.");
			points += 5;
		}
		
		else {
			System.out.println("isValidPassword(\"89woWO\")failed. Expected false.");
		}
		
		//18
		if(!StringAnalyze.isValidPassword("thisWORKS")){
			System.out.println("isValidPassword(\"thisWORKS\")passed.");
			points += 5;
		}
		
		else {
			System.out.println("isValidPassword(\"thisWORKS\") Expected false.");
		}
		
		//19
		if(!StringAnalyze.isValidPassword("TH15WORKS")){
			System.out.println("isValidPassword(\"TH15WORKS\")passed.");
			points += 5;
		}
		
		else {
			System.out.println("isValidPassword(\"TH15WORKS\") failed. Expected false.");
		} 
		
		//20
		if(!StringAnalyze.isValidPassword("th!$W0RK5")){
			System.out.println("isValidPassword(\"th!$W0RK5\") passed.");
			points += 5;
		}
		
		else {
			System.out.println("isValidPassword(\"th!$W0RK5\") failed. Expected false.");
		}
		
		//21
		if(!StringAnalyze.isValidPassword("!@#$%^&*()")){
			System.out.println("isValidPassword(\"!@#$%^&*()\" passed.");
			points += 5;
		}
		
		else {
			System.out.println("isValidPassword(\"!@#$%^&*()\" failed. Expected false.");
		}
		
		//22
		if(StringAnalyze.isValidPassword("th15WOrks")){
			System.out.println("isValidPassword(\"th15WOrks\") passed.");
			points += 5;
		}
		
		else {
			System.out.println("isValidPassword(\"th15WOrks\") failed. Expected true.");
		}
		
		System.out.println("---TESTING FINISHED---");
		System.out.printf("Student score %d / 110\n", points);
	}

}
