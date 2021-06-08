import java.io.DataInputStream;
import java.io.FileInputStream;

public class AssignmentFour {

  public static void main(String[] args) {
    try (DataInputStream input = new DataInputStream(new FileInputStream(args[0]))) {
      if (input.read() != 0xff || input.read() != 0xd8)
        throw new Exception("Invalid SOI marker");
      if (input.read() != 0xff || input.read() != 0xe0)
        throw new Exception("Invalid APP0 marker");
      int app0SegmentLength = Short.toUnsignedInt(input.readShort());
      input.skipBytes(5);
      double majorVersion = input.read();
      double minorVersion = input.read();
      minorVersion /= 100;
      double version = majorVersion + minorVersion;
      System.out.println("version:" + version);
      byte units=input.readByte();
      String unitType="";
      if(units==0){
        unitType="px";
      }else if(units==1){
          unitType="ppi";
      } else if(units==2){
          unitType="ppcm";
      }
      
      int xDensity = Short.toUnsignedInt(input.readShort());
      int yDensity = Short.toUnsignedInt(input.readShort());
      System.out.println("density:" + xDensity + "x" + yDensity + unitType);
      
      app0SegmentLength -= 14;
      input.skipBytes(app0SegmentLength);
      short label=input.readShort();
      
      while (label<(short)0xffc0 || label>(short)0xffcf){
        input.skipBytes(input.readShort() - 2);
        label=input.readShort();
        //skip to next marker
      }
      
      //once we get to here, 0xffc0<=label<=0xffcf
      //skip length + precision
      input.skipBytes(3);
      int height = Short.toUnsignedInt(input.readShort());
      int width = Short.toUnsignedInt(input.readShort());
      
      //System.out.println("version:" + version);
      //System.out.println("density:" + xDensity + "x" + yDensity + unitType);
      System.out.println("resolution:" + height + "x" + width);
    } catch (Exception e) {
      System.err.println("Error: " + e);
      System.exit(1);
    }
  }
}