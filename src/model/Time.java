package model;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    static String currentTime;
    static String lastTime;

    static {
        lastTime = "2000/10/10 10/10/10";
    }

    public static void calcNow() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        currentTime = dtf.format(now);
    }

    public static int calcAddableLife() {
//        if (lastTime.equals("2000/10/10 10/10/10")) {
        String tmp = deserializeLastTime();
        if (tmp != null)
            lastTime = tmp;
//        }
//        System.out.println(lastTime);
        calcNow();
        for (int i = 0; i < 13; i++) {
            if (currentTime.charAt(i) > lastTime.charAt(i))
                return 5;
        }
        int lastTimeMinutes = Integer.parseInt(lastTime.substring(14, 16));
        int currentTimeMinutes = Integer.parseInt(currentTime.substring(14, 16));

        int lastTimeSeconds = Integer.parseInt(lastTime.substring(17));
        int currentTimeSeconds = Integer.parseInt(currentTime.substring(17));

        if (currentTimeSeconds < lastTimeSeconds) {
            currentTimeSeconds += 60;
            currentTimeMinutes--;
        }
        int distance = (currentTimeMinutes - lastTimeMinutes) * 60 + currentTimeSeconds - lastTimeSeconds;
        return Math.min(5, distance / 30);
//        return 0;
    }

    public static void serializeTime() {
        File directory = new File("../user");
        calcNow();
//        System.out.println(currentTime);
        if (!directory.exists()) {
            directory.mkdir();
//            System.out.println("user directory created");
        }
        try (FileOutputStream fos = new FileOutputStream("../user/last_time_played");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(currentTime);
//            System.out.println("The file user/last_time_played has been serialized in user directory");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String deserializeLastTime() {
        String path = "../user/last_time_played";
        if (!(new File(path).exists())) {
            return null;
        }
        String lastTime = null;
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis)) {
            lastTime = (String) ois.readObject();
//            System.out.println("user's last time played has been deserialized");
        } catch (FileNotFoundException e) {
            System.err.println("The file : " + path + " cannot be found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("The file : " + path + " cannot be read.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("The object class you have tried to deserialize doesn't exist");
            e.printStackTrace();
        }
        return lastTime;
    }

}
