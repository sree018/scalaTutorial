package com.InterviewQuestions

object WarmUpChallenges{
  def main(args: Array[String]) {
     val n = 9
    // val colur = Array(10, 20, 20, 10, 10, 30, 50, 10, 20)
    //countingValleys(12, "DDUUDDUDUUUD")
    //jumpingOnClouds(Array(0, 0, 0, 0, 1, 0))

    repeatedString("abcac", 60)
  }
  def countHoles(num: Int) :Int={
    val number = num.toString().map(_.asDigit)
    var holes = 0;
    val data1 = for (i <- number) {
     if (i==8){
       holes += 2
     }else if (i==1|| i==2||  i==3||i==5||i==7){
       holes += 0
     }else if (i==0||i==4||i==6||i==9){
       holes += 1
     }
    }
    return holes

  }
  def repeatedString(s: String, n: Long) {
       val rem = n % s.length
     println( s.count(_ == 'a') * (n / s.length)+ s.take(rem.toInt).count(_ == 'a'))
        
    }
  //def repeatedString(s: String, n: Long) {
    
   // val data = s.*(n.toInt).toList
    //val sizedString = data.slice(0, n.toInt).groupBy(x=>x).mapValues(x=>x.size)
   //val index = sizedString('a')
    //println(index.toLong)
 // }

  def jumpingOnClouds(arr: Array[Int]): Int = {
    val cloudsize = arr.length
    var jump, step = 0
    while (step < cloudsize - 1) {
      if ((step + 2 < cloudsize) && arr(step + 2) != 1) {
        step += 2
      } else {
        step += 1
      }
      jump += 1
    }
    return jump
  }
  def countingValleys(n: Int, s: String) {
    var sealevel, valley = 0
    for (step <- s) {
      if (step == 'D') sealevel -= 1 else sealevel += 1
      if (sealevel == 0 && step == 'U') valley += 1

    }
    println(valley)
  }
  def matches(X: Int, arr: Array[Int]) {
    val i = arr.groupBy(x => x).mapValues(_.size)
    val y = i.values.toList
    var num = 0
    for (w <- y) {
      if (w % 2 == 0) num += w / 2 else num += w / 2
    }
    println(num)

  }
}
