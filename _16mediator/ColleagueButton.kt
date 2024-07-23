package _16mediator

import java.awt.Button

class ColleagueButton(
    caption: String
) : Button(caption), Colleague {
    private lateinit var mediator: Mediator

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun setColleagueEnabled(enabled: Boolean) {
        // setEnabled(enabled)
        this.isEnabled = enabled // 상속받고 있는 Button의 부모 클래스 Component의 isEnabled 필드를 활성화/비활성화 처리
    }
}
