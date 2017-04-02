package org.scalhive.containers

import com.spotify.docker.client.{DefaultDockerClient, DockerClient}
import com.whisk.docker.impl.spotify.SpotifyDockerFactory
import com.whisk.docker.{DockerContainer, DockerFactory, DockerKit, DockerReadyChecker}
import org.scalatest.{BeforeAndAfterAll, Suite}

/**
  * Created by kisilnazar on 02.04.17.
  */
trait AerospikeDockerService extends Suite with DockerKit with BeforeAndAfterAll {

  private val client: DockerClient = DefaultDockerClient.fromEnv().build()

  override implicit val dockerFactory: DockerFactory = new SpotifyDockerFactory(client)

  val aerospikeContainer = DockerContainer("aerospike:3.12.0")
    .withPorts(3000 -> Some(3000), 3001 -> Some(3001), 3002 -> Some(3002), 3003 -> Some(3003))
    .withReadyChecker(DockerReadyChecker.LogLineContains("cake!"))

  override def dockerContainers: List[DockerContainer] =
    aerospikeContainer :: super.dockerContainers

  override def beforeAll(): Unit = {
    startAllOrFail()
  }

  override def afterAll() = {
    stopAllQuietly()
  }

}
