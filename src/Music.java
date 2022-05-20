import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class Music {
    AudioClip clip = null;

    public AudioClip getAudioClip() {
        return this.clip;
    }

    public void setAudioClip(AudioClip clip) {
        this.clip = clip;
    }

    public void play() {//播放  
        if (getAudioClip() != null) {
            getAudioClip().play();
        }
    }

    public void loop() {//循环  
        if (getAudioClip() != null) {
            getAudioClip().loop();
        }
    }

    public void stop() {//停止  
        if (getAudioClip() != null) {
            getAudioClip().stop();
        }
    }
//    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
//        Music  mac = new Music();
//        try {
//            mac.setAudioClip(Applet
//                    .newAudioClip((new File("C:\\Users\\LiuZiRui\\Desktop\\pro\\克罗地亚.wav")).toURL()));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        mac.loop();//循环播放
//        //mac.stop();
//        mac.play();
//        System.out.println("aa");
        music();
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
