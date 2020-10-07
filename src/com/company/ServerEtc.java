package com.company;

import java.io.*;
import java.net.Socket;

public class ServerEtc extends Thread{
    Socket s;
    BufferedWriter bw;
    BufferedReader buffer;
    public ServerEtc(Socket s){
        this.s = s;
        try {
            buffer = new BufferedReader(new InputStreamReader(s.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        start();
    }

    public void run() {
        try {
            while (true){
                String tmp = buffer.readLine();
                if(tmp!=null) {
                    for (ServerEtc vr : Server.serv) {
                        vr.sendMsg(tmp);
                    }
                    System.out.println(tmp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                bw.close();
                buffer.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void sendMsg(String msg){
        try {
            bw.write(msg);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
