package com.spotright.srunlz4

import java.io._
import java.nio.charset.StandardCharsets.UTF_8

import net.jpountz.lz4.LZ4BlockInputStream

object Main {

  val blockSize = 23 * 1024
  val buf = new Array[Byte](blockSize)

  def main(av: Array[String]): Unit = {
    val fh = new File(av.headOption.get)
    val is = new FileInputStream(fh)
    val bis = new LZ4BlockInputStream(is)

    var done = false
    while (!done) {
      val len = bis.read(buf)

      if (len == blockSize) {
        // full block
        val str = new String(buf, UTF_8)
        println(str)
      }
      else {
        // partial block
        if (len == 0) done = true

        val str = new String(buf.take(len), UTF_8)
        println(str)
      }
    }
  }

}
