import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.DoubleType
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DataProcessorSpec extends AnyFlatSpec with Matchers {

  // Create a SparkSession for testing
  val spark: SparkSession = SparkSession.builder()
    .appName("DataProcessorSpec")
    .master("local[2]") // Use local mode for testing
    .getOrCreate()

  // Sample data for testing
  val testData: DataFrame = spark.createDataFrame(Seq(
    (1, 1, 100, 10.0),
    (1, 1, 101, 12.0),
    (2, 2, 100, 8.0),
    (2, 2, 101, 15.0)
  )).toDF("site_id", "ad_type_id", "advertiser_id", "total_revenue")

  "DataProcessor" should "calculate total impressions by Site and Ad Type" in {
    val result: DataFrame = DataProcessor.calculateTotalImpressions(testData)
    val expectedColumns = List("site_id", "ad_type_id", "total_impressions_site_ad_type")

    // Check if the result DataFrame has the expected columns
    result.columns should contain theSameElementsAs expectedColumns

    // Check if the calculation is correct for a specific case (you can add more specific tests)
    val specificCase = result.filter((col("site_id") === 1) && (col("ad_type_id") === 1))
    val specificTotalImpressions = specificCase.collect()(0).getAs[Long]("total_impressions_site_ad_type")
    specificTotalImpressions shouldBe 2
  }

  it should "calculate average revenue per advertiser" in {
    val result: DataFrame = DataProcessor.calculateAverageRevenue(testData)
    val expectedColumns = List("advertiser_id", "avg_advertiser_revenue")

    // Check if the result DataFrame has the expected columns
    result.columns should contain theSameElementsAs expectedColumns

    // Check if the calculation is correct for a specific case (you can add more specific tests)
    val specificCase = result.filter(col("advertiser_id") === 1)
    val specificAvgRevenue = specificCase.collect()(0).getAs[Double]("avg_advertiser_revenue")
    specificAvgRevenue shouldBe 11.0
  }

  it should "calculate Revenue Share by Monetization Channel" in {
    val result: DataFrame = DataProcessor.calculateMonetizationChannelRevenueShare(testData)
    val expectedColumns = List("monetization_channel_id", "monetization_channel_revenue_share")

    // Check if the result DataFrame has the expected columns
    result.columns should contain theSameElementsAs expectedColumns

    // Check if the calculation is correct for a specific case (you can add more specific tests)
    val specificCase = result.filter(col("monetization_channel_id") === 100)
    val specificRevenueShare = specificCase.collect()(0).getAs[Double]("monetization_channel_revenue_share")
    specificRevenueShare shouldBe 18.0
  }

  // Stop the SparkSession after testing
  spark.stop()
}
