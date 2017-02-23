package com.ljt.practise.basicinfo.instruction

import java.io.{BufferedReader, File, FileReader, InputStreamReader}

import scala.collection.immutable.HashMap

/**
  * 解析操作码
  *
  * @author lijuntao1 
  * @date 2017/2/20 17:22
  */
class InstructionTable {
    var mMap: Map[Int, String] = _;

    def getInstruction(byteCode: Int): String = {
        if (mMap == null) {
            buildMap();
        }
        return mMap.apply(byteCode);
    }

    def buildMap(): Unit = {
        mMap = new HashMap[Int, String]();
        val bufferedReader: BufferedReader = new BufferedReader(new InputStreamReader(Thread.currentThread.
            getContextClassLoader.getResource("ins.txt").openStream()));

        var i: Int = 0;
        var line: String = null;
        var ins: Int = 0;

        line = bufferedReader.readLine();
        while (line != null) {
            if (i % 2 == 0) {
                ins = Integer.parseInt(line.substring(2, 4), 16);
            } else if (i % 2 == 1) {
                mMap += (ins -> line);
            }
            i += 1;
            line = bufferedReader.readLine();
        }
        bufferedReader.close();

    }

}

object InstructionTable {
    var instructionTable: InstructionTable = new InstructionTable();

    def getInstruction(byteCode: Int): String = {
        return instructionTable.getInstruction(byteCode);
    }
}
