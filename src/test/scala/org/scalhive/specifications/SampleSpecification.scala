package org.scalhive.specifications

import com.aerospike.client.AerospikeClient
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Seconds, Span}
import org.scalatest.{FlatSpec, Matchers}
import org.scalhive.containers.AerospikeDockerService

/**
  * Created by kisilnazar on 02.04.17.
  */
class SampleSpecification extends FlatSpec with ScalaFutures with Matchers with AerospikeDockerService {

  lazy val aerospikeClient = new AerospikeClient("localhost", 3000)

  implicit val pc = PatienceConfig(Span(20, Seconds), Span(20, Seconds))

  "Check aerospike container" should "be ready" in {
    dockerContainers.map(_.image).foreach(println)
    dockerContainers.forall(_.isReady().futureValue) shouldBe true
  }

  "Aerospike" should "connect" in {
    aerospikeClient.isConnected === true
  }

}
