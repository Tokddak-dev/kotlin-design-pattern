package _19state

interface State {
    fun doClock(context: Context, hour: Int) // 시간 설정

    fun doUse(context: Context) // 금고 사용

    fun doAlarm(context: Context) // 비상벨

    fun doPhone(context: Context) // 일반통화
}