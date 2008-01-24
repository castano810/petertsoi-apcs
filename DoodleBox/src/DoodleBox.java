public class DoodleBox {
    private int[] intArray;
    public DoodleBox(int start) {
        intArray = new int[(start*start)];
        int iter;
        if (start%2 == 1){
            iter = (start/2)+1;
        } else {
            iter = start/2;
        }
        int insertNumber = start;
        
        for (int c=0; c<iter;c++){
            for (int i=c;i<(start-c);i++){
                for(int j=c; j<(start-c);j++){
                    intArray[(start*i)+j] = insertNumber;
                }
            }
            insertNumber-=2;
        }
    }
    
    public void dump(){
        int start = (int)Math.sqrt((intArray.length));
        for(int i=0; i<start;i++){
            for(int j=0; j<start; j++){
                System.out.print(intArray[(start*i)+j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        DoodleBox myBox = new DoodleBox(9);
        myBox.dump();
    }
}
