package it.unimol.save_the_bird.application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileWriter{
    //SINGLETON
    private static FileWriter istance = null;

    private FileWriter() {
    }

    public static FileWriter getInstance() {
        if (istance == null) {
            istance = new FileWriter();
        }
        return istance;
    }

    public void writeFile(List<User> users, String file_name){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file_name);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(users);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
