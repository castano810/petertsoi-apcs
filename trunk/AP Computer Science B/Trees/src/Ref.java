
public class Ref {
    
    
    
    public int test()
    {
        Integer asdf = new Integer(1);
        testHelper(asdf);
        
        return asdf.intValue();
    }
    
    public void testHelper(Integer test)
    {
        test = new Integer(5);
    }
    
    public static void main(String[] args) {
        Ref tester = new Ref();
        System.out.println(tester.test());
        
    }

}
