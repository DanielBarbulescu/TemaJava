import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class MyThread extends Thread{
    private ArrayList<Human> humans = null;
    private Object mutex = null;
    private ServerSocket server;
    private Human createHuman(String inputLine)
    {
        String[] content = inputLine.split(" ");
        Human human = null;

        if(content[0].equals("Student")){
            human = new Student(content[1], content[2], content[3],
                    Integer.parseInt(content[4]),  Integer.parseInt(content[5]));
        }
        else if(content[0].equals("Profesor")) {
            human = new Profesor(content[1], content[2], content[3],
                    Integer.parseInt(content[4]), content[5]);
        }

        return human;
    }

    public void run() {
        System.out.println(this.getName() + " thread is running...");
        try {
            Socket client = server.accept();
            PrintWriter out =
                    new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            out.println("Server: Conexiune realizata");

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals("Bye."))
                    break;
                synchronized (mutex) {
                    humans.add(this.createHuman(inputLine));
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyThread(ServerSocket server, ArrayList<Human> humans, Object mutex) {
        this.server = server;
        this.humans = humans;
        this.mutex = mutex;
    }


}
