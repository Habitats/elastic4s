package com.sksamuel.elastic4s.testkit

import com.sksamuel.elastic4s.ElasticsearchClientUri
import com.sksamuel.elastic4s.http.{ElasticClient, ElasticDsl}

import scala.util.Try

trait DockerTests extends com.sksamuel.elastic4s.http.ElasticDsl with ClientProvider {

  val client = ElasticClient(ElasticsearchClientUri("http://localhost:9200"))

  protected def cleanIndex(name: String): Unit = {
    Try {
      client.execute {
        ElasticDsl.deleteIndex(name)
      }.await
    }
    Try {
      client.execute {
        ElasticDsl.createIndex(name)
      }.await
    }
  }
}