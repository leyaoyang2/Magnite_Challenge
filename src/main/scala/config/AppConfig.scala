package config 

case class AppConfig(
  inputFilePath: String,
  sparkMaster: String,
  appName: String,
  outputFilePath: String,
)

