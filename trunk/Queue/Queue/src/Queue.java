//
//  Queue.java
//  Queue
//
//  Created by Justin Uang on 2/4/08.
//  Copyright (c) 2008 __MyCompanyName__. All rights reserved.
//
import java.util.*;

public class Queue {

    public static void main (String args[]) {
        WordCountQueue waitingLine = new WordCountQueue();
		System.out.println(waitingLine.size());
		waitingLine.enque("1");
		System.out.println(waitingLine.size());
		waitingLine.enque("2");
		System.out.println(waitingLine.size());
    }
}
