package days.fifth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RandomQuestionExample {

    public static void main(String[] args) {
        List<Question> question = readQuestionsFile();
        Scanner scanner = new Scanner(System.in);
        AtomicInteger count = new AtomicInteger();
        question.forEach(q->{
            System.out.println(q.getQuestion());
            q.getOptions().forEach(System.out::println);
            String answer = scanner.nextLine();
            if(answer.equals(q.getAnswer())){
                count.getAndIncrement();
            }
        });

        System.out.println("Jus atsakete i " + count.get());
    }

    private static List<Question> readQuestionsFile() {
        List<Question> questions = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader("questions.txt"))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] items = line.split(";");
                Question q = new Question(items[0], items[1], Arrays.asList(items).subList(2, items.length));
                questions.add(q);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return questions;
    }
}
