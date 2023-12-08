// package MyPackage
// import org.apache.spark.sql.{SparkSession, DataFrame}
// import org.apache.spark.sql.functions._
// // import pureconfig.generic.auto._
// // import pureconfig.ConfigSource
// import config.AppConfig

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.{col, sum, avg}
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.types.DoubleType

object DataExtractor {
  // Initialize a Spark session
  val spark: SparkSession = SparkSession.builder.appName("magnite").getOrCreate()

  // Read the CSV file into a Spark DataFrame
  def readData(spark: SparkSession, inputFilePath: String): DataFrame = {
    spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(filePath)
  }

}



