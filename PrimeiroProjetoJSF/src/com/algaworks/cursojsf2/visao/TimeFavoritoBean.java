package com.algaworks.cursojsf2.visao;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TimeFavoritoBean {

	private String time;

	private List<String> times;
	
	public void escolher(){
		System.out.println("Time selecionado: " + this.getTime());
	}

	public void escolherMany(){
		System.out.println("\nTimes selecionados: ");
		for(String time : times)
			System.out.println(time);
		System.out.println("-------------------");
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<String> getTimes() {
		return times;
	}

	public void setTimes(List<String> times) {
		this.times = times;
	}
}
