package com.koreait.fashionshop.model.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class Pager {
	private List list;
	private int totalRecord=0; // �� ���ڵ� ��
	private int pageSize = 10; //������ �� ������ ���ڵ� ��
	private int totalPage; // �� �����ؾ� �� ������
	private int blockSize = 10; //���� ������ ������ ��
	private int currentPage = 1; // ���� ������
	private int firstPage;
	private int lastPage;
	private int curPos;
	private int num;
	
	//����� ���� �ʱ�ȭ
	//�ǽð����� �Խñ� ��, ���� ������ ���� ������ �ٲ�� ������ �ش� �����ʹ� �Ʒ����� ���� �� �����ؾ���
	public void init(HttpServletRequest request, List list) {
		this.list = list;
		totalRecord = list.size();
		totalPage = (int)Math.ceil((float)totalRecord/pageSize); // 26�� ���ڵ��� 2.6���� �������ε� �̴� 3���� �Ǿ��ϹǷ� �ø����� �� ����ȯ
		//�������� ������ ���, �� ���õ� �������� ��ü
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		firstPage = currentPage - (currentPage-1)%blockSize; // ���� �������� 4���, 4 - (4-1)%10 = 1�� ���´� �� 1~10�� 1�� ������ ���� 
		lastPage = firstPage + (blockSize-1); // ������ ���� ù �������� 9�� ������
		curPos = (currentPage-1) * pageSize; //�������� List�������� ���� Index
		num = totalRecord - curPos; //�������� ���� ��ȣ
		
	}
	public List getList() {
		return list;
	}
	
	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getCurPos() {
		return curPos;
	}

	public void setCurPos(int curPos) {
		this.curPos = curPos;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
