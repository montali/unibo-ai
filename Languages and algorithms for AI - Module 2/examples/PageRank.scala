import org.apache.spark.SparkContext, org.apache.spark.SparkConf,
org.apache.commons.io.FileUtils, org.apache.spark.HashPartitioner, java.io._

/** PageRank is the algorithm used by Google to create a reputation scor for each page of the WWW
  * It takes the list of pages available
  * For each pages it needs the list of links to other pages
  * The input can represented as a graph with nodes and arcs
  * It returns for each node (web page) the reputation based on the amount of times it is referenced elsewhere
  * Having to evaluate the whole WWW, it HAS to be distribute or it would take too much
  */
object PageRank {
  def main(args: Array[String]) {
    // Set Apache Spark server configuration
    // This script is the master, connect to the slaves
    val conf = new SparkConf().setAppName("pageRank").setMaster("local[*]")
    val sc = new SparkContext(conf)
    // inputFile would contain the edges and their links
    //val inputFile = "/Users/zavattar/IdeaProjects/PageRank/soc_Epinions.txt"
    //val outputFile = "/Users/zavattar/IdeaProjects/PageRank/pageRank"
    val inputFile = "soc_Epinions.txt"
    val outputFile = "pageRank"
    // Generate a collection with Spark from a file
    // input will be a RDD[String] (Resilient Distributed Dataset containing Strings)
    val input = sc.textFile(inputFile)
    // RDD TRANSFORMATIONS are methods that generate another RDD distributing the workload
    // map() is a RDD transformation
    // edges is also a RDD
    val edges =
      input.map(s => (s.split("\t"))).map(a => (a(0).toInt, a(1).toInt))
    // groupByKey() is another RDD transformation
    val links = edges.groupByKey().partitionBy(new HashPartitioner(4)).persist()
    var ranks = links.mapValues(v => 1.0)
    // Beginning of the actual pageRank algorithm
    for (i <- 0 until 10) {
      val contributions =
        links.join(ranks).flatMap { case (u, (uLinks, rank)) =>
          uLinks.map(t => (t, rank / uLinks.size))
        }
      ranks = contributions
        .reduceByKey((x, y) => x + y)
        .mapValues(v => 0.15 + 0.85 * v)
    }
    FileUtils.deleteDirectory(new File(outputFile))
    // RDD ACTIONS are methods that generate something that is not an RDD
    // saveAsTextFile() is an RDD action that generates a file
    ranks.saveAsTextFile(outputFile)
    sc.stop()
  }
}
