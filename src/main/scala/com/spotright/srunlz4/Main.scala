package com.spotright.srunlz4

import java.io._
import java.nio.charset.StandardCharsets.UTF_8

import net.jpountz.lz4.LZ4BlockInputStream

object Main {

  final val BLOCK_SIZE = 23 * 1024

  val buf = new Array[Byte](BLOCK_SIZE)

  def main(av: Array[String]): Unit = {
    val fh = new File(av.headOption.get)
    val is = new FileInputStream(fh)
    val bis = new LZ4BlockInputStream(is)

    try {
      Iterator.continually(bis.read(buf))
        .takeWhile(_ != 0)
        .foreach { len =>
          val str = new String(buf, 0, len, UTF_8)
          print(str)
        }
    }
    finally {
      bis.close()
    }
  }

}
