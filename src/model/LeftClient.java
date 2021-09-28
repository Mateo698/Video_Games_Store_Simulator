package model;

import java.util.ArrayList;

public class LeftClient {
	private String id;
	private int pucharse;
	private ArrayList<Integer> games;
	
	public LeftClient(String id, int pucharse, ArrayList<Integer> games) {
		this.id = id;
		this.pucharse = pucharse;
		this.games = games;
	}
	
	public String getId() {
		return id;
	}
	
	public int getPucharse() {
		return pucharse;
	}
	
	public String getCodes() {
		String codes = "";
		for (int i = 0; i < games.size(); i++) {
			codes += games.get(i);
			if(i+1 != games.size()) {
				codes += " ";
			}
		}
		return codes;
	}
}
