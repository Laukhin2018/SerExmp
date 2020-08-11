package gameEx;

import java.io.*;

public class GameSaverTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException {
        GameCharacter one = new GameCharacter(50, "Эльф", new String[] {"лук", "меч", "кастет"});
        GameCharacter two = new GameCharacter(200, "Троль", new String[] {"голые руки", "большой топор"});
        GameCharacter three = new GameCharacter(120, "Волшебник", new String[] {"заклинания", "невидимость"});


        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        }
        catch(IOException e){
            throw new IOException("Ошибка, что то пошло не так во время серилизации");
        }

        one = null;
        two = null;
        three = null;

        try{
            ObjectInputStream is = new ObjectInputStream((new FileInputStream("Game5.ser")));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            System.out.println("Type one: " + oneRestore.getType());
            System.out.println("Type two: " + twoRestore.getType());
            System.out.println("Type three: " + threeRestore.getType());
        }
        catch (FileNotFoundException e){
            throw new FileNotFoundException("не найден файл");
        }
        catch (ClassNotFoundException e){
            throw new ClassNotFoundException("не найден десериализируемый класс");
        }

    }


}
