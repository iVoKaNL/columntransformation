package nl.ivoka.Model;

import nl.ivoka.Main;

public class Question {

    public boolean yesno;
    public String questionText;
    public boolean answer;
    public String answerText;
    public boolean optional;
    public Main.METHOD method;
    public String defaultMessage;
    public char[] check;

    Question(String questionText, boolean answer, String defaultMessage, char[] check) {
        this.questionText = questionText;
        this.answer = answer;
        this.defaultMessage = defaultMessage;
        this.check = check;
        yesno = true;
        optional = false;
    }
    Question(String questionText, String answerText, String defaultMessage) {
        this.questionText = questionText;
        this.answerText = answerText;
        this.defaultMessage = defaultMessage;
        yesno = false;
        optional = false;
    }
    Question(String questionText, boolean answer, String defaultMessage, char[] check,
             boolean optional, Main.METHOD method) {
        this.questionText = questionText;
        this.answer = answer;
        this.defaultMessage = defaultMessage;
        this.check = check;
        this.optional = optional;
        this.method = method;
        yesno = true;
    }
    Question(String questionText, String answerText, String defaultMessage,
             boolean optional, Main.METHOD method) {
        this.questionText = questionText;
        this.answerText = answerText;
        this.defaultMessage = defaultMessage;
        this.optional = optional;
        this.method = method;
        yesno = false;
    }
}
