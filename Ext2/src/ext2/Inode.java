/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ext2;

import com.google.common.primitives.Bytes;
import com.google.common.primitives.Ints;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

import static java.lang.Math.toIntExact;


/**
*
* @author Miguel A. Ardon E
*/

public class Inode{
  //del
  Directory directory = new Directory();
   int dirEntryOffset = DATA_OFFSET + (blockIndex - 1) * BLOCK_SIZE_KB;
   byte inodeBytes[] = new byte[4];
   byte recLenBytes[] = new byte[2];
   int inode;
   short recLen;
   // Read inode
   DISK.seek(dirEntryOffset);
   DISK.read(inodeBytes);
   inode = Ints.fromByteArray(inodeBytes);
   while (inode != 0) {
       DISK.read(recLenBytes);
       recLen = Shorts.fromByteArray(recLenBytes);
       byte dirEntry[] = new byte[recLen];
       // Go back to the start of this directory entry
       DISK.seek(dirEntryOffset);
       // Read the whole recLen bytes
       DISK.read(dirEntry);
       directory.add(DirectoryEntry.fromByteArray(dirEntry));
       // Read next inode if any
       DISK.read(inodeBytes);
       inode = Ints.fromByteArray(inodeBytes);
       // Next directory entry offset
       dirEntryOffset += recLen;
   }
   return directory;
}
}
