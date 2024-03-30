package Exam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Chapter10 {
    public static void main(String[] args) throws Exception {
        List<Task> list = new ArrayList<>();
        list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
        list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));//対象
        list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
        list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));//対象
        list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));//対象

        //intにしたらエラーになったので、サジェストの通りlongにしてみた
        long countIncompTasks = list.stream()//listの要素をストリームに流す
        		                      .filter(task -> task.isDone() == false)//中間操作1:未完了のものだけ抽出。booleanのgetter
        		                      .count();//終端処理: 要素数(未完了のtask数)を返す
        System.out.println("未完了のタスクの個数は" + countIncompTasks);
        
        //未完了のタスクを日時の昇順に並べて一覧表示
        System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");
        list.stream()//listの要素をストリームに流す
        .filter(task -> task.isDone() == false)//中間操作1:未完了のものだけ抽出
        .sorted(Comparator.comparing(Task::getDate))//中間操作2:タスクを日時で並び替え
        .forEach(System.out::println);//終端処理: 各要素に対し順に処理する
        

    }
}