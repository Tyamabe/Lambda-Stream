package Exam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NoLambdaTest {

	 public static void main(String[] args) throws Exception {
	        List<Task> list = new ArrayList<>();
	        list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
	        list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
	        list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
	        list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
	        list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));

	        // 未完了のタスクの個数をカウント
	        int countIncompTasks = 0;
	        for (Task task : list) {
	            if (task.isDone() == false) {
	            	countIncompTasks++;
	            }
	        }
	        System.out.println("未完了のタスクの個数は" + countIncompTasks);

	        // 未完了のタスクを日時の昇順に並び替えて一覧表示
	        List<Task> IncompTasks = new ArrayList<>();
	        for (Task task : list) {
	            if (task.isDone() == false) {
	            	IncompTasks.add(task);
	            }
	        }
	        IncompTasks.sort(null); // Comparableを実装しているため、nullを渡して自然順序でソート
	        System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");
	        for (Task task : IncompTasks) {
	            System.out.println(task);
	        }
	    }
	}