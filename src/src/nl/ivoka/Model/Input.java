package nl.ivoka.Model;

import nl.ivoka.Main;

import java.io.IOException;

public class Input {

    public static void userInput() throws IOException {

        for (Question question : Main.allQuestions.list.values()) {

            if (!question.optional) {

                answerQuestion(question);
            } else if (question.optional && Main.advancedOptions){

                if (question.method == (Main.allQuestions.list.get(Main.VAR.METHOD).answer
                        ? Main.METHOD.ENCRYPT : Main.METHOD.DECRYPT)) {

                    answerQuestion(question);
                }
            } else {
                // WHEN QUESTION IS OPTIONAL BUT ADVANCED OPTIONS IS NOT TRUE
            }
        } // for loop

        Main.allQuestions.list.get(Main.VAR.METHOD).method = (Main.allQuestions.list.get(Main.VAR.METHOD).answer
                ? Main.METHOD.ENCRYPT : Main.METHOD.DECRYPT);
    }

    static void answerQuestion(Question question) throws IOException {
        Main.print(question.questionText);
        if (question.yesno) {

            String input = Main.readLine();
            if (input.trim().length() > 0) {

                if (question.check[0] == input.toCharArray()[0])
                    question.answer = true;
                else if (question.check[1] == input.toCharArray()[0])
                    question.answer = false;
                else
                    Main.println(question.defaultMessage);
            }
        } else
            question.answerText = Main.readLine();
    }
}
