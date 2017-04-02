**Example of integration testing with docker and Aerospike**

## 1. Install [docker](https://docs.docker.com/engine/installation/#get-started)

#### For Ubuntu

##### Uninstall old versions

```
$ sudo apt-get remove docker docker-engine
```

##### Install using the repository

1. Install packages to allow apt to use a repository over HTTPS:

```
$ sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    software-properties-common 
```
2. Add Docker’s official GPG key:

```
$ curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
```
Verify that the key fingerprint is 9DC8 5822 9FC7 DD38 854A E2D8 8D81 803C 0EBF CD88.
```
$ sudo apt-key fingerprint 0EBFCD88
pub   4096R/0EBFCD88 2017-02-22
      Key fingerprint = 9DC8 5822 9FC7 DD38 854A  E2D8 8D81 803C 0EBF CD88
uid                  Docker Release (CE deb) <docker@docker.com>
sub   4096R/F273FCD8 2017-02-22
```
3. Use the following command to set up the stable repository. You always need the stable repository, even if you want to install edge builds as well.
```
Note: The lsb_release -cs sub-command below returns the name of your Ubuntu distribution, such as xenial.

Sometimes, in a distribution like Linux Mint, you might have to change $(lsb_release -cs) to your parent Ubuntu distribution. For example: If you are using Linux Mint Rafaela, you could use trusty.
```
To also add the edge repository, add edge after stable on the last line of the command.
```
$ sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"
```

## 2. You should be able to provide configuration purely through environment variables

```
export DOCKER_HOST=tcp://127.0.0.1:2375
```
Or
```
export DOCKER_HOST=unix:///var/run/docker.sock
```

## 3. Sbt dependencies for Suite wrapping and docker client

```
"com.whisk" %% "docker-testkit-scalatest"    % "0.9.0" % "test"
"com.whisk" %% "docker-testkit-impl-spotify" % "0.9.0" % "test"
```
