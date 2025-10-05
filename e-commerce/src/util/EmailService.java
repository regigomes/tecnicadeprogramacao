package util;

public class EmailService {
    public static void notificar(String cliente, String mensagem) {
        new Thread(() -> System.out.println("Email para " + cliente + ": " + mensagem)).start();
    }
}