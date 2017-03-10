sbt-npm  [![Build Status](https://travis-ci.org/timt/sbt-npm.png?branch=master)](https://travis-ci.org/timt/sbt-npm) [ ![Download](https://api.bintray.com/packages/timt/repo/sbt-npm/images/download.png) ](https://bintray.com/timt/repo/sbt-npm/_latestVersion)
===========================================================================================================================================================================================================================================================================================
A really simple sbt plugin that for running npm (or yarn) tasks as part of sbt build process

Requirements
------------

* [sbt](http://www.scala-sbt.org/0.13/docs/index.html)  0.13.6+

Installation
------------

Add the following lines to your projects.sbt

    //autoplugin
    addSbtPlugin("io.shaka" % "sbt-npm" % "7")

Usage

    sbt npm [some command]

    e.g. sbt "npm --version"
    or   sbt-prompt> npm --version
    
This will run the command 'npm --version' in the project default working directory '.'

Setting to specify location of the npm executable
    
    npmExec := "/usr/local/bin/npm"

Setting working directory for npm
    
    npmWorkingDir := "src/main/elm"

Setting npm commands to run as part of the compile phase
    
    npmCompileCommands := "run build"

Setting npm commands to run as part of the compile phase
    
    npmTestCommands := "run test"

Setting npm commands to run as part of the clean phase
    
    npmTestCommands := "run clean"
    
To use yarn instead of npm set the npmExec setting to the location of yarn

    e.g. nmpExec := "/usr/local/bin/yarn"

Code license
------------
Apache License 2.0