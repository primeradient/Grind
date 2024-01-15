package patterns.Adapter;


class MP4Player {
    public void playMusic() {
        System.out.println("Playing MP4");
    }
}


class AudioAdapter {
    public void playMusic(String type) {
        if ( type.equals("MP4")) {
            new MP4Player().playMusic();
        } else {
            System.out.println("No adapter available for given music type.");
        }
    }

}

class AudioPlayer {


    public void playMusic(String type) {
        if ( type.equals("MP3")) {
            System.out.println("Playing MP3");
        } else {
            AudioAdapter adapter = new AudioAdapter();
            adapter.playMusic(type);
        }
    }
}

public class Main {
    public static void main(String args[]) {
        AudioPlayer player = new AudioPlayer();
        player.playMusic("MP3");
        player.playMusic("MP4");
    }
}
