package _16mediator

import java.awt.Color
import java.awt.TextField
import java.awt.event.TextEvent
import java.awt.event.TextListener

class ColleagueTextField(
    text: String,
    columns: Int,
) : TextField(text, columns), TextListener, Colleague {
    private lateinit var mediator: Mediator

    override fun textValueChanged(e: TextEvent?) {
        mediator.colleagueChanged()
    }

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun setColleagueEnabled(enabled: Boolean) {
        isEnabled = enabled
        background = if (enabled) Color.WHITE else Color.LIGHT_GRAY
    }
}