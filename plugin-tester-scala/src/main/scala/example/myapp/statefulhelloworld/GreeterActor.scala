/*
 * Copyright (C) 2018-2021 Lightbend Inc. <https://www.lightbend.com>
 */

package example.myapp.statefulhelloworld

import org.apache.pekko.actor.Actor
import org.apache.pekko.actor.Props

// #actor
object GreeterActor {
  case class ChangeGreeting(newGreeting: String)

  case object GetGreeting
  case class Greeting(greeting: String)

  def props(initialGreeting: String) = Props(new GreeterActor(initialGreeting))
}

class GreeterActor(initialGreeting: String) extends Actor {
  import GreeterActor._

  var greeting = Greeting(initialGreeting)

  def receive = {
    case GetGreeting => sender() ! greeting
    case ChangeGreeting(newGreeting) =>
      greeting = Greeting(newGreeting)
  }
}
// #actor
