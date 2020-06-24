package com.cpworks.libraries;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfiguration {

  @Value("${spring.data.mongodb.database}")
  private String mongoDatabase;

//  @Bean
//  public MongoDatabaseFactory mongoDatabaseFactory(MongoClient mongoClient) {
//    return new SimpleMongoClientDatabaseFactory(mongoClient, mongoDatabase);
//  }

//  @Bean
//  public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDbFactory, MongoConverter converter) {
//    return new MongoTemplate(mongoDbFactory, converter);
//  }

}