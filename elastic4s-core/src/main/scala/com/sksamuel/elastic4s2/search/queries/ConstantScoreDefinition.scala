package com.sksamuel.elastic4s2.search.queries

import com.sksamuel.elastic4s2.search.QueryDefinition
import org.elasticsearch.index.query.ConstantScoreQueryBuilder

case class ConstantScoreDefinition(builder: ConstantScoreQueryBuilder) extends QueryDefinition {
  def boost(b: Double): QueryDefinition = {
    builder.boost(b.toFloat)
    this
  }
}
