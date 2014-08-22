public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)   return false;
        if(x < 10)  return true;
        if(x%10 == 0)   return false;
        int comp = 0;
        while(x >= 10) {
            int bit = x%10;
            x /= 10;
            if(comp == x)   return true;
            comp = comp*10+bit;
            if(comp == x)   return true;
        }
        return false;
    }
}