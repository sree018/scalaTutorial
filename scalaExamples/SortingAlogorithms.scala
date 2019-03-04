package com.scalaDataStructures

import sun.security.util.Length

object SortingAlogorithms {
  def main(args: Array[String]) {
    //QuickSort(Array(1, 45, 38, 23, 54, 9, 90, 76, 83, 100))
    //MergeSort(List(1, 45, 38, 23, 54, 9, 90, 76, 83, 100)))
    BubbleSort(Array(1, 45, 38, 23, 54, 9, 90, 76, 83, 100)).toList.foreach(println)
  }
  def QuickSort(arrayOfInt: Array[Int]): Array[Int] = {
    if (arrayOfInt.length <= 1) arrayOfInt else {
      val centralElements = arrayOfInt(arrayOfInt.length / 2)
      Array.concat(
        QuickSort(arrayOfInt filter (centralElements >)),
        arrayOfInt filter (centralElements ==),
        QuickSort(arrayOfInt filter (centralElements <)))

    }

  }
  def MergeSort(list: List[Int]): List[Int] = {
    val n = list.length / 2
    val (left, right) = list splitAt (n)
    if (n == 0) list else {
      def merge(left: List[Int], right: List[Int]): List[Int] =
        (left, right) match {
          case (Nil, right) => right
          case (left, Nil)  => left
          case (leftSorted :: left1, rightSorted :: right1) =>
            if (leftSorted < rightSorted) leftSorted :: merge(left1, right)
            else rightSorted :: merge(left, right1)
        }
      merge(MergeSort(left), MergeSort(right))
    }

  }
  def BubbleSort(arr: Array[Int]): Array[Int] = {
    val hasSwaps =
      for {
        i <- (1 until arr.length)
      } yield {
        if (arr(i - 1) > arr(i)) {
          val tmp = arr(i)
          arr(i) = arr(i - 1)
          arr(i - 1) = tmp
          true
        } else false
      }

    if (hasSwaps.reduce(_ || _)) BubbleSort(arr)
    else arr
  }

}