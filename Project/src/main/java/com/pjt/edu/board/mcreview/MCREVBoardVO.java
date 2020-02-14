package com.pjt.edu.board.mcreview;

import com.pjt.edu.board.BoardVO;

public class MCREVBoardVO extends BoardVO{
int seq, viewcount;
String title, contents, writer, regdate;
public int getSeq() {
	return seq;
}
public void setSeq(int seq) {
	this.seq = seq;
}
public int getViewcount() {
	return viewcount;
}
public void setViewcount(int viewcount) {
	this.viewcount = viewcount;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContents() {
	return contents;
}
public void setContents(String contents) {
	this.contents = contents;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public String getRegdate() {
	return regdate;
}
public void setRegdate(String regdate) {
	this.regdate = regdate;
}
@Override
public String toString() {
	return "MCREVBoardVO [seq=" + seq + ", viewcount=" + viewcount + ", title=" + title + ", contents=" + contents
			+ ", writer=" + writer + ", regdate=" + regdate + "]";
}


}
