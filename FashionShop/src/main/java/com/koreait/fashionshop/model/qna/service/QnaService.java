package com.koreait.fashionshop.model.qna.service;

import java.util.List;

import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.domain.Qna;

public interface QnaService {
	public List selectAll();
	public List selectAll(Member member);
	public Qna select(int qna_id);
	public void insert(Qna qna);
	public void reply(Qna qna);
	public void update(Qna qna);
	public void delete(int qna_id);
}
