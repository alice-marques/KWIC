class KickForward {
  /* Takes one input and reads all the
   * lines putting them into a list,
   * then it calls the next method.
   */
  def readFile(Path: String, func:() => List[String]): Unit ={
    func(scala.io.Source.fromFile(scala.io.StdIn.readLine()).getLines().toList, readStopWords())
  }
  // Removes unwanted characters
  def filterChars(Text: List[String], func:() => String): List[String] ={
    func(Text.foreach(_.filterNot("""!"#$%&'()*+,-./:;<>=?@[]\_{}|""".toSet)), proxima)//Usando aspas triplas para incluir as aspas e aspas simples na string
  }
  // Removes unwanted words
  def removeStopWords(Text: List[String], func:() => List[String]): List[String] ={
    func(Text.foreach(_.filterNot(scala.io.Source.fromFile("StopWords.txt").getLines().toList.toSet)), proxima)
  }
  def wordShift(Text: List[String], func:() => List[String]): List[String] ={
    val target = scala.io.StdIn.readInt()
    
  }
}
