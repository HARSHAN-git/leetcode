//https://www.geeksforgeeks.org/dsa/create-a-matrix-with-alternating-rectangles-of-0-and-x/
//same as spiral matrix but with a counter
class Main {
    public static void main(String[] args){
        int n=4;
        int m=5;
        char[][] arr=new char[n][m];
        fun(arr);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.err.println();
        }
    }
    public static void fun(char[][] arr){
        int row=arr.length;
        int col=arr[0].length;
        int l=0;
        int t=0;
        int r=col-1;
        int b=row-1;
        int count=1;
        while(l<=r && t<=b){
            char c=' ';
            if(count%2==0){
                c='O';
            }
            else{
                c='X';
            }
            for(int i=l;i<=r;i++){
                arr[t][i]=c;
            }
            t++;
            for(int i=t;i<=b;i++){
                arr[i][r]=c;
            }
            r--;
            if(t<=b){
                for(int i=r;i>=l;i--){
                    arr[b][i]=c;
                }
                b--;
            }
            if(l<=r){
                for(int i=b;i>=t;i--){
                    arr[i][l]=c;
                }
                l++;
            }
            count++;
        }
    }
}
