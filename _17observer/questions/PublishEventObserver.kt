package _17observer.questions

import _17observer.examples.NumberGenerator
import _17observer.examples.Observer

class PublishEventObserver(
  // TODO 일종의 큐에 이벤트를 보내는 빈을 생성자로 받는다.
  private val publisher: Publisher
) : Observer {
  override fun update(generator: NumberGenerator) {
    // TODO 이벤트를 생성하고 큐에 보낸다.
    runCatching { publisher.publish(Event(generator.number)) }
      .onFailure { throw RuntimeException("Failed to publish event", it) }
      .getOrThrow()
  }
}

interface Publisher {
  fun publish(event: Event)
}

class Event(val id: Int)