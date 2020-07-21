package codewarriors;

import java.util.List;

//TODO: complete this object/class

public class PaginationHelper<I> {
	List<I> collection;
	int itemsPerPage;
	/**
	 * The constructor takes in an array of items and a integer indicating how many
	 * items fit within a single page
	 */
	public PaginationHelper(List<I> collection, int itemsPerPage) {
		this.collection = collection;
		this.itemsPerPage = itemsPerPage;
	}

	/**
	 * returns the number of items within the entire collection
	 */
	public int itemCount() {
		return this.collection.size();
	}

	/**
	 * returns the number of pages
	 */
	public int pageCount() {
		int pages = this.collection.size()/this.itemsPerPage;
		int remainder = this.collection.size()%this.itemsPerPage;
		if (remainder == 0) {
			return pages;
		} else {
			return pages+1;
		}
	}

	/**
	 * returns the number of items on the current page. page_index is zero based.
	 * this method should return -1 for pageIndex values that are out of range
	 */
	public int pageItemCount(int pageIndex) {
		int totalPages = this.collection.size()/this.itemsPerPage;
		int remainder = this.collection.size()%this.itemsPerPage;
		totalPages = remainder != 0 ? totalPages+1 : totalPages;
		if (pageIndex < 0) return -1;
		if (pageIndex > totalPages-1) return -1;
		if (pageIndex == totalPages-1) return this.collection.size()-(this.itemsPerPage*(totalPages-1));
		return this.itemsPerPage;
	}

	/**
	 * determines what page an item is on. Zero based indexes
	 * this method should return -1 for itemIndex values that are out of range
	 */
	public int pageIndex(int itemIndex) {
		if (itemIndex < 0 || itemIndex >= this.collection.size()) return -1;
		int i = itemIndex / this.itemsPerPage;
		return i;
	}
}
