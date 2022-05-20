import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.MalformedURLException;
import java.util.Objects;
import java.util.Scanner;

public class StartPanel extends JFrame implements ActionListener, Runnable {
    private static int temp = 0;

    @SuppressWarnings("deprecation")
    public static void main(String[] args)  {

        File fileTemp = new File("button.txt");
        Scanner input = null;
        try {
            input = new Scanner(fileTemp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int a = 0;
        while (input.hasNext()) {
            a = input.nextInt();
        }
        temp = a;
        input.close();
        new StartPanel();


//        Music mu = new Music();
//        try {
//            mu.setAudioClip(Applet
//                    .newAudioClip((new File("C:\\Users\\LiuZiRui\\Desktop\\pro\\克罗地亚.wav")).toURL()));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        //循环播放
//        mu.loop();
////        mu.stop();
////        mu.play();

        music();

        java.io.File file = new File("result.txt");

    }

//    //音乐播放
//    AudioClip clip = null;
//
//    public AudioClip getAudioClip() {
//        return this.clip;
//    }
//
//    public void setAudioClip(AudioClip clip) {
//        this.clip = clip;
//    }
//
//    public void play() {//播放
//        if (getAudioClip() != null) {
//            getAudioClip().play();
//        }
//    }
//
//    public void loop() {//循环
//        if (getAudioClip() != null) {
//            getAudioClip().loop();
//        }
//    }
//
//    public void stop() {//停止
//        if (getAudioClip() != null) {
//            getAudioClip().stop();
//        }
//    }


    JPanel panel1;

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
//    JButton button6;


    public StartPanel() {


        panel1 = new JPanel();

        button1 = new JButton();
        button1.setText("开始新游戏");
        button1.setFont(new Font("华文彩云",Font.BOLD,40));
        button1.setBorder(null);


        button2 = new JButton();
        button2.setText("简单");
        button2.setFont(new Font("华文彩云",Font.BOLD,40));
        button2.setBorder(null);

        button3 = new JButton();
        button3.setText("普通");
        button3.setFont(new Font("华文彩云",Font.BOLD,40));
        button3.setBorder(null);

        button4 = new JButton();
        button4.setText("困难");
        button4.setFont(new Font("华文彩云",Font.BOLD,40));
        button4.setBorder(null);

        button5 = new JButton();
        button5.setText("继续游戏");
        button5.setFont(new Font("华文彩云",Font.BOLD,40));
        button5.setBorder(null);

//        button6 = new JButton();
//        button6.setText("保存并退出");


        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
//        button6.setVisible(false);


        panel1.add(button1);
        panel1.add(button5);


        panel1.setVisible(true);


        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);

        ImageIcon bg1 = new ImageIcon("bg1(2).JPG");
        JLabel bg_1 = new JLabel(bg1);
        bg_1.setSize(bg1.getIconWidth(), bg1.getIconHeight());
        panel1.add(bg_1);

        this.add(panel1);

        //ListenForButton listenForButton = new ListenForButton();
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
//        button6.addActionListener(this);

        this.setSize(bg1.getIconWidth(), bg1.getIconHeight());
        this.setVisible(true);
        //设置组件位置
        this.setLocationRelativeTo(null);
        //设置窗体大小无法改变
        this.setResizable(false);
        //窗口关闭-直接关闭程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("俄罗斯方块");


    }

    String bt;


    @Override
    public void actionPerformed(ActionEvent e) {
        bt = e.getActionCommand();
        new Thread(this).start();
        java.io.File file = new File("button.txt");
        PrintWriter output = null;
        try {
            output = new PrintWriter(file);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        if (Objects.equals(bt, "简单")) {
            assert output != null;
            output.print(1000);
            output.println("");
        } else if (Objects.equals(bt, "普通")) {
            assert output != null;
            output.print(800);
            output.println("");
        } else if (Objects.equals(bt, "困难")) {
            assert output != null;
            output.print(400);
            output.println("");
        }
        assert output != null;
        output.close();
    }

    @Override
    public void run() {
        if (bt.equals("开始新游戏")) {
            button1.setVisible(false);
            button2.setVisible(true);
            button3.setVisible(true);
            button4.setVisible(true);
            button5.setVisible(false);
        }
        if (bt.equals("继续游戏")) {
            Tertris tertris = null;
            try {
                tertris = new Tertris(1);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            tertris.isrunning = true;
//            Scanner input = null;
//            try {
//                input = new Scanner(file);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            int a=1000;
//            while (input.hasNext()){
//                a =input.nextInt();
//            }
//            System.out.println(a);
            tertris.time = temp;
            try {
                System.out.println(tertris.time);
                tertris.game_begin();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            input.close();
        }

        if (bt.equals("简单")) {
            Tertris tertris = null;
            try {
                tertris = new Tertris(0);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            tertris.isrunning = true;
            tertris.time = 1000;
            try {
                tertris.game_begin();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bt.equals("普通")) {
            Tertris tertris = null;
            try {
                tertris = new Tertris(0);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            tertris.isrunning = true;
            tertris.time = 800;
            try {
                tertris.game_begin();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bt.equals("困难")) {
            Tertris tertris = null;
            try {
                tertris = new Tertris(0);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            tertris.isrunning = true;
            tertris.time = 400;
            try {
                tertris.game_begin();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void music(){
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;

        ContinuousAudioDataStream loop = null;

        try{
            BGM = new AudioStream(new FileInputStream("C:/Users/LiuZiRui/Desktop/pro/克罗地亚.wav"));
            AudioPlayer.player.start(BGM);
//            MD = BGM.getData();
//            loop = new ContinuousAudioDataStream(MD);
        }catch (IOException e){
            e.printStackTrace();
        }
        MGP.start(loop);
    }




}
