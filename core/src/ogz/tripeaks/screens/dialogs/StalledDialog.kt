package ogz.tripeaks.screens.dialogs

import com.badlogic.gdx.scenes.scene2d.ui.Dialog
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.I18NBundle
import ogz.tripeaks.screens.controls.MyTextButton
import ogz.tripeaks.util.SkinData

class StalledDialog(
    skinData: SkinData,
    theme: String,
    val res: I18NBundle,
) :
    Dialog("", skinData.skin, theme) {

    val newGameButton = MyTextButton(res.get("newGameShort"), skinData, theme)
    val exitButton = MyTextButton(res.get("exit"), skinData, theme)
    val undoButton = MyTextButton(res.get("undoLast"), skinData, theme)
    val returnButton = MyTextButton(res.get("return"), skinData, theme)

    init {
        pad(16f, 24f, 16f, 24f)
        contentTable.add(Label(res.get("stalled"), skinData.skin, theme))
        buttonTable.apply {
            pad(4f, 4f, 0f, 4f)
            defaults().width(110f).pad(0f).space(0f)
            add(undoButton).spaceBottom(2f)
            row()
            add(newGameButton).spaceBottom(2f)
            row()
            add(returnButton)
            row()
            add(exitButton).spaceTop(skinData.exitButtonTopMargin).pad(0f)
        }
    }
}
