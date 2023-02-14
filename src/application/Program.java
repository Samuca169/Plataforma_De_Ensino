package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int quantDeAulas = sc.nextInt();
		
		System.out.println();
		for (int i=1; i<=quantDeAulas; i++) {
			System.out.println("Dados da " + i + "a aula:");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char type = sc.next().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String titulo = sc.nextLine();
			if (type == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.next();
				System.out.print("Duração em segundos: ");
				int segundos = sc.nextInt();
				list.add(new Video(titulo, url, segundos));
			}else {
				System.out.print("Descrição:");
				String descricao = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int quantDeQuestoes = sc.nextInt();
				list.add(new Task(titulo, descricao, quantDeQuestoes));
			}
			System.out.println();
		}
		
		int total = 0;
		for (Lesson lesson : list) {
			total += lesson.duration();
		}
		
		System.out.println("DURAÇÃO TOTAL DO CURSO = " + total + " segundos");
		sc.close();
	}
}
