package br.com.expertpeticoes.curso;

import java.time.LocalDate;
import java.util.Scanner;


public class TETSE {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] values = scan.next().split("-");
		
		String ano = values[2];
		String mes = values[1];
		String dia = values[0];
		
		int year = Integer.parseInt(ano);
		int month = Integer.parseInt(mes);
		int day = Integer.parseInt(dia);
		
		
		LocalDate data = LocalDate.of(year, month, day);
	}
	
}
