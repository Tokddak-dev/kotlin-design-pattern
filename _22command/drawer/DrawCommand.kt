package _22command.drawer

import _22command.command.Command
import java.awt.Point

class DrawCommand(
    private val drawable: Drawable,
    private val position: Point
) : Command {
    override fun execute() {
        drawable.draw(position.x, position.y)
    }
}