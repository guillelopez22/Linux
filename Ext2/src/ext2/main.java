/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ext2;

import java.io.File;
import java.io.IOException;

/**
*
* @author Miguel A. Ardon E
*/

public class Main {
  /**
  * @param args the command line arguments
  */
  public static void main(String[] args) {
    try {
      Disk disk;
      FileSystem fileSystem;
      File binaryFile = new File("disk.bin");
      if (binaryFile.exists() && !binaryFile.isDirectory()) {
        disk = new Disk(binaryFile);
        fileSystem = new FileSystem(disk);
      } else {
        binaryFile.createNewFile();
        disk = new Disk(binaryFile);
        fileSystem = new FileSystem(disk);
        fileSystem.format();
      }
      Shell shell = new Shell(fileSystem);
      shell.start();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
