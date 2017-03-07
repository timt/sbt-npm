package io.shaka.sbt

import sbt.Keys._
import sbt._
import sbt.complete.DefaultParsers._

object Npm extends AutoPlugin{

  override def trigger = allRequirements

  object autoImport {
    val npmExec = settingKey[String](
      "sbt-npm location of npm executable - defaults to npm and assume it is on the path")
    val npmWorkingDir = settingKey[String](
      "sbt-npm working directory for running npm commands - '.'")
    val npm = inputKey[Unit]("Run an npm command")
  }

  import autoImport._

  override lazy val projectSettings = Seq(
    npmExec := "npm",
    npmWorkingDir := ".",
    npm := {
      // get the result of parsing
      val args: Seq[String] = spaceDelimited("<arg>").parsed
      val npmCommand = s"${npmExec.value} ${args.mkString(" ")}"
      println(s"Running '$npmCommand' in ${npmWorkingDir.value}")
      val rc = Process(npmCommand, file(npmWorkingDir.value)).!

//      if (rc == 0) rc else sys.error(s"Grunt generated non-zero return code: $rc")

      s"cd ${npmWorkingDir.value} && $npmCommand" !
    }

//    distZip := {
//      val distFilesSrcDir = Keys.sourceDirectory.value / distZipScripts.value
//      val targetDir = Keys.target.value
//      val jar = distZipArtifactFile.value
//      val distTarget = targetDir / "dist"
//      val projectName = Keys.name.value
//
//      IO.copyDirectory(distFilesSrcDir, distTarget)
//      IO.copyFile(jar, distTarget / s"${Keys.name.value}.jar")
//      IO.zip(allSubpaths(distTarget), targetDir / s"$projectName.zip")
//    }
  )

//  private def exec(
//                    nodePath: String,
//                    cmd: String,
//                    args: Seq[String] = Seq(),
//                    cwd: File = file("."),
//                    s: Option[TaskStreams] = None): Int = {
//
//    val fullCmd = (Seq[String](nodePath, cmd) ++ args) filter {
//      _.length > 0
//    } mkString " "
//
//    s map { _stream =>
//      _stream.log.info(s"Executing grunt-sbt command: $fullCmd")
//      _stream.log.debug(s"Grunt cwd: $cwd")
//    }
//
//    val rc = Process(fullCmd, cwd).!
//
//    if (rc == 0) rc else sys.error(s"Grunt generated non-zero return code: $rc")
//  }

}
