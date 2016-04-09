import java.io.*;
import java.util.*;

import java.net.*;

class SpellChecker{
    
    
public static void main(String[] args) throws IOException{ 
try{ 
    

     URL url = new URL("http://www-01.sil.org/linguistics/wordlists/english/wordlist/wordsEn.txt");
        
    
  Scanner reader = new Scanner(new InputStreamReader(url.openStream()));
  

 ArrayList list = new ArrayList();


String next;
while(reader.hasNext()){
next = reader.next();
        
next = next.toLowerCase();
if(!list.contains(next)){list.add(next);}
}

    
System.out.println("Enter a word to be checked.");
 Scanner sc = new Scanner(System.in);
String s = sc.next();
s = s.toLowerCase();
 
 if(list.contains(s)){
 
 System.out.println(s+" is a corect word");
 
 
 }//if
 
 
 else{
     ArrayList output = new ArrayList();
 System.out.println("Incorrect word.");

     
 String temp;
 String in;
 boolean b = false;
 
 int i,j;
 outer: for(i=0;i<s.length();i++){
     
 inner:for(j=97;j<123;j++){  
 temp = s.substring(0,i).concat(String.valueOf((char)j)).concat(s.substring((i+1),s.length()));
 if(!output.contains(temp)){
  
output.add(temp);
 
if(list.contains(temp)){
System.out.println("\nDid you mean '"+temp+"'?\nHit 'Y' if yes; else press any other key"); 
in = sc.next();
if(in.matches("Y")||in.matches("y")){
    
    System.out.println("\nSo the correct word is "+temp);
    b = true;
break outer;}
 
 }//if
 }//new only 
}//for  j  
    
 }//for i

 
if(!b){
int k,l; 
outer2: for(i=0;i<s.length()-1;i++){
 
 
 for(j=97;j<123;j++){  
  for(k=i+1;k<s.length();k++){ 
     for(l=97;l<123;l++){  
 temp = s.substring(0,i).concat(String.valueOf((char)j)).concat(s.substring((i+1),k)).concat(String.valueOf((char)l)).concat(s.substring((k+1),s.length()));
   if(!output.contains(temp)){
  
output.add(temp); 
// output.add(temp);      

 if(list.contains(temp)){
System.out.println("\nDid you mean '"+temp+"'?\nHit 'Y' if yes; else press any other key"); 
in = sc.next();
if(in.matches("Y")||in.matches("y")){
    System.out.println("\nSo the correct word is "+temp);
break outer2;}
 
 }//if
 
if(i==(s.length()-2) && j==122 && k==(s.length()-1) && l==122){
System.out.println("\nSorry, no more suggestions."); 

}//the end
   }//new only
 }//for l  

 }//for k   
 }//for j

  
     
}//for i     
 
 }//b is false



 }//else

   }//try
   
   
   catch(Exception e){
          System.out.println("Error while reading file line by line:" + e.getMessage());                      
       }//catch
}//psvm
}//class