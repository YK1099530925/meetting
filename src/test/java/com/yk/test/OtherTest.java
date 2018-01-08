package com.yk.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class OtherTest {
	
	@Test
	public void test() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i) == 1 || list.get(i) == 5) {
				System.out.println(list.get(i));
			}else {
				list.remove(i);
				i--;
			}
		}
	}

}
