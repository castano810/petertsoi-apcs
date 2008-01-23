public class Runner {
    public static void main(String[] args)
    {
        LinkedList<Integer>  intList = new LinkedList<Integer>();
	Integer five = new Integer(5);
        intList.insertFront(five);
	intList.insertLast(new Integer(12));
	intList.insertAfter(new Integer(7), five);
        intList.dump();
	System.out.println(intList.contains(five) + "\t" + intList.size());
	intList.remove(five);
	intList.insertLast(five);
	intList.dump();
    }
}
