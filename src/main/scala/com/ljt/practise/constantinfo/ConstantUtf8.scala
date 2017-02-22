package com.ljt.practise.constantinfo

import java.io.{InputStream, UTFDataFormatException}

import com.ljt.practise.ConstantInfo
import com.ljt.practise.basictype.U2

import scala.util.control.Breaks

/**
  *
  * @author lijuntao1 
  * @date 2017/2/15 15:36
  */
class ConstantUtf8 extends ConstantInfo {
  var value: String = null;

  override def read(in: InputStream): Unit = {
    val len: Int = U2.read(in);
    val bytes: Array[Byte] = new Array[Byte](len);
    in.read(bytes);

    value = readUtf8(bytes);

  }

  def readUtf8(bytes: Array[Byte]): String = {
    var c: Int = 0;
    var char2: Int = 0;
    var char3: Int = 0;

    var count: Int = 0
    var charr_count: Int = 0
    val charrr: Array[Char] = new Array[Char](bytes.length)

    val loop = new Breaks;

    loop.breakable {
      while (count < bytes.length) {
        c = bytes(count) & 0xFF;

        if (c > 127) {
          loop.break();
        }

        count += 1
        charrr(charr_count) = c.toChar;
        charr_count += 1;
      }
    }


    while (count < bytes.length) {
      c = bytes(count) & 0xFF;

      c match {
        case _ if (c < 8) => {
          /* 0xxxxxxx*/
          count += 1;
          charrr(charr_count) = c.toChar;
          charr_count += 1;
        }
        case _ if (c == 12 || c == 13) => {
          /* 110x xxxx   10xx xxxx*/
          count += 2;
          if (count > bytes.length) {
            throw new UTFDataFormatException("malformed input: partial character at end");
          }
          char2 = bytes(count - 1);
          if ((char2 & 0xC0) != 0x80) {
            throw new UTFDataFormatException("malformed input around byte " + count)
          }
          charrr(charr_count) = (((c & 0x1F) << 6) | (char2 & 0x3F)).toChar;
          charr_count += 1;

        }
        case 14 => {
          /* 1110 xxxx  10xx xxxx  10xx xxxx */
          count += 3;
          if (count > bytes.length) {
            throw new UTFDataFormatException("malformed input: partial character at end")
          }

          char2 = bytes(count - 2);
          char3 = bytes(count - 1);
          if (((char2 & 0xC0) != 0x80) || ((char3 & 0xC0) != 0x80)) {
            throw new UTFDataFormatException("malformed input around byte " + (count - 1));
          }
          charrr(charr_count) = (((c & 0x1F) << 12) | ((char2 & 0x3F) << 6) | (char3 & 0x3F)).toChar;
          charr_count += 1;
        }
        case _ => {
          /* 10xx xxxx,  1111 xxxx */
          throw new UTFDataFormatException("malformed input around byte " + count)
        }
      }
    }
    return new String(charrr, 0, charr_count);
  }
}
