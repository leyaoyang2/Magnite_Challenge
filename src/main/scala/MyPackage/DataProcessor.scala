import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

object DataProcessor {
 // Calculate the total impressions by Site and Ad Type
  def calculateTotalImpressions(data: DataFrame): DataFrame = {
    data.groupBy("site_id", "ad_type_id")
      .agg(sum("total_impressions").alias("total_impressions_site_ad_type"))
      .orderBy(col("total_impressions_site_ad_type").desc)
  }

  // Calculate the average revenue per advertiser
  def calculateAverageRevenue(data: DataFrame): DataFrame = {
    data.groupBy("advertiser_id")
      .agg(avg("total_revenue").cast(DoubleType).alias("avg_advertiser_revenue"))
      .orderBy(col("avg_advertiser_revenue").desc)
  }

  // Calculate Revenue Share by Monetization Channel
  def calculateMonetizationChannelRevenueShare(data: DataFrame): DataFrame = {
    data.groupBy("monetization_channel_id")
      .agg(sum("revenue_share_percent").alias("monetization_channel_revenue_share"))
      .orderBy(col("monetization_channel_revenue_share").desc)
  }
}
