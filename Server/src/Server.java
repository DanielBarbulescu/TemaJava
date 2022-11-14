import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Collections;

public class Server {
    public static void main(String args[]) {
        int port = Integer.parseInt(args[0]);
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<Human> humans = new ArrayList<>();
        Object mutex = new Object();
        try {
            ServerSocket server = new ServerSocket(port);
            server.setReuseAddress(true);

            for(Integer i = 0; i < Integer.parseInt(args[1]); i++) {
                Thread thread = new MyThread(server, humans, mutex);
                threads.add(thread);
            }

            for(int i = 0; i < threads.size(); i++)
            {
                threads.get(i).start();
            }

            for(int i = 0; i < threads.size(); i++)
            {
                threads.get(i).join();
            }

            Collections.sort(humans);

            for(int i = 0; i < humans.size(); i++)
            {
                System.out.println(humans.get(i).toString());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}