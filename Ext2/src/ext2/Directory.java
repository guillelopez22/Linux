/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ext2;

import java.util.LinkedList;

/**
*
* @author Miguel A. Ardon E
*/

public class Directory extends LinkedList<DirectoryEntry> {

  // Adds the record length of each directory entry contained in this directory
  private int totalLength;
  // Block number where the directory is saved along with its directory entries
  private int blockNumber;

  public Directory(int blockNumber) {
    super();
    this.blockNumber = blockNumber;
  }
  
  public int getTotalLength() {
    int total = 0;
    for (DirectoryEntry directoryEntry : this) {
      total += directoryEntry.getRecLen();
    }
    return total;
  }

  public int getBlockNumber() {
    return blockNumber;
  }
}
