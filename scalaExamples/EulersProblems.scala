package com.scalaTraining

class EluerProlems {
  def fibonance(row1: Int): Double = row1 match {
    case 0 => row1
    case 1 => row1
    case _ => fibonance(row1 - 1) + fibonance(row1 - 2)
  }
}

object EulersProblems {
  def main(args: Array[String]) {
    val el = new EluerProlems()
    println(el.fibonance(7))
    // wel come

  }
}
