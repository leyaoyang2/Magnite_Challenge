import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.{col, to_date, sum, date_format}
import org.apache.spark.sql.types.DateType
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.lag
import org.apache.spark.sql.functions.when

object TimeSeriesAnalysis {
  def performTimeSeriesAnalysis(data: DataFrame): DataFrame = {
    // Convert the date column to a proper date type
    val dataWithDate: DataFrame = data.withColumn("date", to_date(col("date"), "yyyy-MM-dd"))

    // Define a window specification for time-based aggregation (e.g., daily)
    val windowSpec = Window.orderBy(col("date"))

    // Aggregate the chosen metric (impressions) over daily intervals
    val dailyImpressionsDF: DataFrame = dataWithDate.groupBy(col("date"))
      .agg(sum(col("impressions")).alias("daily_impressions"))
      .orderBy(col("date"))

    // Perform time series analysis (e.g., calculate daily changes)
    val laggedImpressionsDF: DataFrame = dailyImpressionsDF.withColumn("previous_day_impressions",
      lag(col("daily_impressions")).over(windowSpec))

    // Calculate daily changes in impressions
    val dailyChangesDF: DataFrame = laggedImpressionsDF.withColumn("impressions_change",
      when(col("previous_day_impressions").isNotNull,
        col("daily_impressions") - col("previous_day_impressions")).otherwise(0))

    dailyChangesDF
  }
}
