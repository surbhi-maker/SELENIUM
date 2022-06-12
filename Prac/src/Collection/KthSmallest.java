package Collection;

class KthSmallest{  
public static void main(String args[]){
    int k=3;
    int[] arr = {1,5,4,7,8,3};
    //3rd smallest
    //index 0-5
    // System.out.println("size:"+arr.length);
    for(int i=0;i<arr.length-1 ;i++){
        for(int j =i+1;j<arr.length;j++){
            if(arr[i]>arr[j]){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] =temp;
            }
        }
        if(i==k-1){
            System.out.println(arr[i]);
            break;
        }
    }
    
    for(int i =0; i<arr.length;i++) {
    	  System.out.println("sorted array "+arr[i]);
    }
    	
}  
}  