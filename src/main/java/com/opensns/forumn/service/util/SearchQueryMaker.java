package com.opensns.forumn.service.util;

import java.io.ObjectInputStream.GetField;

import com.opensns.forumn.common.Encoder;

public class SearchQueryMaker {
	
	public String getHlQuery(){
		return "&hl=true&hl.fl=post_text&hl.simple.pre=<em>&hl.simple.post=<%2Fem>";
	}
	/**
	 * 
	 */
	public String getFlColumList(){
		StringBuffer sb=new StringBuffer("&fl=");
		sb.append(Encoder.encodingQueryToUTF8(getBasicFlColumList()));
		return sb.toString();
	}
	/**
	 * �⺻���� fl column list
	 */
	public String getBasicFlColumList(){
		String flColumns="forum_id,forum_name,poster_ip,post_time,post_id,post_date,post_subject,post_text,parent_post_username,parent_post_id,parent_post_text,parent_post_subject";		
		return flColumns;
	}
	
	
	
	/**
	 * q ���ǿ� ��� ���� ����
	 * @return
	 */
	public String getQuery(/*�˻����� ��ü*/){
		String query="";
		return query;
	}
	
	/**
	 * q ���� �̿��� ���ǿ� ��� ���� ����
	 * @return
	 */
	public String getAdditionalQuery(/*�˻����� ��ü*/){
		String query="";
		return query;
	}

	
/**************** ���� ����� ****************/
	
	/****** ���� **********/
	//���絵��
	public String sortBySimilarity(){
		String result="";
		return result;
	}
	//�ֽż�
	public String sortByDate(){
		String result="";
		return result;
	}
	/****** ���� **********/
	//��ü(����+����)
	public String fieldScopeAll(){
		String result="";
		return result;
	}
	//����
	public String fieldScopeTitle(){
		String result="";
		return result;
	}
	//����
	public String fieldScopeContent(){
		String result="";
		return result;
	}
	
	/****** �Ⱓ **********/	
	//1��
	public String dateScopeOneDay(){
		String result="";
		return result;
	}
	//1��
	public String dateScopeOneWeek(){
		String result="";
		return result;
	}
	//1����
	public String dateScopeOneMonth(){
		String result="";
		return result;
	}
	//1��
	public String dateScopeOneYear(){
		String result="";
		return result;
	}
	//�Ⱓ�Է�
	public String dateScopeTyping(){
		String result="";
		return result;
	}
	public static void main(String[] args) {
		
	}
}
