import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        try {
            Socket me = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(me.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(me.getInputStream()));
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));

            String fromServer, fromUser;

            if((fromServer = in.readLine()) != null)
            {
                System.out.println(fromServer);
            }

            while ((fromUser = stdIn.readLine()) != null) {
                if (fromUser != null) {
                    out.println(fromUser);
                    if(fromUser.equals("Bye."))
                    {
                        break;
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
