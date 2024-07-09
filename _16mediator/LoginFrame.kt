package _16mediator

import java.awt.CheckboxGroup
import java.awt.Color
import java.awt.Frame
import java.awt.GridLayout
import java.awt.Label
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.lang.System.exit
import kotlin.system.exitProcess

class LoginFrame(
    title: String
): Frame(title), ActionListener, Mediator {
    private lateinit var checkGuest: ColleagueCheckbox
    private lateinit var checkLogin: ColleagueCheckbox
    private lateinit var textUser: ColleagueTextField
    private lateinit var textPass: ColleagueTextField
    private lateinit var buttonOk: ColleagueButton
    private lateinit var buttonCancel: ColleagueButton

    init {
        background = Color.LIGHT_GRAY
        // 4x2 그리드
        layout = GridLayout(4,2)
        createColleagues()
        add(checkGuest)
        add(checkLogin)
        add(Label("Username: "))
        add(textUser)
        add(Label("Password: "))
        add(textPass)
        add(buttonOk)
        add(buttonCancel)

        colleagueChanged()

        pack()
        show() // Deprecated
    }
    override fun actionPerformed(e: ActionEvent?) {
        println(e.toString())
        exitProcess(0)
    }

    override fun createColleagues() {
        val g = CheckboxGroup()
        checkGuest = ColleagueCheckbox("Guest", g, true)
        checkLogin = ColleagueCheckbox("Login", g, false)
        textUser = ColleagueTextField("", 10)
        textPass = ColleagueTextField("", 10)
        textPass.echoChar = '*'
        buttonOk = ColleagueButton("OK")
        buttonCancel = ColleagueButton("Cancel")

        // Mediator의 세트
        checkGuest.setMediator(this)
        checkLogin.setMediator(this)
        textUser.setMediator(this)
        textPass.setMediator(this)
        buttonOk.setMediator(this)
        buttonCancel.setMediator(this)

        // Listener의 세트
        checkGuest.addItemListener(checkGuest)
        checkLogin.addItemListener(checkLogin)
        textUser.addTextListener(textUser)
        textPass.addTextListener(textPass)
        buttonOk.addActionListener(this)
        buttonCancel.addActionListener(this)
    }

    override fun colleagueChanged() {
        if(checkGuest.state) {
            textUser.setColleagueEnabled(false)
            textPass.setColleagueEnabled(false)
            buttonOk.setColleagueEnabled(true)
        } else {
            textUser.setColleagueEnabled(true)
            userpassChanged()
        }
    }

    private fun userpassChanged() {
        if(textUser.text.isNotEmpty()) {
           textPass.setColleagueEnabled(true)
           if(textPass.text.isNotEmpty()) {
               buttonOk.setColleagueEnabled(true)
           } else {
               buttonOk.setColleagueEnabled(false)
           }
        } else {
            textPass.setColleagueEnabled(false)
            buttonOk.setColleagueEnabled(false)
        }
    }
}