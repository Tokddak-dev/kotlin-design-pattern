package singleton

/**
 * 연습 문제 5-1
 *
 * Tickethaker 클래스(리스트 5-3)는 getNextTicketNumber 메소드를 호출할 때마다 1000, 1001, 1002,
 * ..라는 수를 차례로 반환해서 티켓 번호나 일련번호를 생성하는 데 사용합니다. 이 TickeMaker 클래스
 * 는 현재 상태라면 인스턴스를 몇 개라도 만들 수 있습니다. 여기에 Singleton 패턴을 적용해 인스턴스가
 * 하나만 만들어지도록 변경해 보세요.
 *
 * @see 108 페이지
 * @author toneyparky
 */

class AsIsTicketMaker(
    private var ticket: Int = 1000
) {
    fun getNextTicketNumber(): Int {
        return ticket++
    }
}

class ToBeTicketMaker private constructor() {
    private var ticket: Int = 1000

    companion object {
        private val instance = ToBeTicketMaker()

        fun getInstance(): ToBeTicketMaker {
            return instance
        }
    }

    fun getNextTicketNumber(): Int {
        // synchronized 블록을 사용하여 thread-safe하게 만든다.
        synchronized(this) {
            return ticket++
        }
    }
}

fun main() {
    val ticketMaker1 = AsIsTicketMaker()
    val ticketMaker2 = AsIsTicketMaker()

    // 둘은 다른 인스턴스이므로 결과는 1000, 1000 이다.
    println(ticketMaker1.getNextTicketNumber())
    println(ticketMaker2.getNextTicketNumber())

    val ticketMaker3 = ToBeTicketMaker.getInstance()
    val ticketMaker4 = ToBeTicketMaker.getInstance()

    // 둘은 같은 인스턴스이므로 결과는 1000, 1001 이다.
    println(ticketMaker3.getNextTicketNumber())
    println(ticketMaker4.getNextTicketNumber())
}
