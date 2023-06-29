package br.com.ifpe.edu.recife.quiz;

public interface QuizSubject {
    public void registerObserver(QuizObserver o);
    public void removeObserver();
    public void notifyObserver();

}
