import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

public class DailyActiveServer {
    String[] adviceList = {"ешьте меньшими порциями", "купите облегающие джинсы","нет, они делают вас полнее.",
"Два слова: не годится", "Будьте честны хотя бы сегодня."};

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            while(true) {
                Socket sock = serverSocket.accept();

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String getAdvice(){
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyActiveServer server = new DailyActiveServer();
        server.go();
    }
}

