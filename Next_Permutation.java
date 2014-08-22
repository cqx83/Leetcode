public class Solution {
    public void nextPermutation(int[] num) {
        int n = num.length;
        for(int i=n-2; i>=0; i--) {
            if(num[i] < num[i+1]) {
                int j = n-1;
                for(; j>=i+1; j--) {
                    if(num[j] > num[i]) break;
                }
                swap(num,i,j);
                reverse(num,i+1,n-1);
                return;
            }
        }
        reverse(num,0,n-1);
        return;
    }

    public void reverse(int[] num, int l, int r) {
        while(l < r) {
            swap(num,l,r);
            l++;
            r--;
        }
    }
    
    public void swap(int[] num, int l, int r) {
        int tmp = num[l];
        num[l] = num[r];
        num[r] = tmp;       
    }
}