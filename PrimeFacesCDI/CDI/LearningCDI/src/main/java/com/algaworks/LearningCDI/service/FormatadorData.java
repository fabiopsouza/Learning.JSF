package com.algaworks.LearningCDI.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.enterprise.inject.Produces;

public class FormatadorData {

	@Produces
	@Brasil
	public DateFormat getFormatadorDataBrasil(){
		return new SimpleDateFormat("dd 'de' MMMM 'de' yyyy ", new Locale("pt", "BR"));
	}
	
	@Produces
	public DateFormat getFormatadorEUA(){
		return new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
	}
}
