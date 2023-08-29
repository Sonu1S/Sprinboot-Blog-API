package net.javaguide.springboot.payload;

import java.util.List;

public class PostResponse {

	private List<PostDto> content;
	private int pageNo;
	private int pageSize;
	private long totalElement;
	private int totalPages;
	private boolean last;
	
	
	public PostResponse() {
		super();
	}

	public PostResponse(List<PostDto> content, int pageNo, int pageSize, int totalElement, int totalPages,
			boolean last) {
		super();
		this.content = content;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElement = totalElement;
		this.totalPages = totalPages;
		this.last = last;
	}

	public List<PostDto> getContent() {
		return content;
	}

	public void setContent(List<PostDto> content) {
		this.content = content;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalElement() {
		return totalElement;
	}

	public void setTotalElement(long totalElement) {
		this.totalElement = totalElement;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

}
