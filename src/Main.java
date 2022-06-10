import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String baseDirPath = "C:\\Users\\Public\\homework\\Java core\\Games";

        String[] directoriesInGames = {"src", "res", "savegames", "temp" };
        String[] directoriesInSrc = {"main", "test" };
        String[] filesInMain = {"Main.java", "Utils.java" };
        String[] directoriesInRes = {"drawables", "vectors", "icons" };
        String[] filesInTemp = {"temp.txt" };

        StringBuilder sb = new StringBuilder();

        for (String directoriesInGame : directoriesInGames) {
            String fullPath = baseDirPath + directoriesInGame;
            File dir = new File(fullPath);
            String message;
            if (dir.mkdir()) {
                message = "Каталог \"" + fullPath + "\" создан";
            } else {
                message = "Ошибка создания каталога \"" + fullPath + "\"";
            }
            System.out.println(message);
            sb.append(message).append("\n");
        }

        File src = new File(baseDirPath + directoriesInGames[0]);
        if (src.isDirectory()) {
            for (String s : directoriesInSrc) {
                String fullPath = baseDirPath + directoriesInGames[0] + "\\" + s;
                File dir = new File(fullPath);
                String message;
                if (dir.mkdir()) {
                    message = "Каталог \"" + fullPath + "\" создан";
                } else {
                    message = "Ошибка создания каталога \"" + fullPath + "\"";
                }
                System.out.println(message);
                sb.append(message).append("\n");
            }
        }

        File res = new File(baseDirPath + directoriesInGames[1]);
        if (res.isDirectory()) {
            for (String directoriesInRe : directoriesInRes) {
                String fullPath = baseDirPath + directoriesInGames[1] + "\\" + directoriesInRe;
                File dir = new File(fullPath);
                String message;
                if (dir.mkdir()) {
                    message = "Каталог \"" + fullPath + "\" создан";
                } else {
                    message = "Ошибка создания каталога \"" + fullPath + "\"";
                }
                System.out.println(message);
                sb.append(message).append("\n");
            }
        }

        String fullDirectoryMainPath = baseDirPath + directoriesInGames[0] + "\\" + directoriesInSrc[0] + "\\";
        for (String s : filesInMain) {
            String message = "";
            String fullMainFileName = fullDirectoryMainPath + s;
            File myFile = new File(fullMainFileName);
            try {
                if (myFile.createNewFile())
                    message = "Файл \"" + fullMainFileName + "\" создан";
            } catch (IOException ex) {
                message = ex.getMessage();
            } finally {
                System.out.println(message);
                sb.append(message).append("\n");
            }
        }

        String fullDirectoryTempPath = baseDirPath + directoriesInGames[3] + "\\";
        for (String s : filesInTemp) {
            String message = "";
            String fullFileTempName = fullDirectoryTempPath + s;
            File myFile = new File(fullFileTempName);
            try {
                if (myFile.createNewFile())
                    message = "Файл \"" + fullFileTempName + "\" создан";
            } catch (IOException ex) {
                message = ex.getMessage();
            } finally {
                System.out.println(message);
                sb.append(message).append("\n");
            }
        }

        String tempFileForLog = baseDirPath + directoriesInGames[3] + "\\" + filesInTemp[0];

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFileForLog))) {
            String text = sb.toString();
            bw.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage(
            ));
        }
    }
}