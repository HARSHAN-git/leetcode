//we are going to use a concept called gap
//first we calculate gap using the formula gap=(len+1)/2 ,here len is m+n
//we iterate till gap is 0 using a while loop
//we use two pointers-> i=0 and j=gap(initially)
//we compare i and j initally with the gap and swap them 
//remember that the values of i and j may or may not be pointing the same array
//after each swap we increment i and j
//when j becomes>=len then the new gap is determined by gap=(gap+1)/2

//this helps us to compare elements and decrease the no of combinations of comparitions
class Solution {
    public void mergeArrays(int a[], int b[]) {
        int n=a.length;
        int m=b.length;
        int len=n+m;
        //our mvp enters here
        int gap=(len+1)/2;
        while(gap>0){
            int i=0;
            int j=gap;
            while(j<len){
                int val1=(i<n)?a[i]:b[i-n];
                int val2=(j<n)?a[j]:b[j-n];
                if (val1 > val2) {
                    //both values in a
                    if (i < n && j < n) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                    //val1 in a and val2 in b 
                    else if (i < n) {
                        int temp = a[i];
                        a[i] = b[j - n];
                        b[j - n] = temp;
                    }
                    //both val in b 
                    else {
                        int temp = b[i - n];
                        b[i - n] = b[j - n];
                        b[j - n] = temp;
                    }
                }
                i++;
                j++;
            }
            //update the gap
            if(gap==1){
                gap=0; //cause gap with 0 means comparing the same element
            }
            else{
                gap=(gap+1)/2; //yeah we are decreasing the gap
            }
        }
    }
}
/* 
iteration of example 1:
a[] = [2, 4, 7, 10], b[] = [2, 3]

sol:

len=6

gap =3
j=3,while-> a=[2,3,7,10] , b=[2,4] then gap becomes 2

gap=2
j=2,while-> a=[2,3,2,4] , b=[7,10] then gap becomes 1

gap=1
j=1,while-> a=[2,2,3,4] , b=[7,10] then gap becomes 0
*/





