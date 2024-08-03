package _19state

class NightState private constructor() : State {
    override fun doClock(context: Context, hour: Int) {
        if (hour in 9..16) {
            context.changeState(DayState)
        }
    }

    override fun doUse(context: Context) {
        context.recordLog("비상 : 야간금고 사용")
    }

    override fun doAlarm(context: Context) {
        context.callSecurityCenter("비상벨 (야간)")
    }

    override fun doPhone(context: Context) {
        context.callSecurityCenter("야간통화 녹음")
    }

    override fun toString(): String {
        return "[야간]"
    }

    companion object {
        private val singleton = NightState()

        val instance: State
            get() = singleton
    }
}
