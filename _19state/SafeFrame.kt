package _19state

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener


class SafeFrame(title: String?) : Frame(title), ActionListener, Context {
    private val textClock = TextField(60)
    private val textScreen = TextArea(10, 60)
    private val buttonUse: Button = Button("금고사용")
    private val buttonAlarm: Button = Button("비상벨")
    private val buttonPhone: Button = Button("일반통화")
    private val buttonExit: Button = Button("종료")

    private var state: State = DayState.instance

    init {
        background = Color.lightGray
        layout = BorderLayout()

        add(textClock, BorderLayout.NORTH)
        textClock.isEditable = false

        add(textScreen, BorderLayout.CENTER)
        textScreen.isEditable = false

        val panel = Panel()
        panel.add(buttonUse)
        panel.add(buttonAlarm)
        panel.add(buttonPhone)
        panel.add(buttonExit)

        add(panel, BorderLayout.SOUTH)

        pack()
        show()

        buttonUse.addActionListener(this)
        buttonAlarm.addActionListener(this)
        buttonPhone.addActionListener(this)
        buttonExit.addActionListener(this)
    }

    /**
     * 버튼이 눌러졌을 때 여기로 온다.
     *
     * @param e
     */
    override fun actionPerformed(e: ActionEvent) {
        println(e.toString())
        if (e.source === buttonUse) {
            state.doUse(this)
        } else if (e.source === buttonAlarm) {
            state.doAlarm(this)
        } else if (e.source === buttonPhone) {
            state.doPhone(this)
        } else if (e.source === buttonExit) {
            System.exit(0)
        } else {
            println("?")
        }
    }

    override fun setClock(hour: Int) {
        var clockString = "현재 시간은 ${if (hour < 10) "0$hour:00" else "$hour:00"}"

        println(clockString)
        textClock.text = clockString
        state.doClock(this, hour)
    }

    override fun changeState(state: State) {

        println("${this.state}에서 ${state}로 상태가 변화했습니다.")
        this.state = state
    }

    override fun callSecurityCenter(msg: String) {
        textScreen.append("call! $msg\n")
    }

    override fun recordLog(msg: String?) {
        textScreen.append("record ... $msg\n")
    }
}