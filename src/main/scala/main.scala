import org.apache.spark.sql.{SparkSession, DataFrame}
// import pureconfig.generic.auto._
// import pureconfig.ConfigSource
// import MyPackage.{DataExtractor, DataProcessor, DataAggregator, AppConfig}
import MyPackage.{DataExtractor}
// import config.AppConfig
// import com.typesafe.config.ConfigFactory

object Main {
  def main(args: Array[String]): Unit = {
    
    // Load application configuration from application.conf
    // val config: AppConfig = ConfigSource.default.loadOrThrow[AppConfig]
    // val sparkConfig = config.getConfig("spark")
    // print(config.inputFilePath)
    // print(config.sparkMaster)
    // print(config.appName)

    // val config = ConfigFactory.load("application.conf").getConfig("appConfig")
    // val inputFilePath = config.getString("inputFilePath")
    // val sparkMaster = config.getString("sparkMaster")
    // val appName = config.getString("appName")

    val inputFilePath = "/Users/hannahyang/Desktop/Magnite/magnitechallenge/data/Dataset.csv"        
    val sparkMaster = "local[*]"   
    val appName = "AdTechAnalysis"  
    print(inputFilePath)
    print(sparkMaster)
    print(appName)

    // Initialize SparkSession
    val spark: SparkSession = SparkSession.builder()
      .master(sparkMaster)  // Set the master URL for local mode
      .appName(appName)
      .getOrCreate()

    // Data Extraction
    val df: DataFrame = DataExtractor.readData(spark, inputFilePath)

    // Data Aggregation
    // // Calculate total impressions by Site and Ad Type
    // val totalImpressionsDF: DataFrame = DataProcessor.calculateTotalImpressions(df)
    // // Calculate average revenue per advertiser
    // val avgRevenuePerAdvertiserDF: DataFrame = DataProcessor.calculateAverageRevenue(df)
    // // Calculate Revenue Share by Monetization Channel
    // val monetizationChannelRevenueShareDF: DataFrame = DataProcessor.calculateMonetizationChannelRevenueShare(df)
    // // Save results or perform other actions as needed
    // totalImpressionsDF.write.parquet(config.totalImpressionsOutputPath)
    // avgRevenuePerAdvertiserDF.write.parquet(config.averageRevenueOutputPath)
    // monetizationChannelRevenueShareDF.write.parquet(config.revenueShareOutputPath)

    // // Time series analysis (e.g., metric in impressions)
    // val dailyChangesDF: DataFrame = TimeSeriesAnalysis.performTimeSeriesAnalysis(df)
    
    // Stop SparkSession to release resources
    spark.stop()
    
  }
}


    
