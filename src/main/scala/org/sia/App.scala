package org.sia.chapter03App

import org.apache.spark.{SparkConf, SparkContext}


object App {

  def main(args : Array[String]) {
    val conf = new SparkConf()
      .setAppName("Best test whatsoever")
      .setMaster("local[*]")

    val sc = new SparkContext(conf)

    val col = sc.parallelize(0 to 100 by 5)
    val smp = col.sample(true, 4)
    val colCount = col.count
    val smpCount = smp.count

    println("orig count = " + colCount)
    println("sampled count = " + smpCount)
  }

}
