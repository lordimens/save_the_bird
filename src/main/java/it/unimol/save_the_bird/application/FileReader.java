package it.unimol.save_the_bird.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class FileReader {

    //SINGLETON
    private static FileReader istance = null;
    public static FileReader getInstance() {
        if (istance == null) {
            istance = new FileReader();
        }
        return istance;
    }

    private FileReader() {
    }

    public List<User> readFile (List<User> users, File file){
        try {
            if (!file.exists()){
                file.createNewFile();
            }else {
                FileInputStream fileInputStream=new FileInputStream(file);
                ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

                users=(List<User>) objectInputStream.readObject();
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return users;
    }
}
