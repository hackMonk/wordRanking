import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class main {
  public static String dirPath;
  public static void main(String[] args) {
    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("choosertitle");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);

    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      //System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
      System.out.println("Successfully opened " + chooser.getSelectedFile() + " directory :D");
      dirPath = new String(chooser.getSelectedFile().toString());
    } else {
      System.out.println("No Selection ");
    }

    File aDirectory = new File(dirPath);
    String[] fileInDir = aDirectory.list();
    for(int i = 0; i < fileInDir.length; i++) {
      System.out.println("file : " + fileInDir[i]);
    }

  }
}
