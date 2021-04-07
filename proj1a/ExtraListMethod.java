public class ExtraListMethod {
    public static int[] flatten(int[][]x){
        int totalLength = 0;
        for(int i=0; i<x.length;i++){
            totalLength +=x[i].length;
        }

        int[]a =new int[totalLength];
        int aIndex = 0;
        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[i].length;j++){
            a[aIndex]=x[i][j];
            aIndex+=1;
            }
        }
        return a;
    }
    public static void print(int[] x){
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
    }

    public static void main(String[] args){
        int[][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] x2=flatten(x);
        print(x2);

    }



}