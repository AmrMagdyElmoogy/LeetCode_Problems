class Solution {
public:
    int mySqrt(int x) {
        long left = 1;
        long right = x;
        int result = 0;
        if(x < 2){
          return x;
        }
        while(left<=right)
        {
            long mid = left + (right-left)/2;
            if(mid*mid <= x)
            {
                result = mid;
                left = mid + 1;
            } 
            else 
                right = mid - 1;
        } 
        return result;
    }
};