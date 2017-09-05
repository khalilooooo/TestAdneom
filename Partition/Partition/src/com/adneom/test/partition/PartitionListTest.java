package com.adneom.test.partition;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author khalil RIAHI
 * 
 *         MyPartitionTest contains different values of data for list testing
 */
public class PartitionListTest {
	static final Logger logger = Logger.getLogger(PartitionListTest.class);
	List<Integer> list = new ArrayList<Integer>();

	@Before
	public void init() {
		BasicConfigurator.configure();

	}

	@Test
	public void partitionTest1() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		List<List<Integer>> partition = PartitionList.partition(list, 1);
		assertTrue(partition.size() == 11);
		assertTrue(partition.get(0).size() == 1);
		logger.info("(" + list + "return " + partition + "," + 1 + ")");


	}

	@Test
	public void partitionTest2() {
		List<String> list = new ArrayList<String>();
		list.add("One");
		list.add("TwO");
		list.add("Three");
		list.add("Four");
		list.add("Five");
		list.add("Sex");
		list.add("Seven");
		list.add("Eight");
		list.add("Night");
		list.add("Ten");
		list.add("Eleven");
		List<List<String>> partition = PartitionList.partition(list, 7);
		assertTrue(partition.size() == 2);
		assertTrue(partition.get(0).size() == 7);
		assertTrue(partition.get(1).size() == 4);
		logger.info("(" + list + "return " + partition + "," + 7 + ")");

	}
}
