/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

/**
 *
 * @author Melanio
 */
import java.io.*;
import java.net.*;

/**
   This program makes a socket connection to the atomic clock
   in Boulder, Colorado, and prints the time that the 
   server sends.
*/
public class SocketTest
{  
   public static void main(String[] args)
   {  
      try
      {  
        Socket s = new Socket("192.168.0.9", 3000);
          // Socket s = new Socket("pcagv.elo.utfsm.cl", 13);

         BufferedReader in = new BufferedReader
            (new InputStreamReader(s.getInputStream()));
         boolean more = true;
         while (more)
         {  
            String line = in.readLine();
            if (line == null) 
               more = false;
            else
               System.out.println(line);
         }

      }
      catch (IOException e)
      {  
         e.printStackTrace();
      }
   }
}