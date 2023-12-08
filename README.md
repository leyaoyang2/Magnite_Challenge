# AdTech Analysis Project

This Scala project aims to perform data extraction, cleaning, processing, aggregation, configuration management, and unit testing on adtech-related data using Apache Spark and Scala.

## Table of Contents

- [AdTech Analysis Project](#adtech-analysis-project)
  - [Table of Contents](#table-of-contents)
  - [Project Overview](#project-overview)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation and execution](#installation-and-execution)
  - [Results](#results)
  - [Insights from Analysis](#insights-from-analysis)
  - [Reflection](#reflection)


## Project Overview

This project includes data extraction, cleaning, processing, aggregation, configuration management, and unit testing using Scala, Apache Spark, and GitHub. More specifically, 

1. **Data Extraction:** Reading and parsing adtech-related data from a CSV file.
2. **Data Cleaning and Processing:** Cleaning and transforming the dataset for analysis.
3. **Data Aggregation:** Calculating total impressions by site and ad type, average revenue per advertiser, and revenue share by monetization channel.
4. **Configuration Management:** Implementing a configuration file for parameters like file paths and data schema.
5. **Unit Testing:** Writing unit tests for each component using a Scala testing framework.
6. **GitHub Repository:** Organizing project files, scripts, configuration, tests, output files, and a detailed README on GitHub.

## Getting Started

### Prerequisites

Following are the prerequisites need to be installed:

- Scala
- Apache Spark
- SBT (Scala Build Tool)

### Installation and execution 

1. Clone this repository to your local machine
2. Navigate to the project directory
3. Update the `application.conf` file in the `src/main/resources` directory with the necessary configuration parameters, such as file paths.
4. Build and run the project using SBT: sbt clean compile, sbt run 
5. Run the tests using SBT: sbt test

## Results

The results of the data aggregation tasks are stored in separate tables and can be found in the `data/output` directory. These tables include:

- c1: Total Impressions by Site and Ad Type
- c2: Average Revenue per Advertiser
- c3: Revenue Share by Monetization Channel

## Insights from Analysis
1. Total impressions:

   - Looking at Ad Type, Ad Type of 10 tends to have higher impressions and Ad Type of 17 tends to have lower impressions. 
   - Looking at site id, site 349 has the highest total impressions of 3687206 while site 348 has the lowest total impressions. 
   - When aggregating on the combination of site id and Ad Type, site id 349 with the Ad type 10 has the highest impressions of 3586356, yet site id 347 with the Ad type 17 has the lowest impressions of 18640. 

2. Average Revenue per Advertiser
   
   Advertiser 16 has the highest average revenue of 0.23567251264755518 and advertiser 79 has the second highest average revenue of 0.12601168226530113. There are 12 advertisers have average revenue of 0. 

3. Revenue Share by Monetization Channel
   
   Monetization channel 19 has the highest revenue share of 396072 and channel 4 has the second highest revenue share. Monetization channel 21 has the lowest revenue share of 4327. 

4. Time series analysis:
   
   Due to time limit, I didn't finish time series analysis in Scala with Spark (I implemented the code but did not have a chance to run/debug it). Yet I'm super intrigued about this insights. Thus, I performed some quick analysis in Python. The result images are located in  `data/output/TimeSeriesImages` directory. 
   
   The DailyImpressionsChangeOverTime.png image describes the impressions change compared between 2 consecutive days (e.g., compared with the previous day). We can see that the impressions change tends to bounce back and forth, sometimes increase and sometimes decrease during the week. The graph starts on 2019-06-01, Sunday. Friday tends to have the highest impression increase compared to the previous day. Wednesday tends to have highest impression decrease compared to the previous day. 


## Reflection

Embarking on my first Scala project from scratch was an exciting yet challenging journey. Setting up the development environment, adapting to a new programming language, and exploring unfamiliar libraries presented initial hurdles. However, with dedication, research, and hands-on experimentation, I successfully overcame these challenges.

Throughout the project, I worked diligently to complete all its components. This self-learning experience was invaluable, and I am confident that continued practice and exploration of Scala and Spark will enhance my proficiency in these technologies. It's only the beginning, and I look forward to further growth and mastery in the future. Please also let me know if there's any areas in this project where I could improve my professionalism as a Scala programmer!



