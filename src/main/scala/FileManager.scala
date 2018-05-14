import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer

class KickForward {

  /* Takes one input and reads all the
   * lines putting them into a list,
   * then it calls the next method.
   */
  def readFile(Path: String, func:() => ListBuffer[ArrayBuffer[String]]): List[String] ={
    func(scala.io.Source.fromFile(scala.io.StdIn.readLine()).getLines().toList, removeStopWords(, ))
  }

  def splitStrings(Text: List[String], func:() => ListBuffer[ArrayBuffer[String]]):ListBuffer[ArrayBuffer[String]]={
    val separateString = new ListBuffer[ArrayBuffer[String]]()
    for(phrases <- Text)separateString += phrases.split(" ").to[ArrayBuffer]
    func(separateString, func)
  }
  // Removes unwanted words
  def removeStopWords(separatedString: ListBuffer[ArrayBuffer[String]], func:() => String): ListBuffer[ArrayBuffer[String]] ={//Como fazer puramente funcional?
    val filtered = new ListBuffer[ArrayBuffer[String]]()
    val auxList = separatedString.clone()
    val stopWords = scala.io.Source.fromFile("stopWords.txt").getLines().toList
    for(arrays <- auxList; stop <- stopWords) arrays.contains(stop) match{
      case true => {
        arrays -= stop
        removeStopWords(auxList, prox)
      }
      case false => filtered += arrays
    }
  }



  def printWords(cleanedString: ListBuffer[ArrayBuffer[String]], func:() => Unit) ={//Como fazer sem usar o for como um while
    var aux:String= ""
    val auxString = cleanedString.clone
    for(words <- auxString){
      for(n <- words.indices){
        aux = words(0)
        for(i <- 0 to words.length - 2){
          words.update(i, words(i+1))
        }
        words.update(words.size-1, aux)
        print(" | "+words(0)+" | ")
        for(j <- 1 until words.length){ print(words(j)+" ")}
        print("\n")
      }
    }
  }

}
