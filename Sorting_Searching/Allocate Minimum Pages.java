//http://geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
/*
arr[] = [12, 34, 67, 90], k = 2
1.here each number denotes the number of pages in that particular book
2.k is the num of students where atleast one book should be allocated to each student
3.we need to allocate books to the students such that the student who has the most 
number of pages(cause we allocated more books to the guy ig) still has the minimal
number of pages compared to other possibilities
*/
class Solution {
    public static int findPages(int[] arr, int k) {
        //bro this question sucks they even added an integer overflow, so we need to use long
        //yeah there is an edge case
        if(k>arr.length){ //if the no of books is lower than the student count ,then everyone cannot recieve even one book
            return -1;
        }
        long min=Integer.MAX_VALUE;
        //the highest no of pages one person can recieve while obtaining only one book
        //is the book with the highest number of pages(kinda like worst possible outcome)
        long low=arr[0];
        //the highest no of pages one person can recieve while obtaining many books
        //is the senario where he gets all the books
        long high=0;
        //okay now time to find the actual values for low and high
        for(int i:arr){
            if(i>low){ //low means the book with the highest no of pages dude
                low=i;
            }
            high+=i;
        }
        //lets find the minimum number of pages that is sufficent to statisfy these bastards
        while(low<=high){
            long mid=low+(high-low)/2;
            if(ispossible(arr,k,mid)){
                //this limit can satisfy,so lets check if we can go any lower(chuckles... greedy)
                min=mid; //yeah dont forget to update our minimum possible limit we found,yet
                high=mid-1; //now our new high is our minimized limit
            }
            else{
                //this limit is not possible so we cannot go any lower than this
                low=mid+1;
            }
        }
        return (int)min;
    }
    //fun to verify if the the students can be satisfied with the specified limit
    public static boolean ispossible(int[] arr,int k,long limit){
        int students=1; //yeah initially one student receives the books till the limit is hit
        long pages=0; //to check if the no of pages exceeds the limit
        for(int bookpages:arr){
            //we hit the limit so lets move to the next student with the current book 
            if(pages+bookpages>limit){//no need to use brackets here cause arthimatic operators have higher presedence than binary operators
                students++;
                pages=bookpages;
                //if we cant satisfy all the students with the given limit(i.e more students are needed for this limit)
                if(students>k){//we need to check this codition immediately after updating the no of students
                    return false;
                }
            }
            //we still havent hit the limit so proceed giving the book to the same student
            else{
                pages+=bookpages;
            }
        }
        return true; //all pages are allocated within the limit
    }
    public static void main(String[] args){
        int[] arr={12, 34, 67, 90};
        int k=2;
        System.out.println(findPages(arr,k));
    }
}