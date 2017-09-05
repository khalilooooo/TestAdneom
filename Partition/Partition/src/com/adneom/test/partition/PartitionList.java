package com.adneom.test.partition;

import java.util.AbstractList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 *
 * @param list  the list to return consecutive sublists
 *           
 * @param size  the desired size of each sublist (the last may be smaller)
 *           
 * @return a list of consecutive sublists
 * @throws IllegalArgumentException
 *             if {@code partitionSize} is non positive
 *
 * 
 */
public class PartitionList {
	static final Logger logger = Logger.getLogger(PartitionList.class);

	public static <T> List<List<T>> partition(List<T> list, int size) {

		if (list == null) {
			logger.error("list is not referenced in the memory, list must instanciated");

			throw new NullPointerException("'list' must not be null");
		}
		if (!(size > 0)) {
			logger.error("Problem with the size of list");

			throw new IllegalArgumentException("'size' must be greater than 0");

		}

		return new Partition<T>(list, size);
	}

	private static class Partition<T> extends AbstractList<List<T>> {

		final List<T> list;
		final int size;

		Partition(List<T> list, int size) {
			this.list = list;
			this.size = size;
		}

		@Override
		public List<T> get(int index) {

			logger.debug("List: " + list);

			int listSize = size();
			if (listSize < 0) {
				logger.error("size is negative");

				throw new IllegalArgumentException("negative size: " + listSize);
			}
			if (index < 0) {
				logger.error("index is negative");

				throw new IndexOutOfBoundsException("index " + index + " must not be negative");
			}
			if (index >= listSize) {
				throw new IndexOutOfBoundsException("index " + index + " must be less than size " + listSize);
			}
			int start = index * size;
			int end = Math.min(start + size, list.size());
			return list.subList(start, end);

		}

		@Override
		public int size() {
			return (list.size() + size - 1) / size;
		}

		@Override
		public boolean isEmpty() {
			return list.isEmpty();
		}

	}

}