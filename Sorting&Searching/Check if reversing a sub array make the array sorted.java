//one of the straight forward shits you have ever seen
//eg:arr{1,2,5,4,3}
//1.find the first arr[i]<arr[i+1] , here 2<5 ,then store indx of 5 as x=2 and y as y=i+1=3
//2.in the iteration increment y=i+1 as long as the arr[i]>arr[i+1] (that is reverse) ,now y=4(arr[4]=3)
//3.lets reverse the subarray subarray={5,4,3}
//4.now the array becomes arr={1,2,3,4,5}
//5.return ture if the arr is sorted or else false
public class GFG {

  static void reverse(int[] a,int x,int y)
  {
    while(x<y)
    {
      int temp = a[x];
      a[x] = a[y];
      a[y] = temp;
      x++;
      y--;
    }
  }
  static boolean sortArr(int[] a, int n)
  {
    int x = -1;
    int y = -1;
    //watch out the below iteration *important
    for (int i = 0; i < n - 1; i++) {
      if (a[i] > a[i + 1]) {
        if (x == -1) {
          x = i;
        }
        y = i + 1;
      }
    }

    if (x != -1) {
      //after reversing the reversed part lets check if the array is sorted
      reverse(a,x,y);
      for (int i = 0; i < n - 1; i++) {
        //if not sorted return false
        if (a[i] > a[i + 1]) {
          return false;
        }
      }
    }

    return true;
  }

  // Driver Code
  public static void main (String[] args)
  {
    int arr[] = { 1, 2, 5, 4, 3 };
    int n = arr.length;

    if(sortArr(arr, n))
    {
      System.out.println("Yes");
    }
    else
    {
      System.out.println("No");
    }
  }
}

// This code is contributed by aditya942003patil