// Author: Christopher Tam; this class contains six methods that perform string expression manipulations and string editing functions
public class HW2{
  /* Takes a string input and returns boolean true if all the parentheses in the string are properly matched and boolean false 
   * if this is not the case */
  public static boolean matchingParentheses(String string){
  // Counts the number of '(' in the string
  int sumopen = 0;
  // Counts the number of ')' in the string
  int sumclose = 0;
  // If this is equal to 1 at any time, there are unmatched parentheses in the string
  int conditional = 0;
    /* Goal: to find the total amount of open and close parentheses in the string; Preconditions: the value of the conditional field 
     * must be zero; */
    for(int i = 0; i <= string.length() - 1 && conditional == 0; i = i + 1){
      if(string.charAt(i) == '(' && sumopen == 0){
        sumopen = sumopen + 1;
      }
      else if(string.charAt(i) == '(' && sumopen != 0){
        sumopen = sumopen + 1;
      }
      else if(string.charAt(i) == ')' && sumopen != 0){
        sumclose = sumclose + 1;
      }
      else if(string.charAt(i) == ')' && sumopen == 0){
        conditional = 1;
      }
    }
    // Returns a result stating if the string has matched parentheses or not
    if(sumopen == sumclose && conditional == 0){
      return true;
    }
    else
      return false;
  }
  
  /* Takes a string input and 3 integer inputs: start, skip, and except; returns a string containing every skipth character of the string 
   * and excluding every excepth character of the string, beginning with the start-th character */
  public static String everyNthExcept(String string, int start, int skip, int except){
    StringBuilder newstring = new StringBuilder();             // newstring stores the modified string that is returned from the method
    /* Goal: to return a modified version of the input string with the specifications above by checking each character to see if it is
     * a skipth or excepth character relative to the starth character */
    for(int i = start - 1; i <= string.length() - 1; i = i + 1){
      if((i - (start - 1))%skip == 0 && i - (start - 1) == 0){
        char c = string.charAt(start-1);
        newstring.append(c);
      }
      else if((i - (start - 1))%skip == 0 && (i - (start - 1)) != 0 && (i - (start - 1))%except != 0){
        char c = string.charAt(i);
        newstring.append(c);
      }
    }
    return newstring.toString();
  }
  
  /* Takes an input string and integer k, and returns a modified string that is identical to the input string except that the first 
   * k characters are in normal order, its next k characters are in reverse, and so on. If the last characters are within a reversed 
   * k interval but there are not k characters, these last characters are still reversed */
  public static String flipEachK(String string, int k){
    StringBuilder newstring = new StringBuilder();              // newstring stores the overall modified string that is returned from the method
    int numk = 0;                                               // numk stores the total number of k intervals
    /* Goal: to return a modified version of the input string with the specifications above by checking each kth character of the string
     * and seeing if total number of k intervals at this character is even or odd */
    for(int i = 0; i <= string.length() - 1; i = i + 1){
      // Checks if a character should be added to the modified string normally
      if(((double)(i + 1)/k) - (i + 1)/k != 0.0 && i != string.length() - 1){
        char c = string.charAt(i);
        newstring.append(c);
      }
      // Checks if the last non-k characters of the input string should not be reversed
      else if(((double)(i + 1)/k) - (i + 1)/k != 0.0 && i == string.length() - 1 && numk%2 == 0){
        char c = string.charAt(i);
        newstring.append(c);
      }
      // Checks if a k interval should not be reversed
      else if(((double)(i + 1)/k) - (i + 1)/k == 0.0 && numk%2 == 0){
        numk = numk + 1;
        char c = string.charAt(i);
        newstring.append(c);
      }
      // Checks if a k interval should be reversed
      else if(((double)(i + 1)/k) - (i + 1)/k == 0.0 && numk%2 != 0){
        /* newstring1 stores a modified string that is having its k most recent characters reversed. When newstring1 has stored all of the 
         * modified string, it is stored in newstring, which contains the string to be returned by the method */
        StringBuilder newstring1 = new StringBuilder();       
        numk = numk + 1;
        char c = string.charAt(i);
        newstring.append(c);
        String segment = newstring.toString();                // segment stores the most recent version of the string stored in 'newstring' 
        int sum = segment.length() - 1 + (numk - 1)*k;        // sum initially stores the highest character index of the segment string
        /* Goal: to copy the entire string in 'newstring' into 'newstring1' except with the k most recent characters in reverse order; 
         * Preconditions: most recent k interval should be reversed */
        for(int p = 0; p <= segment.length() - 1; p = p + 1){
          if(p <=(segment.length() - (1 + k))){
            newstring1.append(segment.charAt(p));
          }
          else 
            newstring1.append(segment.charAt(sum));
            sum = sum - 1;
        }
        newstring = newstring1;
      }
      // Checks if the last non-k characters of the input string should be reversed
      else if(i == string.length() - 1 && ((double)(i + 1)/k) - (i + 1)/k != 0.0 && numk%2 != 0){
        // newstring1 stores a modified string that is having its k most recent characters reversed
        StringBuilder newstring1 = new StringBuilder();
        char c = string.charAt(i);
        newstring.append(c);
        // segment stores the most recent version of the string stored in 'newstring' 
        String segment = newstring.toString();
        // sum initially stores the highest character index of the segment string
        int sum = segment.length() - 1 + numk*k;
        /* Goal: to copy the entire string in 'newstring' into 'newstring1' except with the most recent characters (which total out as less 
         * than k characters) reversed; Preconditions: the last non-k characters of the input string should be reversed */
        for(int p = 0; p <= segment.length() - 1; p = p + 1){
          if(p <=(segment.length() - (1 + segment.length() - numk*k))){
            newstring1.append(segment.charAt(p));
          }
          else 
            newstring1.append(segment.charAt(sum));
            sum = sum - 1;
        }
        newstring = newstring1;
      }
    }
    return newstring.toString();
  }
  
  /* Takes an input string and returns an output string identical to the input string except that any digits 0 to 9 are in reverse order 
   * (but in the same locations) */
  public static String reverseDigits(String string){
    StringBuilder newstring = new StringBuilder();                // newstring stores the output string that will be returned by the method 
    int j = string.length() - 1;                                  // j initially stores the highest character index of the input string
    int i = 0;                                                    // i initially stores the lowest character index of the input string
    /* Goal: to return a modified string with the specifications listed above by comparing the characters at a left index and a right index in
     * the string, both indices of which are iterated to the left and right, respectively */
    while((newstring.toString()).length() < string.length()){
      /* Checks if the original right index value has sunk lower than the lowest character index of the input string. If it has, newstring will
       * add the rest of the input string */
      if(j > -1){
        // Checks if the characters at the right and left index are both digits between 0 and 9
        if(((int)string.charAt(i)>= 48 && (int)string.charAt(i)<=57 && (int)string.charAt(j) >= 48 && (int)string.charAt(j) <= 57)){
          newstring.append(string.charAt(j));
          j = j - 1;
          i = i + 1;
        }
        // Checks if the character at the left index is a digit and if the character at the right index is a non-digit
        else if (((int)string.charAt(i)>= 48 && (int)string.charAt(i)<=57 && (int)string.charAt(j) < 48 || (int)string.charAt(j) > 57)){
          j = j - 1;        
        }
        // Checks if the character at the left index is a non-digit and the character at the right index is a digit
        else if (((int)string.charAt(i)< 48 || (int)string.charAt(i)>57 && (int)string.charAt(j) >= 48 && (int)string.charAt(j) <= 57)){
          newstring.append(string.charAt(i));
          i = i + 1;
        }
        // Checks if the characters at the left and right index are both non-digits
        else if (((int)string.charAt(i)< 48 || (int)string.charAt(i)>57 && (int)string.charAt(j) < 48 || (int)string.charAt(j) > 57)){
          newstring.append(string.charAt(i));
          i = i + 1;
          j = j - 1;
        }
        else 
          newstring.append(string.charAt(i));
      }
      else{
        newstring.append(string.charAt(i)); 
        i = i + 1;
      }
    }
    return newstring.toString();
  }
  
  /* Takes an input string, and returns an output string that is identical to the input except that any text inside a pair of matched 
   * parentheses, including the parentheses, is removed. If there are multiple matched parentheses within each other, the text within the 
   * innermost pair is retained if the total number of matched parenthese pairs is even, and removed if the number is odd */
  public static String editOut(String string){
    StringBuilder newstring = new StringBuilder();        // newstring stores the output string that will be returned by the method
    int i = 0;                                            // i stores the character index of the input string
    // If string has matching parentheses, method is executed, otherwise the string "Input does not contain matching parentheses!" is outputted
    if(HW2.matchingParentheses(string) == true){
      while(i <= string.length() - 1){
      int sum = 0;                                        // sum stores the total number of '(' encountered 
      // marker, when added to the index i, stores the index of the first ')' encountered in the loop
      int marker = 0;
        // If a character in the input string is equal to '(', if statement is executed, otherwise character is appended to newstring
        if(string.charAt(i) == '('){
          /* Goal: to store the total number of '(' encountered so far in variable sum; Precondition: input string must have matching 
           * parentheses and a ')' cannot be encountered */
          for(int k = i;string.charAt(k) != ')';k = k + 1){
          marker = marker + 1;
            if(string.charAt(k) == '('){
              sum = sum + 1;
            }
          }
          int marker3 = marker + i;                         // marker3 stores the index of the last ')' encountered in the loop
          /* Goal: to store the index of the last ')' encountered in the loop in the variable marker3; Precondition: variable sum must be have a
           * stored total value, input string must have matching parentheses, and the total number of ')' encountered must not equal the sum 
           * value */
          for(int k = marker3, j = 0; j != sum; k = k + 1){
          marker3 = marker3 + 1;
            if(string.charAt(k) == ')'){
              j = j + 1;                                    // j stores the total number of ')' encountered in the loop
            }
          }
          int marker2 = i;                                  // marker2 stores the index of the last '(' encountered in the loop, plus one
          /* Goal: to store the index of the last '(' encountered in the loop in the variable marker2; Precondition: variable marker3 must have a
           * stored value, input string must have matching parentheses, and total number of '(' encountered must not equal the sum value */
          for(int k = i, j = 0;j != sum; k = k + 1){
          marker2 = marker2 + 1;
            if(string.charAt(k) == '('){
              j = j + 1;                                     // j stores the total number of ')' encountered in the loop
            }
          }
          // Checks if text inside a set of matching parentheses should be retained or removed
          if(sum%2 == 0){
            for(int k = marker2;k <= marker + i - 1;k = k + 1){
              newstring.append(string.charAt(k));
            }
          }
          else
            newstring.append(' ');
          //The next value of i is set to marker3 - 1
          i = marker3 - 1;
        }
        else 
          newstring.append(string.charAt(i));
          i = i + 1;
      }
      return newstring.toString();
    }
    else
      return "Input does not contain matching parentheses!";
  }

  /* Takes two input strings and returns an output string that contains the contents of the first string except that the matching parentheses 
   * substrings in the first string are replaced by their corresponding matching parentheses substrings in the second string */
  public static String replaceText(String string1, String string2){
    int i = 0;                                              // i stores the character index of the first input string
    int y = 0;                                              // y stores the character index of the second input string
    StringBuilder newstring = new StringBuilder();          // newstring stores a modified version of the second input string
    StringBuilder newstring1 = new StringBuilder();         // newstring1 stores a modified version of the first input string 
    // sum3 stores the number of times the largest if statement in the second while loop is executed 
    int sum3 = 0;                                 
    // sum 4 stores the number of times the largest if statement in the first while loop is executed
    int sum4 = 0;
    if (HW2.matchingParentheses(string1) && HW2.matchingParentheses(string2)){
      /* Goal: To create a modified version of the second input string that contains a string with important information regarding the 
       * matching parenthese substrings of the second string, as well as the substrings themselves */
      while(y <= string2.length() - 1){
      int sum2 = 0;                                           // sum2 stores the total number of '(' encountered per execution of the if statement
      int marker4 = 0;                                        // marker4, when added to y, stores the index of the first ')' encountered 
        // Second input string begins modification as soon as a '(' is encountered in the string
        if(string2.charAt(y) == '('){ 
        sum4 = sum4 + 1; 
          /* Goal: To store a value for marker4 as well as the total number of encountered '(' in the variable sum2; Precondition: a '(' must 
           * be encountered in the input string */
          for(int k = y;string2.charAt(k) != ')';k = k + 1){
          marker4 = marker4 + 1;
            if(string2.charAt(k) == '('){
              sum2 = sum2 + 1;
            }
          }
          int marker5 = marker4 + y;                          // marker5 stores the index of the last ')' encountered
          /* Goal: To store a value for marker5; Precondition: a value must be stored in marker4 */
          for(int k = marker5, j = 0; j != sum2; k = k + 1){
          marker5 = marker5 + 1;
            if(string2.charAt(k) == ')'){
              j = j + 1;
            }
          }
          int marker6 = y;                                    // marker6 stores the index of the last '(' encountered, plus one 
          /* Goal: To store a value for marker6 */
          for(int k = y, j = 0;j != sum2;k = k + 1){
          marker6 = marker6 + 1;
            if(string2.charAt(k) == '('){
              j = j + 1;
            }
          }
          /* Important numerical values are appended to the newstring BEFORE the matching parentheses substring is appended */
          newstring.append((char)sum4);
          newstring.append((char)sum2);
          newstring.append((char)(marker4 + y - (marker6 - 1)));
          newstring.append((char)(marker6 - y));
          /* Goal: To add to a modified version of the second input string stored in newstring; Precondition: a value must be stored 
           * in marker5 */
          for(int k = y;k < marker5;k = k + 1){
            newstring.append(string2.charAt(k));
          }
          // The next value of y is set to marker5
          y = marker5;
        }
        else
          y = y + 1;
      }
      String b = newstring.toString();                      // b stores the string that is stored in newstring, completed from the first while loop
      /* Goal: To create a modified version of the first string according to the specifications of the method. This modified version
       * will be the final string output of the method */
      while(i <= string1.length() - 1){
      int sum = 0;                                          // sum stores the total number of '(' encountered
      int marker = 0;                                       // marker, when added to i stores the index of the first ')' encountered
         // First input string begins modification as soon as a '(' is encountered 
         if(string1.charAt(i) == '('){
         sum3 = sum3 + 1; 
            /* Goal: To store a value in marker as well as the total number of '(' encountered in the variable sum; Precondition: a '(' is 
             * encountered in the input string */
            for(int k = i;string1.charAt(k) != ')';k = k + 1){
            marker = marker + 1;
              if(string1.charAt(k) == '('){
                sum = sum + 1;
              }
            }
            int marker3 = marker + i;                       // marker3 stores the index of the last ')' encountered
            /* Goal: To store a value in marker3; Precondition: a value must be stored in marker */
            for(int k = marker3, j = 0; j != sum; k = k + 1){
            marker3 = marker3 + 1;
              if(string1.charAt(k) == ')'){
                j = j + 1;
              }
            }
            int marker2 = i;                               // marker2 stores the index of the last '(' encountered, plus one 
            /* Goal: To store a value in marker2 */
            for(int k = i, j = 0;j != sum; k = k + 1){
            marker2 = marker2 + 1;
              if(string1.charAt(k) == '('){
                j = j + 1;
              }
            }
            int g = 0;                                     // g stores the character index of the string b
            /* Goal: To modify the first input string according to the specifications of the method listed above; Preconditions: newstring must 
             * store a completed string, the variables sum3 and sum must have stored values */
            while(g <= b.length() - 1){
              // Checks if a substring stored in string b is a matching substring to the current one being checked in the first input string
              if((int)b.charAt(g) == sum3){
                /* Checks if both compared substrings have the same number of matching parentheses or if the 1st substring has more matching
                parentheses than the second */
                if((int)b.charAt(g+1) == sum || (int)b.charAt(g+1) < sum){
                  /* Goal: To replace a substring in the first input string by its matching substring in the second input string; Preconditions:
                   * both substrings must corresponding to each other, and either have the same number of matched parentheses OR the first substring
                   * has more matching parentheses */
                  for(int p = g + 5;p <= g + 5 - ((int)b.charAt(g+3) - 2);p = p + 1){
                    newstring1.append(b.charAt(p));
                  }
                }
                // Is executed if the second substring contains more matching parentheses than the first substring
                else{
                  // tracker, when added to g + 4, stores the index of the character after the first '(' encountered 
                  int tracker = 0;  
                  /* Goal: To store a value in tracker; Preconditions: the second substring must contain more matching parentheses
                   * than the first substring */
                  for(int p = g + 4, j = 0;j != sum;p = p + 1){
                  tracker = tracker + 1;
                    if (b.charAt(p) == '('){
                      j = j + 1;
                    }
                  }
                  /* Goal: To replace a matching parentheses substring in the first input string by its corresponding substring in the 
                   * second input string; Preconditions: tracker must store a value */
                  for(int p = tracker + g + 5, j = 0;p <= b.length() - 1; p = p + 1){
                    if(b.charAt(p) == ')'){
                      j = j + 1;
                    }
                    if(j != sum){
                      newstring1.append(b.charAt(p));
                    }
                  }
                }
                 // sum6 stores the index of the character that comes after a specified substring stored in string b
                int sum6 = 0;                        
                /* Goal: To store a value into the variable sum6; Precondition: a value must be stored in sum3 */
                for(int p = 0, j = 0;j != sum3;p = p + 1){
                sum6 = sum6 + 1;
                  if(b.charAt(p) == ')'){
                    j = j + 1;
                  }
                }
                // The next value of g is set to sum6
                g = sum6; 
              }
            }
            // The next value of i is set to marker3 - 1
            i = marker3 - 1;
         }
         // Is executed if a '(' is not encountered in the first input string
         else{
           newstring1.append(string1.charAt(i)); 
           i = i + 1;
         }
      }
      return newstring1.toString();     
    }
    else
      return "Input does not contain matching parentheses!"
  }
}


    
   
                         

    
        
        
  
        
        
        
        
        
        
        
        
        
        
