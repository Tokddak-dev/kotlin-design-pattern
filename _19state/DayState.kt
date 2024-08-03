package _19state

object DayState : State {
    /**
     * hour 야간이면 야간의 상태로 시스템을 이행한다.
     * 여기에서 상태전환이 발생한다.
     *
     * @param context
     * @param hour
     */
    override fun doClock(context: Context, hour: Int) {
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.instance)
        }
    }

    override fun doUse(context: Context) {
        context.recordLog("금고사용 (주간)")
    }

    override fun doAlarm(context: Context) {
        context.callSecurityCenter("비상벨 (주간)")
    }

    override fun doPhone(context: Context) {
        context.callSecurityCenter("일반통화 (주간)")
    }

    override fun toString(): String {
        return "[주간]"
    }
}