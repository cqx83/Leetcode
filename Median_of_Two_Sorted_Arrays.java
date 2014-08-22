// O(n)
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        boolean even = (m+n)%2 == 0;
        int k = (m+n+1)/2, a=0, b=0;
        double f1 = 0, f2 = 0;
        while(k-->0) {
            if(a >= m)  
                return even ? ((double)(B[b+k+1]+B[b+k]))/2 : B[b+k];
            else if(b >= n) 
                return even ? ((double)(A[a+k+1]+A[a+k]))/2 : A[a+k];
            else {
                f1 = A[a] <= B[b] ? A[a++] : B[b++];
            }
        }
        if(!even)    return f1;
        if(a >=m || b >=n)  f2 = a>=m ? B[b] : A[a];
        else f2 = A[a] <= B[b] ? A[a] : B[b];
        return (f1+f2)/2;
    }
}

// O(logn)
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        boolean even = (m+n)%2 == 0;
        int k=(m+n-1)/2,l = 0, r = m-1;
        int mid = 0, comp = 0;
        while(l <= r) {
            mid = l+(r-l)/2;
            comp = k-mid;
            if(get(A,mid) >= get(B,comp-1) && get(A,mid) <= get(B,comp))    break;
            else if(get(A,mid) > get(B,comp))   r = mid-1;
            else    l = mid+1;
        }
        if(l > r)   return findMedianSortedArrays(B,A);
        if(!even)   return A[mid];
        double more = Math.min(get(A,mid+1),get(B,comp));
        return (A[mid]+more)/2;
    }

    int get(int[] num, int x) {
        if(x < 0)   return Integer.MIN_VALUE;
        if(x >= num.length) return Integer.MAX_VALUE;
        return num[x];
    }
}