package Collection;

class KthLargest{  
public static void main(String args[]){
    int k=3;
    int[] arr = {1,5,4,7,8,3};
    //4th largest
    //index 0-5
    // System.out.println("size:"+arr.length);
    for(int i=0;i<arr.length-1 ;i++){
        for(int j =i+1;j<arr.length;j++){
            if(arr[i]<arr[j]){
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
    
    //swaping string without 3rd variable
    
    String a = "Surbhi";
    String b = "kourav";
    
     a = a+b;
     System.out.println(a);
     
     b = a.replaceAll(b, "");
     System.out.println("swap with replace b=:"+b);
     System.out.println("swap with replace a=:"+a.replaceAll(b, ""));
     
     b = a.substring(0 ,a.length()-b.length());
     System.out.println(b);
     
     a = a.substring(b.length());
     System.out.println(a);
     
     
    
}  
}  