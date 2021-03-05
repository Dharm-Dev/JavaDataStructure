/*
Programmer: Dharm Vashisth
Description: Abstract Data Type(ADT) ArrayList implementation in java.
*/
class ArrayList<T>{
    private T[] ar;
    private static int D=10;//default initial capacity
    private int size;
    private int capacity;
    ArrayList(int n){
        ar=(T[])new Object[n];    
        capacity=n;
        size=0;
    }
    ArrayList(){
        this(D);
    }
    public void disp(){
        System.out.println("\tcapacity "+capacity+" and size "+size );
        if(size<1)
            System.out.print("Empty List");
        else
            for(int i=0;i<size;i++)
                System.out.print(ar[i]+" ");    
           
        System.out.println("\n");
    }
    private void adjustList(){
        if(size>=capacity){    
            capacity*=2; // doubles the capacity.
            T[] ar2=(T[])new Object[capacity];
            for(int i=0;i<size;i++)
                ar2[i]=ar[i];
            ar=(T[])new Object[capacity];
            for(int i=0;i<size;i++)
                ar[i]=ar2[i];
            ar2=null; // collected by GC.
        }
    }
    public void addToFront(T s){
        if(size>=capacity)
            adjustList();// expand capacity of an array. 
        for(int i=size;i>0;i--)
            ar[i]=ar[i-1];
        ar[0]=s;
        
        size++;
            //o(N)
    }
    public void addToIndex(T s,int i){
        if(size>=capacity)
            adjustList();// expand size of an array. 
        
        for(int j=size+1;j>i;j--){
                ar[j]=ar[j-1];    
        }
        ar[i]=s;
        size++;
        //O(N).
    }
    public void addToBack(T s){
        if(size>=capacity)
            adjustList();// expand size of an array. 
        ar[size]=s;
        size++;
        // O(N)/O(1)
    }
    public T removeFromBack(){
        T e;
        size--;
        e=ar[size];
        ar[size]=null;
        return e;
        //O(1)
    }
    public T removeFromFront(){
        T e;
        e=ar[0];
        for(int i=0;i<size-1;i++)
            ar[i]=ar[i+1];
        size--;
        ar[size]=null;
        
        return e;
        //O(N)
    }
    public T removeFromIndex(int i){
        T e=ar[i];
        for(int j=i;j<size-1;j++){
                ar[j]=ar[j+1];    
        }
        
        size--;
        ar[size]=null;
        return e;
        //O(N).
    }
}

public class MyArrayList{

    public static void main(String[] args){
     ArrayList<Integer> a=new ArrayList<>();
     System.out.println("\n\tDemonstration of ArrayList in Java.\n");
     a.disp();
     //Initializing array list with 6 elements.
     for(int i=0;i<6;i++)
        a.addToFront(i*3);
     a.disp();
     
     System.out.println("OPERATION:Adding to Front 32");
     a.addToFront(32);
     a.disp();
     
     System.out.println("OPERATION:Adding to Back 34");
     a.addToBack(34);
     a.disp();
     
     System.out.println("OPERATION:Add at index 2 , value 43");
     a.addToIndex(43,2);
     a.disp();
     
     System.out.println("OPERATION:RemovefromFront "+a.removeFromFront());
     a.disp();
     
     System.out.println("OPERATION:RemovefromBack "+a.removeFromBack());
     a.disp();
     
     System.out.println("OPERATION:RemovefromIndex 3 "+a.removeFromIndex(3));
     a.disp();    
    }
}
